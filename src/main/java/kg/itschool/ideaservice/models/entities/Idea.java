package kg.itschool.ideaservice.models.entities;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Idea {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String text;
    boolean contactWithMe;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
