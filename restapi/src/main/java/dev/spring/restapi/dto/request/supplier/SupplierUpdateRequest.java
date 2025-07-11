package dev.spring.restapi.dto.request.supplier;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierUpdateRequest {

    @Positive(message="Id değeri pozitif sayı olmak zorundadır.")
    private int id;
    @NotNull(message = "Firma adı boş olamaz")
    private  String  companyName;
    private  String  contactName;
    private  String  address;
    private  String  contactMail;


}
