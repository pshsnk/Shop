package by.pshsnk.shop.mappers;

import by.pshsnk.shop.dto.ProductDTO;
import by.pshsnk.shop.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO toDTO(Product product);
    Product toProduct(ProductDTO productDTO);

}
