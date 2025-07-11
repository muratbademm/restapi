package dev.spring.restapi.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {

        private  String  productName;
        private  double productPrice;
        private  int productStock;
        private int supplierId;
        private int categoryId;

}
