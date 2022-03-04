package com.ahmetyasin.demogetir.repository;

import com.ahmetyasin.demogetir.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T> extends PagingAndSortingRepository<T, Integer>, JpaSpecificationExecutor<T>, JpaRepository<T,Integer> {

    @Override
    <S extends T> S save(S entity);
}
