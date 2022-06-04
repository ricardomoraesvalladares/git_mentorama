package br.com.ricardo.produto.produto.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VendaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void DeveRetornarValorVenda() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/venda"))
                .andExpect(status().isOk()).andReturn();
        Double result = Double.parseDouble(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(1800.0, result);
    }

}
