package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode

public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected Integer age;

}