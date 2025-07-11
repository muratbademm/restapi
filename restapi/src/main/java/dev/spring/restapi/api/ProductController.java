package dev.spring.restapi.api;
import dev.spring.restapi.business.abstracts.ICategoryService;
import dev.spring.restapi.business.abstracts.IProductService;
import dev.spring.restapi.business.abstracts.ISupplierService;
import dev.spring.restapi.core.config.modelmapper.IModelMapperService;
import dev.spring.restapi.core.result.ResultData;
import dev.spring.restapi.core.utilies.ResultHelper;
import dev.spring.restapi.dto.request.category.CategorySaveRequest;
import dev.spring.restapi.dto.request.product.ProductSaveRequest;

import dev.spring.restapi.dto.response.category.CategoryResponse;
import dev.spring.restapi.dto.response.product.ProductResponse;
import dev.spring.restapi.entities.Category;
import dev.spring.restapi.entities.Product;
import dev.spring.restapi.entities.Supplier;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final IProductService productService;
    private final IModelMapperService modelMapper;
    private final ICategoryService categoryService;
    private  final ISupplierService supplierService;

    public ProductController(IProductService productService, IModelMapperService modelMapper, ICategoryService categoryService, ISupplierService supplierService) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ProductResponse> save (@Valid @RequestBody ProductSaveRequest productSaveRequest) {
        Product saveProduct = this.modelMapper.forRequest().map(productSaveRequest, Product.class);
        Category category =this.categoryService.get(productSaveRequest.getCategoryId());
        saveProduct.setCategory(category);
        Supplier supplier =this.supplierService.get(productSaveRequest.getSupplierId());
        saveProduct.setSupplier(supplier);

        this.productService.save(saveProduct);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveProduct, ProductResponse.class)); //buradan gelen veri ResultHelper sınıfı içinden geri response olarak ekrana basılır
    }

    @GetMapping("/{id}") //  /suppliers yazılırsa product ıcınden supplier verisini de çekebiliriz
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ProductResponse> get(@PathVariable("id") int id){ // supplierresponse yazılmalı veri çekilmek isteniyorsa
        Product product= this.productService.get(id);
        ProductResponse productResponse= this.modelMapper.forResponse().map(product,ProductResponse.class); //product.getSupplier ini alıp geriye SupplierResponse dönülmeli
        return  ResultHelper.created(productResponse);
    }


}
