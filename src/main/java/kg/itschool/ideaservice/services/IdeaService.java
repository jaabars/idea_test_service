package kg.itschool.ideaservice.services;

import kg.itschool.ideaservice.models.dtos.IdeaDTO;

public interface IdeaService {
    IdeaDTO save(IdeaDTO ideaDTO);
}
