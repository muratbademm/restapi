package dev.spring.restapi.business.abstracts;

import dev.spring.restapi.entities.Category;
import dev.spring.restapi.entities.Product;
import org.springframework.data.domain.Page;

public interface IProductService {
    Product save(Product product);
    Product get(int id);
    Page<Product> cursor(int page, int pageSize); //Sayfalandırma yapısı kurulacak hangi sayfa ve her sayfa da ne kadar veri istiyorsun.
    Product update(Product product);
    boolean delete(int id);
}
