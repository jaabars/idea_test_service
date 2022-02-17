package kg.itschool.ideaservice.controllers;

import kg.itschool.ideaservice.models.dtos.UserDTO;
import kg.itschool.ideaservice.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @PostMapping("/confirm")
    public String confirmUserCode(@RequestBody UserDTO userConfirmDto){
        //
        return userService.confirm(userConfirmDto);
    }
}
