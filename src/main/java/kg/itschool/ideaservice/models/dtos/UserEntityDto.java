package kg.itschool.ideaservice.models.dtos;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntityDto {

    Long id;
    String phone;
    String code;
    boolean activated;
}
