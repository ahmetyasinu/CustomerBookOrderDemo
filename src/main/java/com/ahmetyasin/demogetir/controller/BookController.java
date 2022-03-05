package com.ahmetyasin.demogetir.controller;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.dto.BookDTO;
import com.ahmetyasin.demogetir.service.Impl.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value = "Book API")
public class BookController {


    @Autowired
    private BookServiceImpl bookService;



    @GetMapping("/list")
    @ApiOperation(value = "Book Entry",notes = "Book list RestApi")
    public List<BookDTO> listBook(Pageable pageable) {
        // get employees from db
        List<BookDTO> bookList = bookService.findAll(pageable);
        return bookList;
    }

    @DeleteMapping("/delete/{bookId}")
    @ApiOperation(value = "Book Entry",notes = "Book delete RestApi")
    public String deleteBook(@PathVariable Long bookId) {

        BookDTO book = bookService.findById(bookId);

        // throw exception if null

        if (book == null) {
            throw new RuntimeException("book id not found - " + bookId);
        }

        bookService.deleteById(bookId);

        return "Deleted book id - " + bookId;
    }

    @PostMapping("/add")
    @ApiOperation(value = "Book Entry",notes = "Book add RestApi")
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {

        bookService.save(bookDTO);

        return bookDTO;
    }

    @GetMapping("/{bookId}")
    @ApiOperation(value = "Book get Entry",notes = "Login get RestApi")
    public BookDTO getBook(@PathVariable Long bookId) {

        BookDTO book = bookService.findById(bookId);

        // throw exception if null

        if (book == null) {
            throw new RuntimeException("book id not found - " + bookId);
        }


        return book;
    }

    @PutMapping("/update/{bookId}")
    @ApiOperation(value = "Book Update",notes = "Book Update RestApi")
    public BookDTO updateBook(@PathVariable Long bookId ,@RequestBody BookDTO book) {
        BookDTO bookDTO = bookService.findById(bookId);
        if (bookId!=bookDTO.getId()){
            throw new RuntimeException("book id not match - " + bookId);
        }
        bookService.update(book,bookId);


        return book;
    }

}
