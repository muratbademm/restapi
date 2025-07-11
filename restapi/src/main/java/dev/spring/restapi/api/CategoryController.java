package dev.spring.restapi.api;

import dev.spring.restapi.business.abstracts.ICategoryService;
import dev.spring.restapi.core.config.modelmapper.IModelMapperService;
import dev.spring.restapi.core.result.Result;
import dev.spring.restapi.core.result.ResultData;
import dev.spring.restapi.core.utilies.ResultHelper;
import dev.spring.restapi.dto.request.category.CategorySaveRequest;
import dev.spring.restapi.dto.request.category.CategoryUpdateRequest;
import dev.spring.restapi.dto.response.CursorResponse;
import dev.spring.restapi.dto.response.category.CategoryResponse;
import dev.spring.restapi.entities.Category;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;
    @Autowired
    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save (@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class)); //buradan gelen veri ResultHelper sınıfı içinden geri response olarak ekrana basılır
    }
    //Bu Controller:
    //✅ HTTP POST isteği alır → /v1/categories
    //✅ JSON veriyi alır → CategorySaveRequest
    //✅ DTO → Entity çevirir → ModelMapper ile
    //✅ Service ile DB’ye kayıt yapar
    //✅ Kayıt edilen entity’yi DTO’ya çevirir → Client’a JSON olarak döner
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") int id){
        Category category= this.categoryService.get(id);
        CategoryResponse categoryResponse= this.modelMapper.forResponse().map(category,CategoryResponse.class);
        return  ResultHelper.created(categoryResponse);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursor(
            @RequestParam(name = "page", required = false,defaultValue = "0")  int page ,//query parametrelerini alıyor
            @RequestParam(name = "pageSize",required = false,defaultValue = "2")int pageSize)
    {
      Page<Category> categoryPage =this.categoryService.cursor(page,pageSize);
      Page<CategoryResponse> categoryResponsePage= categoryPage.
              map(category -> this.modelMapper.forResponse().map(category,CategoryResponse.class));

    return ResultHelper.cursor(categoryResponsePage);  // her bir kategori categoryresponse a dönüştürcek
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> update (@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {

        Category updateCategory=  this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updateCategory);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateCategory, CategoryResponse.class)); //buradan gelen veri ResultHelper sınıfı içinden geri response olarak ekrana basılır
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id ){
        this.categoryService.delete(id);
        return ResultHelper.successResult();
    }
}
