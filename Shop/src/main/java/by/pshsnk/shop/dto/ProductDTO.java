package by.pshsnk.shop.dto;

import jakarta.validation.constraints.NotEmpty;

public class ProductDTO {
    private Long id;
    @NotEmpty
    private String name;

}
