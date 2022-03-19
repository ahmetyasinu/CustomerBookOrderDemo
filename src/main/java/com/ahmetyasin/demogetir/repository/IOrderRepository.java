package com.ahmetyasin.demogetir.repository;

import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.dto.StatisticDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IOrderRepository extends BaseRepository<Order> {

    @Query("select a from Order a where a.startDate BETWEEN :startDate and :endDate")
    List<Order> betweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "select MONTHNAME(o.order_time) as Month,\n" +
            "       sum(distinct o.totalPrice) as TotalPurchaseAmount,\n" +
            "       count(distinct o2.orderId) as TotalOrderCount,\n" +
            "        sum(o2.count) as TotalBookCount\n" +
            "    from orders o\n" +
            "    inner join orderitem o2 on o.id = o2.orderId\n" +
            "    where o.customer_id = :customerId\n" +
            "    group by MONTHNAME(o.order_time)",
            nativeQuery = true)
    List<StatisticDto> getMonthlyStatistics(@Param("customerId") Long customerId);

    //Optional<Order> findByIdAndOrderId(Long id, Integer orderId);
    //List<Order> findAllByCreatedAtBetweenAndOrderId(LocalDateTime startDate, LocalDateTime endDate, Integer orderId);
    // List<Order> findAllByOrderId(Integer orderId);
}
