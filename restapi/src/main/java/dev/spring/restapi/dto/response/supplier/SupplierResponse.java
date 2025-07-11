package dev.spring.restapi.dto.response.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponse {
    private int id;
    private  String companyName;
    //Bu katman  bazı verileri gizlemek için yapıldı.
}

