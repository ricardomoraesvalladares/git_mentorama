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
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String REQUEST_BODY = "{\n" +
            "        \"id\": 3,\n" +
            "        \"nome\": \"Caixa de som\",\n" +
            "        \"valor\": 300,\n" +
            "        \"quantidadeEmEstoque\": 10,\n" +
            "        \"descontoMaxPermitido\": 0.2\n" +
            "}";

    @Test
    public void deveCriarNovoProduto() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/produto").
                content(REQUEST_BODY).contentType("application/json")).andExpect(status().isOk());
    }

    @Test
    public void deveListarTodosProdutos() throws Exception{
        String expectedResponseBody =  "[{\"id\":1,\"nome\":\"TV\",\"valor\":1000.0,\"quantidadeEmEstoque\":10,\"descontoMaxPermitido\":0.1},{\"id\":2,\"nome\":\"Notebook\",\"valor\":2000.0,\"quantidadeEmEstoque\":20,\"descontoMaxPermitido\":0.15},{\"id\":3,\"nome\":\"Caixa de som\",\"valor\":300.0,\"quantidadeEmEstoque\":10,\"descontoMaxPermitido\":0.2}]";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/produto")).
                andExpect(status().isOk()).andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(expectedResponseBody, responseBody);
    }
}
