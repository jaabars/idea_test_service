package kg.itschool.ideaservice.mappers;


import kg.itschool.ideaservice.models.dtos.IdeaDTO;
import kg.itschool.ideaservice.models.entities.Idea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdeaMapper {
    IdeaMapper INSTANCE = Mappers.getMapper(IdeaMapper.class);

    @Mapping(source = "ideaDTO.body",target = "text")
    Idea ideaDToToIdea(IdeaDTO ideaDTO);
    IdeaDTO ideaToIdeaDto(Idea idea);
}
