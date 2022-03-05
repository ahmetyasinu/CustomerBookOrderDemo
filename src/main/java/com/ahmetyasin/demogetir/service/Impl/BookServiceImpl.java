package com.ahmetyasin.demogetir.service.Impl;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.dto.BookDTO;
import com.ahmetyasin.demogetir.mapper.MapperHelper;
import com.ahmetyasin.demogetir.repository.IBookRepository;
import com.ahmetyasin.demogetir.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ApiOperation(value = "Book Servis")
public class BookServiceImpl implements BookService {

    @Autowired
    IBookRepository repository;

    private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public List findAll(Pageable pageable) {
        logger.info("Finding all {} datas.", Book.class);
        List<Book> books = this.repository.findAll();
        return MapperHelper.convertAll(books,BookDTO.class);
    }

    @Override
    public BookDTO findById(Long id) {

        logger.info("Finding by {} datas.", Book.class);

        Optional<Book> result = repository.findById(id);
        Book book;
        if (result.isPresent()) {
            book = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find book id - " + id);
        }

        return MapperHelper.convert(book,BookDTO.class);
    }

    @Override
    public void save(BookDTO bookDTO) {
        logger.info("Save  {} datas.", Book.class);

        repository.save(MapperHelper.convertBack(bookDTO,Book.class));

    }

    @Override
    public void deleteById(Long id) {
        logger.info("delete {} datas."+id, Book.class);

        repository.deleteById(id);

    }

    @Override
    public void update(BookDTO bookDTO, Long id) {
        logger.info("Update {} book - ."+id, Book.class);

        if (bookDTO.getId() != id) {
            throw new RuntimeException("Id ler eşleşmedi.");
        }

        repository.save(MapperHelper.convertBack(bookDTO,Book.class));
    }


}
