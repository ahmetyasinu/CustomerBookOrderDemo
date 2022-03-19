package com.ahmetyasin.demogetir.book;

import com.ahmetyasin.demogetir.entity.Book;
import com.ahmetyasin.demogetir.entity.dto.BookDTO;
import com.ahmetyasin.demogetir.repository.IBookRepository;
import com.ahmetyasin.demogetir.user.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private IBookRepository repository;


    @Test
    void findAll() {
        Book book= new Book();
        book.setName("Suç ve Ceza");
        book.setPageSize(500);
        book.setPrice(100);
        book.setAuthor("Dostoyevski");
        book.setStock(20);

        when(repository.findAll()).thenReturn(Collections.singletonList(book));
        List<BookDTO> bookDTOS = bookService.findAll(Pageable.unpaged());

        assertEquals(bookDTOS.size(), 1);
    }


    @Test
    void testSave() {
        BookDTO bookDTO= new BookDTO();
        bookDTO.setName("Suç ve Ceza");
        bookDTO.setPageSize(500);
        bookDTO.setPrice(100);
        bookDTO.setAuthor("Dostoyevski");
        bookDTO.setStock(20);


        Book bookMock = mock(Book.class);

        when(repository.save(ArgumentMatchers.any(Book.class))).thenReturn(bookMock);
        BookDTO result =bookService.save(bookDTO);

        assertEquals(result.getName(), bookDTO.getName());
    }

    @Test
    void findById() {
        long id=1;
        bookService.findById(id);
    }


    @Test
    void deleteById() {
        long id=1;
        bookService.deleteById(id);

    }

    @Test
    void update() {
        BookDTO bookDTO= new BookDTO();
        bookDTO.setId((long) 1);
        bookDTO.setName("Suç ve Ceza");
        bookDTO.setPageSize(500);
        bookDTO.setPrice(100);
        bookDTO.setAuthor("Dostoyevski");
        bookDTO.setStock(20);

        bookService.update(bookDTO,bookDTO.getId());

    }
}