package by.pshsnk.shop.mappers;


import by.pshsnk.shop.dto.UserDTO;
import by.pshsnk.shop.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
    User toUser(UserDTO userDTO);
}
