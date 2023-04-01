package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.Semester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode

public class Student extends Person {
    private UUID studentId;
    private String studentEmail;
    private String studentPhoneNumber;
    private LocalDate birth;
    private Parent parent;
    private Double ggpa; // //general grade point average = medie generala
    private Semester semester;
    private ArrayList<Subject> results;


}
