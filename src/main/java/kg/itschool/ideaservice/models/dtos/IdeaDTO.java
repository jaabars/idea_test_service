package kg.itschool.ideaservice.models.dtos;


import kg.itschool.ideaservice.models.entities.User;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class IdeaDTO {

    Long id;
    String title;
    String body;
    boolean contactWithMe;
    String phone;
}
