package dev.spring.restapi.business.concretes;

import dev.spring.restapi.business.abstracts.ICategoryService;
import dev.spring.restapi.core.exception.NotFoundException;
import dev.spring.restapi.core.utilies.Msg;
import dev.spring.restapi.dao.CategoryRepo;
import dev.spring.restapi.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {
    //  @Autowired  Bu da bi IOC ÖRNEĞİ
    //  private  CategoryRepo categoryRepo;
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepo.save(category);
    }

    @Override
    public boolean delete(int id) {
        Category category =this.get(id);
        this.categoryRepo.delete(category);
        return true;
    }


}
