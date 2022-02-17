package kg.itschool.ideaservice.services;

import kg.itschool.ideaservice.models.dtos.UserDTO;
import kg.itschool.ideaservice.models.dtos.UserEntityDto;


public interface UserService {


    UserEntityDto findByPhone(String phone);

    String save(UserDTO userDTO);

    String confirm(UserDTO userConfirmDto);
}
