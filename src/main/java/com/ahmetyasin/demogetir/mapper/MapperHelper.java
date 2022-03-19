package com.ahmetyasin.demogetir.mapper;


import com.ahmetyasin.demogetir.entity.base.BaseEntity;
import com.ahmetyasin.demogetir.entity.dto.BaseDTO;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MapperHelper {

    private static MapperFacade orikaMapper;

    private MapperHelper() {
    }

    public static <E extends BaseEntity, M extends BaseDTO> M convert(E entity, Class<? extends M> modelClass) {
        return getOrikaMapper().map(entity, modelClass);
    }

    public static <E extends BaseEntity, M extends BaseDTO> E convertBack(M model, Class<? extends E> entityClass) {
        return getOrikaMapper().map(model, entityClass);
    }

    public static <E extends BaseEntity, M extends BaseDTO> List<M> convertAll(List<E> entities, Class<? extends M> modelClass) {
        return entities.stream().map(entity -> convert(entity, modelClass)).collect(Collectors.toList());
    }

    public static <E extends BaseEntity, M extends BaseDTO> List<E> convertAllBack(List<M> models, Class<? extends E> entityClass) {
        return models.stream().map(model -> convertBack(model, entityClass)).collect(Collectors.toList());
    }

    public static MapperFacade getMapper() {
        return MapperHelper.getOrikaMapper();
    }

    private static MapperFacade getOrikaMapper() {

        if (orikaMapper == null)
            initOrikaMapper();

        return orikaMapper;

    }

    private static void initOrikaMapper() {


        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        ConverterFactory converterFactory = mapperFactory.getConverterFactory();

        converterFactory.registerConverter(new EmptyStringConverter());

        orikaMapper = mapperFactory.getMapperFacade();

    }

    private static class EmptyStringConverter extends CustomConverter<String, String> {

        @Override
        public String convert(String value, Type<? extends String> type, MappingContext mappingContext) {
            return StringUtils.isBlank(value) ? null : value;
        }

    }
}
