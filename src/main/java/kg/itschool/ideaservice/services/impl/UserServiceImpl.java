package kg.itschool.ideaservice.services.impl;

import kg.itschool.ideaservice.dao.UserRepo;
import kg.itschool.ideaservice.mappers.UserMapper;
import kg.itschool.ideaservice.models.dtos.UserDTO;
import kg.itschool.ideaservice.models.dtos.UserEntityDto;
import kg.itschool.ideaservice.models.entities.User;
import kg.itschool.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserEntityDto findByPhone(String phone) {
        User user = userRepo.findByPhone(phone);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    @Override
    public String save(UserDTO userDTO) {
        boolean exist = userRepo.existsByPhone(userDTO.getPhone());
        if (exist){
            //throw
        }
        User user = UserMapper.INSTANCE.userDTOtoUser(userDTO);
        String code = generateRandomCode();
        user.setCode(code);
        user =userRepo.save(user);
        return "ваш код подтверждения-"+user.getCode();
    }

    @Override
    public String confirm(UserDTO userConfirmDto) {
        User user = userRepo.findByPhone(userConfirmDto.getPhone());
        if (!user.getCode().equals(userConfirmDto.getCode())){
            //код не совпадает
        }
        user.setActivated(true);
        userRepo.save(user);

        return "регистрация прошла успешно";
    }

    // Math.floor(Math.random()*(max-min+1)+min)
    private String generateRandomCode() {
        int code = (int) (Math.random()*(9999-1000+1)+1000);
        return String.valueOf(code);
    }


    //метод который получает UserDto
    //проверяет есть ли уже такой пользователь если есть то ошибка UserAlreadyExist
    //сохраняете как нового пользователя
    //генерируете 4-х значный случайный код 8657
    //возвращаете ответ "ваш код подтверждения-8657"

    /**
     *
     * */


    //метод по номеру телефона находит пользователя если нет то ошибка UserNotFound
    //проверяет на активность если активирован то ответ Вы уже были активированы
    //то проверить код и если совпадает то активировать
    //и вернуть ответ успешно теперь можете отправлять нам идеи
}
