package kg.itschool.ideaservice.controllers;


import kg.itschool.ideaservice.models.dtos.IdeaDTO;
import kg.itschool.ideaservice.models.dtos.UserIdeasDto;
import kg.itschool.ideaservice.models.entities.Idea;
import kg.itschool.ideaservice.services.IdeaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/idea")
public class IdeaController {

    private IdeaService ideaService;

    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }


    @PostMapping("/save")
    public IdeaDTO save(@RequestBody IdeaDTO ideaDTO){
        return ideaService.save(ideaDTO);
    }


    @GetMapping("/user/get")
    public List<UserIdeasDto> getAllUserIdeas(@RequestParam String phone){
        //все его идеи
        return null;
    }
}
