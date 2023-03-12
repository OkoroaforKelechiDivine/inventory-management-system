package com.mintyn.inventorymanagement.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mintyn.inventorymanagement.dto.ProductDTO;
import com.mintyn.inventorymanagement.service.product.ProductServiceImplementation;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductDTO productDto;

    @MockBean
    ProductServiceImplementation productService;

    @BeforeEach
    public void setUp() {
        productDto.setPrice(233.5);
        productDto.setName("Controller Product name");
        productDto.setDescription("This is a controller product description");
        productDto.setStockAvailability(34);
    }

    @Test
    @DisplayName("Create Product")
    public void test_createProduct() throws Exception {
        given(productService.createProduct(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));
        ResultActions response = mockMvc.perform(post("/api/products/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)));
        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", CoreMatchers.is(productDto.getPrice())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.stock", CoreMatchers.is(productDto.getStockAvailability())));
    }
}