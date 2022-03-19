package com.ahmetyasin.demogetir.user;

import com.ahmetyasin.demogetir.entity.OrderItem;
import com.ahmetyasin.demogetir.entity.dto.OrderItemDTO;
import com.ahmetyasin.demogetir.mapper.MapperHelper;
import com.ahmetyasin.demogetir.repository.IOrderItemRepository;
import com.ahmetyasin.demogetir.service.OrderItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    IOrderItemRepository repository;
    private final Logger logger = LoggerFactory.getLogger(OrderItemService.class);


    @Override
    public List<OrderItemDTO> findAll(Pageable pageable) {
        logger.info("Finding all {} datas.", OrderItem.class);
        List<OrderItem> orderItems = (List<OrderItem>) this.repository.findAll(pageable);
        return MapperHelper.convertAll(orderItems, OrderItemDTO.class);
    }

    @Override
    public OrderItemDTO findById(Long id) {
        logger.info("Finding by Id {} datas.", OrderItem.class);

        Optional<OrderItem> result = repository.findById(id);
        OrderItem orderItem = null;

        if (result.isPresent()) {
            orderItem = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find orderItem id - " + id);
        }

        return MapperHelper.convert(orderItem, OrderItemDTO.class);
    }

    @Transactional
    @Override
    public void save(OrderItemDTO orderItemDTO) {
        logger.info("save by {} datas.", OrderItem.class);

        repository.save(MapperHelper.convertBack(orderItemDTO, OrderItem.class));

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        logger.info("delete by {} datas.", OrderItem.class);

        repository.deleteById(id);

    }

    @Transactional
    @Override
    public void update(OrderItemDTO orderItemDTO, Long id) {
        logger.info("update by {} datas.", OrderItem.class);

        OrderItem orderItem1 = MapperHelper.convertBack(orderItemDTO, OrderItem.class);
        repository.save(orderItem1);
    }


}
