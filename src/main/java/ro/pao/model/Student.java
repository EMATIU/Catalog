package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.Semester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Getter
@Setter
@NoArgsConstructor
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

    /////////verific daca mail-ul elevului este de tip prenume.nume@cnet.com///////

    //un predicat reprezintă o funcție care primește un argument și returnează o valoare booleană
    // în funcție de dacă argumentul respectiv îndeplinește sau nu o anumită condiție.
    private final Predicate<String> mailCondition = (studentEmail) -> studentEmail.contains("@cnet.com");
    private final BiPredicate<String, String> fullNameCondition = (firstName, lastName) ->firstName.equals(this.firstName) && lastName.equals(this.lastName);
    public Student(String studentEmail){
        if(!mailCondition.test(studentEmail)){
            System.out.println(" You didn't follow the email format (it has to contain <<@cnet.com>>)!!! ");
        }
        var mailSplit = studentEmail.split("@")[0]; //[0] = "prenume.nume", [1] = "cnet.com"
        var fullNameSplit = mailSplit.split(".");

        if(!fullNameCondition.test(fullNameSplit[0],fullNameSplit[1])){
            System.out.println(" You didn't follow the email format (firstName.lastName@cnet.com)!!! ");
        }
        this.studentEmail = studentEmail;
    }

    public Student(String firstName, String lastName, Integer age, UUID studentId, String studentEmail, String studentPhoneNumber, LocalDate birth, Parent parent, Double ggpa, Semester semester, ArrayList<Subject> results) {
        super(firstName, lastName, age);
        this.studentId = studentId;
        this.studentPhoneNumber = studentPhoneNumber;
        this.birth = birth;
        this.parent = parent;
        this.ggpa = ggpa;
        this.semester = semester;
        this.results = results;

        if(!mailCondition.test(studentEmail)){
            System.out.println(" You didn't follow the email format (it has to contain <<@cnet.com>>)!!! ");
        }
        var mailSplit = studentEmail.split("@")[0]; //[0] = "prenume.nume", [1] = "cnet.com"
        var fullNameSplit = mailSplit.split(".");

        if(!fullNameCondition.test(fullNameSplit[0],fullNameSplit[1])){
            System.out.println(" You didn't follow the email format (firstName.lastName@cnet.com)!!! ");
        }
        this.studentEmail = studentEmail;
    }
}
