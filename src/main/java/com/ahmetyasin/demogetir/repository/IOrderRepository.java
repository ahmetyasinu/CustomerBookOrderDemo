package com.ahmetyasin.demogetir.repository;

import com.ahmetyasin.demogetir.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IOrderRepository extends BaseRepository<Order> {

    //@Query("select a from Order a where a.createdDate BETWEEN :createdDate and :endDate")
    //List<Order> betweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //Optional<Order> findByIdAndOrderId(Long id, Integer orderId);
    //List<Order> findAllByCreatedAtBetweenAndOrderId(LocalDateTime startDate, LocalDateTime endDate, Integer orderId);
   // List<Order> findAllByOrderId(Integer orderId);
}
