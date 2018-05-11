package ph.groundgurus.simpledb.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ph.groundgurus.simpledb.dao.ProductDao;
import ph.groundgurus.simpledb.entity.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author Philip Mark Gutierrez
 * @since May 11, 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductService.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductDao productDao;

    private List<Product> products;
    private Product product;

    @Before
    public void setUp() {
        products = Arrays.asList(
                new Product(1L, "ballpen", BigDecimal.valueOf(5.0), "a ballpen"),
                new Product(2L, "notebook", BigDecimal.valueOf(20.0), "a notebook")
        );
        product = new Product(3L, "bag", BigDecimal.valueOf(500.0), "a bag");
    }

    @Test
    public void findAllProducts() {
        when(productDao.findAll()).thenReturn(products);

        assertThat(productService.findAllProducts())
                .hasSize(2)
                .isEqualTo(products);
    }

    @Test
    public void addProduct() {
        when(productDao.save(product)).thenReturn(product);

        when(productDao.findAll()).thenReturn(Collections.singletonList(product));

        productService.addProduct(product);

        assertThat(productService.findAllProducts())
                .hasSize(1)
                .contains(product);
    }
}