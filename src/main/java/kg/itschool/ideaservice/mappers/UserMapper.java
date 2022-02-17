package kg.itschool.ideaservice.mappers;


import kg.itschool.ideaservice.models.dtos.UserDTO;
import kg.itschool.ideaservice.models.dtos.UserEntityDto;
import kg.itschool.ideaservice.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntityDto toUserDto(User user);
    User toUser(UserEntityDto userEntityDto);

    default User userDTOtoUser(UserDTO userDTO){
        User user = new User();
        user.setPhone(userDTO.getPhone());
        user.setCode(userDTO.getCode());
        return user;
    }
}
