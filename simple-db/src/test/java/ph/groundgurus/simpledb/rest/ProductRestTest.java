package ph.groundgurus.simpledb.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ph.groundgurus.simpledb.entity.Product;
import ph.groundgurus.simpledb.service.ProductService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Philip Mark Gutierrez
 * @since May 11, 2018
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductRest.class)
public class ProductRestTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Product> products;

    @Before
    public void setUp() {
        products = Arrays.asList(
                new Product(1L, "ballpen", BigDecimal.valueOf(5.0), "a ballpen"),
                new Product(2L, "notebook", BigDecimal.valueOf(20.0), "a notebook")
        );
    }

    @Test
    public void findAllProducts() throws Exception {
        when(productService.findAllProducts()).thenReturn(products);

        String foodsAsString = objectMapper.writeValueAsString(products);

        mockMvc.perform(get("/product")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(foodsAsString));
    }

    @Test
    public void addProduct() throws Exception {
        Product product = new Product(3L, "bag", BigDecimal.valueOf(500.0), "a bag");

        doNothing().when(productService).addProduct(product);

        mockMvc.perform(post("/product")
                .content(objectMapper.writeValueAsBytes(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}