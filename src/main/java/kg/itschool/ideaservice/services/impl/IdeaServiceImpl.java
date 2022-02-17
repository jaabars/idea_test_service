package kg.itschool.ideaservice.services.impl;

import kg.itschool.ideaservice.dao.IdeaRepo;
import kg.itschool.ideaservice.exceptions.UserNotActivatedException;
import kg.itschool.ideaservice.exceptions.UserNotFoundException;
import kg.itschool.ideaservice.mappers.IdeaMapper;
import kg.itschool.ideaservice.mappers.UserMapper;
import kg.itschool.ideaservice.models.dtos.IdeaDTO;
import kg.itschool.ideaservice.models.dtos.UserEntityDto;
import kg.itschool.ideaservice.models.entities.Idea;
import kg.itschool.ideaservice.services.IdeaService;
import kg.itschool.ideaservice.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class IdeaServiceImpl implements IdeaService {

    private IdeaRepo ideaRepo;
    private UserService userService;

    public IdeaServiceImpl(IdeaRepo ideaRepo, UserService userService) {
        this.ideaRepo = ideaRepo;
        this.userService = userService;
    }

    @Override
    public IdeaDTO save(IdeaDTO ideaDTO) {

        //найти пользователя по номеру телефона и присвоить
        UserEntityDto userEntityDto = userService.findByPhone(ideaDTO.getPhone());
        if (Objects.isNull(userEntityDto)){
           throw new UserNotFoundException("user with phone:"+ideaDTO.getPhone()+"\t not found");
        }
        if (!userEntityDto.isActivated()){
            throw new UserNotActivatedException("user not activated");
        }
        //если нет пользователя выкинуть ошибку  UserNotFound
        //если пользователь найден проверить активен или нет
        Idea idea = IdeaMapper.INSTANCE.ideaDToToIdea(ideaDTO);
        idea.setUser(UserMapper.INSTANCE.toUser(userEntityDto));
        idea = ideaRepo.save(idea);

        return IdeaMapper.INSTANCE.ideaToIdeaDto(idea);
    }
}
