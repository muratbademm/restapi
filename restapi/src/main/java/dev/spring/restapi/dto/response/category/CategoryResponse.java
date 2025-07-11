package dev.spring.restapi.dto.response.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private int id;
    private  String name;
    //Bu katman  bazı verileri gizlemek için yapıldı.
}
