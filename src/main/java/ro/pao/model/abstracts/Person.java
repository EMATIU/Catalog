package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode

public sealed class Person permits Parent, Student, Teacher {

    protected String firstName;
    protected String lastName;
    protected Integer age;

}