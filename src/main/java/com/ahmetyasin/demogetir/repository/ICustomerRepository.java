package com.ahmetyasin.demogetir.repository;

import com.ahmetyasin.demogetir.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends BaseRepository<Customer> {

    /*@Query("select a from Login a where a.startDate BETWEEN :startDate and :endDate")
    List<Login> betweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);*/
    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}
