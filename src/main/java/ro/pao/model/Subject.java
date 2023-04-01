package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.SubjectName;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode

public class Subject {
    private SubjectName subjectName;
    private Teacher teacher;
    private TreeSet<Date> absences;
    private Double gpa; //media la o anumita materie
    private ArrayList<Grade> grades;

}
