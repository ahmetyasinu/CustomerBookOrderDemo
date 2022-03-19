package com.ahmetyasin.demogetir.controller;

import com.ahmetyasin.demogetir.entity.dto.BookDTO;
import com.ahmetyasin.demogetir.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BookController.class)
class BookControllerTest {

    private final static String CONTENT_TYPE = "application/json";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        // given
        BookDTO book = new BookDTO();
        book.setStock(12);
        book.setAuthor("ali");
        book.setPageSize(12);
        book.setName("Alinin kitabı");

        // when
        ResultActions actions = mockMvc.perform(post("/book/add")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(book)));

        // then
        ArgumentCaptor<BookDTO> captor = ArgumentCaptor.forClass(BookDTO.class);
        verify(bookService, times(1)).save(captor.capture());
        assertThat(captor.getValue().getName()).isEqualTo("Alinin kitabı");
        assertThat(captor.getValue().getAuthor()).isEqualTo("ali");
        actions.andExpect(status().isOk());
    }

    @Test
    void whenInvalidInput_thenReturns400() throws Exception {

        BookDTO book = new BookDTO();
        book.setStock(12);
        book.setPageSize(12);

        // when
        ResultActions actions = mockMvc.perform(post("/book/add")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(book)));

        // then
        actions.andExpect(status().isBadRequest());
    }

    @Test
    void whenCallTumunuListele_thenReturns200() throws Exception {
        // given
        BookDTO book = new BookDTO();
        book.setStock(12);
        book.setAuthor("ali");
        book.setPageSize(12);
        book.setName("Alinin kitabı");
        when(bookService.findAll(Pageable.unpaged())).thenReturn(Arrays.asList(book));

        // when
        MvcResult mvcResult = mockMvc.perform(get("/book/list")
                .accept(CONTENT_TYPE)).andReturn();


        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(bookService, times(1)).findAll(Pageable.unpaged());
        assertThat(objectMapper.writeValueAsString(Arrays.asList(book)))
                .isEqualToIgnoringWhitespace(responseBody);
    }

    @Test
    void whenCallTumunuListele_thenReturnsNoData() throws Exception {
        // given
        when(bookService.findAll(Pageable.unpaged())).thenReturn(Collections.emptyList());

        // when
        MvcResult mvcResult = mockMvc.perform(get("/book/list")
                .accept(CONTENT_TYPE)).andReturn();

        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(bookService, times(1)).findAll(Pageable.unpaged());
        assertThat(objectMapper.writeValueAsString(Collections.emptyList()))
                .isEqualToIgnoringWhitespace(responseBody);
    }
}