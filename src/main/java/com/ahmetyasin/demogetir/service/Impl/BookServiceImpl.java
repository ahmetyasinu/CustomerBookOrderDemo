package com.ahmetyasin.demogetir.service.Impl;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.User;
import com.ahmetyasin.demogetir.entity.dto.BaseDTO;
import com.ahmetyasin.demogetir.entity.dto.BookDTO;
import com.ahmetyasin.demogetir.entity.dto.UserDto;
import com.ahmetyasin.demogetir.mapper.MapperHelper;
import com.ahmetyasin.demogetir.repository.IBookRepository;
import com.ahmetyasin.demogetir.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    IBookRepository repository;
    MapperHelper orikaMapper;


    @Override
    public List<Book> findAll() {
        List<Book> books=this.repository.findAll();
        return books;
    }

    @Override
    public Book findById(int id) {



        Optional<Book> result = repository.findById(id);
        Book book = null;

        if (result.isPresent()) {
            book = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return book;
    }

    @Override
    public void save(Book book) {
        repository.save(book);

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    public void update(Book book, int id) {
        repository.save(book);
    }


}
