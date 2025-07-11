package dev.spring.restapi.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private int id;
    private  String  productName;
    private  double productPrice;
    private  int productStock;
    private int supplierId;
    private int categoryId;

}

