package by.pshsnk.shop.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class OrderDTO {
    private Long id;
    @NotEmpty
    private List<ProductDTO> products;
}
