package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Person;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode

public class Teacher extends Person {
    private UUID teacherId;
    private Integer salary;
    private String teacherEmail;
    private String teacherPhoneNumber;
}
