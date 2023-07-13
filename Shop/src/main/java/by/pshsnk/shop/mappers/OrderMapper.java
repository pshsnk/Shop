package by.pshsnk.shop.mappers;

import by.pshsnk.shop.dto.OrderDTO;
import by.pshsnk.shop.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDTO toDTO(Order order);
    Order toOrder(OrderDTO orderDTO);
}
