package ph.groundgurus.simpledb.service;

import org.springframework.stereotype.Service;
import ph.groundgurus.simpledb.dao.ProductDao;
import ph.groundgurus.simpledb.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    @Transactional
    public void addProduct(Product product) {
        productDao.save(product);
    }
}
