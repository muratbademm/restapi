package dev.spring.restapi.business.abstracts;

import dev.spring.restapi.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Category save(Category category);
    Category get(int id);
    Page<Category> cursor(int page, int pageSize); //Sayfalandırma yapısı kurulacak hangi sayfa ve her sayfa da ne kadar veri istiyorsun.
    Category update(Category category);
    boolean delete(int id);
}
