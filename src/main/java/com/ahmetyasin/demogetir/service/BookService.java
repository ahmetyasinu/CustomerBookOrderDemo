package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.dto.BookDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public List<BookDTO> findAll(Pageable pageable);

    public BookDTO findById(Long id);

    public BookDTO save(BookDTO bookDTO);

    public void deleteById(Long id);

    public void update(BookDTO bookDTO, Long id);

}
