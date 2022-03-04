package com.ahmetyasin.demogetir.service;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {

    public List<Book> findAll();
    public Book findById(int id);
    public void save(Book book);
    public void deleteById(int id);
    public void update(Book book, int id);

}
