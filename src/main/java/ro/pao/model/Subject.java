package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.enums.SubjectName;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private TreeSet<LocalDate> absences;
    private Double gpa; //media la o anumita materie
    private ArrayList<Grade> grades;

    public Grade getGradeFormat(Integer x, LocalDate y) {
        Grade newGrade = new Grade();
        newGrade.grade = x;
        newGrade.date = y;
        return newGrade;
    }
}
