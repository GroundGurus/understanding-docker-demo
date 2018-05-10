package ph.groundgurus.simpledb.rest;

import org.springframework.web.bind.annotation.*;
import ph.groundgurus.simpledb.entity.Product;
import ph.groundgurus.simpledb.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRest {
    private final ProductService productService;

    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}
