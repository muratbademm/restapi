package dev.spring.restapi.business.concretes;


import dev.spring.restapi.business.abstracts.ISupplierService;
import dev.spring.restapi.core.exception.NotFoundException;
import dev.spring.restapi.core.utilies.Msg;
import dev.spring.restapi.dao.SupplierRepo;
import dev.spring.restapi.entities.Category;
import dev.spring.restapi.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierManager implements ISupplierService {
    private  final SupplierRepo supplierRepo;

    public SupplierManager(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }


    @Override
    public Supplier save(Supplier supplier) {
        return this.supplierRepo.save(supplier);
    } // Dışarıdan gelen veriyi (Supplier) → repo’ya kaydeder.
      // Kayıt başarılı olursa, kayıtlı objeyi geri döner.

    @Override
    public Supplier get(int id) {
        return this.supplierRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Supplier> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.supplierRepo.findAll(pageable);
    } // Veritabanındaki Supplier kayıtlarını sayfa sayfa getiriyor.
      // Yani pagination (sayfalama) işlemi yapıyor.

    @Override
    public Supplier update(Supplier supplier) {
        this.get(supplier.getId());
        return this.supplierRepo.save(supplier);
    }

    @Override
    public boolean delete(int id) {
        Supplier supplier =this.get(id);
        this.supplierRepo.delete(supplier);
        return true;
    }
}
