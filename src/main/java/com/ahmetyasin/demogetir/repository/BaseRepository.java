package com.ahmetyasin.demogetir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T> extends PagingAndSortingRepository<T, Long>, JpaSpecificationExecutor<T>, JpaRepository<T,Long> {

    @Override
    <S extends T> S save(S entity);
}
