package com.ahmetyasin.demogetir.customer;

import com.ahmetyasin.demogetir.controller.CustomerController;
import com.ahmetyasin.demogetir.entity.dto.CustomerDTO;
import com.ahmetyasin.demogetir.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

    private final static String CONTENT_TYPE = "application/json";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        // given
        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setEmail("ahmetyasinuzun@getir.com");
        customerDTO.setPassword("getir");
        customerDTO.setUsername("ayu");

        // when
        ResultActions actions = mockMvc.perform(post("/customer/save")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(customerDTO)));

        // then
        ArgumentCaptor<CustomerDTO> captor = ArgumentCaptor.forClass(CustomerDTO.class);
        verify(customerService, times(1)).save(captor.capture());
        assertThat(captor.getValue().getEmail()).isEqualTo("ahmetyasinuzun@getir.com");
        assertThat(captor.getValue().getUsername()).isEqualTo("ayu");
        actions.andExpect(status().isOk());
    }

    @Test
    void whenValidInput_thenReturns400() throws Exception {
        // given
        CustomerDTO customerDTO= new CustomerDTO();

        // when
        ResultActions actions = mockMvc.perform(post("/customer/save")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString("test-value")));

        // then
        actions.andExpect(status().isBadRequest());
    }


    @Test
    void whenCallTumunuListele_thenReturns200() throws Exception {
        // given
        CustomerDTO customerDTO= new CustomerDTO();

        when(customerService.findAll()).thenReturn(Arrays.asList(customerDTO));

        // when
        MvcResult mvcResult = mockMvc.perform(get("/customer/list")
                .accept(CONTENT_TYPE)).andReturn();


        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(customerService, times(1)).findAll();
        assertThat(objectMapper.writeValueAsString(Arrays.asList(customerDTO)))
                .isEqualToIgnoringWhitespace(responseBody);
    }

    @Test
    void whenCallTumunuListele_thenReturnsNoData() throws Exception {
        // given
        when(customerService.findAll()).thenReturn(Collections.emptyList());

        // when
        MvcResult mvcResult = mockMvc.perform(get("/customer/list")
                .accept(CONTENT_TYPE)).andReturn();

        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(customerService, times(1)).findAll();
        assertThat(objectMapper.writeValueAsString(Collections.emptyList()))
                .isEqualToIgnoringWhitespace(responseBody);
    }
}