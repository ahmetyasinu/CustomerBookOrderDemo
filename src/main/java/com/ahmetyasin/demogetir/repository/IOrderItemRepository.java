package com.ahmetyasin.demogetir.repository;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderItemRepository extends BaseRepository<OrderItem> {

    /*@Query("select a from Login a where a.startDate BETWEEN :startDate and :endDate")
    List<Login> betweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);*/


}
