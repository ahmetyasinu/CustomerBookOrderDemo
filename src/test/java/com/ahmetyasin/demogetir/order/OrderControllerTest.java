package com.ahmetyasin.demogetir.order;

import com.ahmetyasin.demogetir.controller.OrderController;
import com.ahmetyasin.demogetir.entity.Order;
import com.ahmetyasin.demogetir.entity.dto.CustomerDTO;
import com.ahmetyasin.demogetir.entity.dto.OrderDTO;
import com.ahmetyasin.demogetir.service.CustomerService;
import com.ahmetyasin.demogetir.service.OrderService;
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
@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {

    private final static String CONTENT_TYPE = "application/json";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderService orderService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        // given
        OrderDTO orderDTO= new OrderDTO();
        orderDTO.setPrice(222);
        orderDTO.setCustomerId(1);

        // when
        ResultActions actions = mockMvc.perform(post("/order/save")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(orderDTO)));

        // then
        ArgumentCaptor<OrderDTO> captor = ArgumentCaptor.forClass(OrderDTO.class);
        verify(orderService, times(1)).save(captor.capture());
        assertThat(captor.getValue().getPrice()).isEqualTo(222);
        assertThat(captor.getValue().getCustomerId()).isEqualTo(1);
        actions.andExpect(status().isOk());
    }

    @Test
    void whenValidInput_thenReturns400() throws Exception {
        // given
        OrderDTO orderDTO= new OrderDTO();

        // when
        ResultActions actions = mockMvc.perform(post("/order/save")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString("test-value")));

        // then
        actions.andExpect(status().isBadRequest());
    }


    @Test
    void whenCallTumunuListele_thenReturns200() throws Exception {
        // given
        OrderDTO orderDTO= new OrderDTO();

        when(orderService.findAll(Pageable.unpaged())).thenReturn(Arrays.asList(orderDTO));

        // when
        MvcResult mvcResult = mockMvc.perform(get("/order/list")
                .accept(CONTENT_TYPE)).andReturn();


        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(orderService, times(1)).findAll(Pageable.unpaged());
        assertThat(objectMapper.writeValueAsString(Arrays.asList(orderDTO)))
                .isEqualToIgnoringWhitespace(responseBody);
    }

    @Test
    void whenCallTumunuListele_thenReturnsNoData() throws Exception {
        // given
        when(orderService.findAll(Pageable.unpaged())).thenReturn(Collections.emptyList());

        // when
        MvcResult mvcResult = mockMvc.perform(get("/order/list")
                .accept(CONTENT_TYPE)).andReturn();

        // then
        String responseBody = mvcResult.getResponse().getContentAsString();
        verify(orderService, times(1)).findAll(Pageable.unpaged());
        assertThat(objectMapper.writeValueAsString(Collections.emptyList()))
                .isEqualToIgnoringWhitespace(responseBody);
    }
}