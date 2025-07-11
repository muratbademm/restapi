package dev.spring.restapi.business.abstracts;

import dev.spring.restapi.entities.Supplier;
import org.springframework.data.domain.Page;

public interface ISupplierService {
    Supplier save(Supplier supplier);
    Supplier get(int id);
    Page<Supplier> cursor(int page, int pageSize); //Sayfalandırma yapısı kurulacak hangi sayfa ve her sayfa da ne kadar veri istiyorsun.
    Supplier update(Supplier supplier);
    boolean delete(int id);
}
