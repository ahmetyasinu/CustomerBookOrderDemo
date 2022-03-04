package com.ahmetyasin.demogetir.repository;

import com.ahmetyasin.demogetir.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderRepository extends BaseRepository<Order> {

    /*@Query("select a from Login a where a.startDate BETWEEN :startDate and :endDate")
    List<Login> betweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);*/

    Optional<Order> findByIdAndOrderId(Integer id, Integer orderId);

    List<Order> findAllByCreatedAtBetweenAndOrderId(LocalDateTime startDate, LocalDateTime endDate, Integer orderId);

    List<Order> findAllByOrderId(Integer orderId);
}
