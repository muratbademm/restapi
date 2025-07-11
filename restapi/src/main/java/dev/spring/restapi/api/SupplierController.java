package dev.spring.restapi.api;

import dev.spring.restapi.business.abstracts.ISupplierService;
import dev.spring.restapi.core.config.modelmapper.IModelMapperService;
import dev.spring.restapi.core.result.Result;
import dev.spring.restapi.core.result.ResultData;
import dev.spring.restapi.core.utilies.ResultHelper;
import dev.spring.restapi.dto.request.category.CategorySaveRequest;
import dev.spring.restapi.dto.request.category.CategoryUpdateRequest;
import dev.spring.restapi.dto.request.supplier.SupplierSaveRequest;
import dev.spring.restapi.dto.request.supplier.SupplierUpdateRequest;
import dev.spring.restapi.dto.response.CursorResponse;
import dev.spring.restapi.dto.response.category.CategoryResponse;
import dev.spring.restapi.dto.response.supplier.SupplierResponse;
import dev.spring.restapi.entities.Category;
import dev.spring.restapi.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {
    private final ISupplierService supplierService;
    private final IModelMapperService modelMapper;
    public SupplierController(ISupplierService supplierService, IModelMapperService modelMapper) {
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SupplierResponse> save (@Valid @RequestBody SupplierSaveRequest supplierSaveRequest) {
        Supplier saveSupplier = this.modelMapper.forRequest().map(supplierSaveRequest, Supplier.class);
        this.supplierService.save(saveSupplier);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveSupplier, SupplierResponse.class)); //buradan gelen veri ResultHelper sınıfı içinden geri response olarak ekrana basılır
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> update (@Valid @RequestBody SupplierUpdateRequest supplierUpdateRequest) {

        Supplier updateSupplier=  this.modelMapper.forRequest().map(supplierUpdateRequest, Supplier.class);
        this.supplierService.update(updateSupplier);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateSupplier, SupplierResponse.class)); //buradan gelen veri ResultHelper sınıfı içinden geri response olarak ekrana basılır
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> get(@PathVariable("id") int id){
        Supplier supplier= this.supplierService.get(id);
        SupplierResponse supplierResponse= this.modelMapper.forResponse().map(supplier,SupplierResponse.class);
        return  ResultHelper.created(supplierResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<SupplierResponse>> cursor(
            @RequestParam(name = "page", required = false,defaultValue = "0")  int page ,//query parametrelerini alıyor
            @RequestParam(name = "pageSize",required = false,defaultValue = "2")int pageSize)
    {
        Page<Supplier> supplierPage =this.supplierService.cursor(page,pageSize);
        Page<SupplierResponse> supplierResponsePage= supplierPage.
                map(supplier -> this.modelMapper.forResponse().map(supplier,SupplierResponse.class));

        return ResultHelper.cursor(supplierResponsePage);  // her bir kategori categoryresponse a dönüştürcek
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id ){
        this.supplierService.delete(id);
        return ResultHelper.successResult();
    }

}
