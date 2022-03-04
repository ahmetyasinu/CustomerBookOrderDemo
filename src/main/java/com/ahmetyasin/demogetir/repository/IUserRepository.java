package com.ahmetyasin.demogetir.repository;

import com.ahmetyasin.demogetir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends BaseRepository<User> {

    /*@Query("select a from Login a where a.startDate BETWEEN :startDate and :endDate")
    List<Login> betweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);*/

}
