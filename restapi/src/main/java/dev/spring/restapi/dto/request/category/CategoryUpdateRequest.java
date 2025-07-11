package dev.spring.restapi.dto.request.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateRequest {
    @NotNull(message = "Kategori boş olamaz")
    private  String name;

    @Positive(message="Id değeri pozitif sayı olmak zorundadır.")
    private  int id;
}
