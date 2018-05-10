package ph.groundgurus.simpledb.dao;

import org.springframework.data.repository.CrudRepository;
import ph.groundgurus.simpledb.entity.Product;

import java.util.List;

public interface ProductDao extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
