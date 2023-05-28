package ro.pao.application;

import ro.pao.exception.NotUUID;
import ro.pao.model.*;
import ro.pao.model.abstracts.Parent;
import ro.pao.model.abstracts.Student;
import ro.pao.model.abstracts.Teacher;
import ro.pao.model.enums.Semester;
import ro.pao.model.enums.SubjectName;
import ro.pao.service.StudentService;
import ro.pao.service.SubjectService;
import ro.pao.service.TeacherService;
import ro.pao.service.impl.StudentServiceImpl;
import ro.pao.service.impl.SubjectServiceImpl;
import ro.pao.service.impl.TeacherServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

public class Menu {

    private static Menu INSTANCE;
    Scanner console = new Scanner(System.in);
    private final StudentService studentService = new StudentServiceImpl();
    private final TeacherService teacherService = new TeacherServiceImpl();
    private final SubjectService subjectService = new SubjectServiceImpl();
    private final static Pattern UUID_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro(){
        String intro = """
        ============================WELCOME==============================\n
        Please select one the following options, by inserting the number corresponding to the action you want to choose:\n
        
        1.  Add a new teacher
        2.  Delete a teacher
        3.  Add a student
        4.  Delete a student
        5.  Display information about a certain student
        6.  Display information about a certain teacher
        7.  Add grade to a student
        8.  Add absence to a student
        9.  Remove a student's absence
        10. Display all the subjects
        11. Display the teacher of each subject
        12. Sort the students by their ggpa
       """;

        System.out.println(intro);
        Integer option = Integer.valueOf(console.next());

        Parent parent0 = Parent.builder()
                .firstName("Olga")
                .lastName("Mathew")
                .age(37)
                .parentId(UUID.randomUUID())
                .parentPhoneNumber("0387236437")
                .build();

        Teacher teacher01 = Teacher.builder()
                .firstName("Misha")
                .lastName("Legget")
                .age(54)
                .teacherId(UUID.randomUUID())
                .salary(3200)
                .teacherEmail("mishaa@yahoo.com")
                .teacherPhoneNumber("07385264")
                .build();

        Teacher teacher02 = Teacher.builder()
                .firstName("Goerge")
                .lastName("Bay")
                .age(34)
                .teacherId(UUID.randomUUID())
                .salary(4000)
                .teacherEmail("georgb@yahoo.com")
                .teacherPhoneNumber("0769465378")
                .build();


        ArrayList<Subject> subjects0 = new ArrayList<>();
        Vector<Subject> subjectVector = new Vector<>();
        ArrayList<Student> students0= new ArrayList<>();
        ArrayList<Grade> grades0 = null;
        TreeSet<LocalDate> absences0 = null;
        Subject subject01 =  Subject.builder()
                .subjectName(SubjectName.ART)
                .teacher(teacher01)
                .absences(absences0)
                .gpa(0.0)
                .grades(grades0)
                .build();

        Subject subject02 =  Subject.builder()
                .subjectName(SubjectName.ENGLISH)
                .teacher(teacher02)
                .absences(absences0)
                .gpa(0.0)
                .grades(grades0)
                .build();

        subjects0.add(subject01);
        subjects0.add(subject02);

        subjectVector.add(subject01);
        subjectVector.add(subject02);


        Student studentExample1 = Student.builder()
                .firstName("Paul")
                .lastName("Max")
                .age(15)
                .studentId(UUID.randomUUID())
                .studentEmail("paul.max@cnet.com")
                .studentPhoneNumber("123456")
                .birth(LocalDate.ofEpochDay(01/06/2007))
                .parent(parent0)
                .semester(Semester.SECOND_SEMESTER)
                .results(subjects0)
                .build();

        Student studentExample2 = Student.builder()
                .firstName("Emma")
                .lastName("Max")
                .age(13)
                .studentId(UUID.randomUUID())
                .studentEmail("emma.stone@cnet.com")
                .studentPhoneNumber("123456")
                .birth(LocalDate.ofEpochDay(01/06/2010))
                .parent(parent0)
                .semester(Semester.SECOND_SEMESTER)
                .results(subjects0)
                .build();

        students0.add(studentExample1);
        students0.add(studentExample2);

        switch(option){
            case 1:
                System.out.println("Please enter the following information about the new teacher: ");
                System.out.println();

                System.out.println("First name: ");
                String firstName = console.next();

                System.out.println("Last name: ");
                String lastName = console.next();

                System.out.println("Age: ");
                Integer age = Integer.valueOf(console.next());

                System.out.println("Salary: ");
                Integer salary = Integer.valueOf(console.next());

                System.out.println("Teacher's email: ");
                String email = console.next();

                System.out.println("Teacher's phone number: ");
                String phone = console.next();

               Teacher teacher = Teacher.builder()
                       .firstName(firstName)
                       .lastName(lastName)
                       .age(age)
                       .teacherId(UUID.randomUUID())
                       .salary(salary)
                       .teacherEmail(email)
                       .teacherPhoneNumber(phone)
                       .build();

               teacherService.addTeacher(teacher);
               System.out.println();
               System.out.println();
               System.out.println("You have successfully added the new teacher: ");
               System.out.println();
               teacherService.showTeacher((teacher));

            case 2:
                System.out.println("Please enter the ID for the teacher you want to remove: ");
                System.out.println();

                UUID teacherId;
                //3bf5d7bb-9c94-4477-89f6-24c7ee30f6c2 ca sa rulez
                String teacherIdd = console.next();
                if(!UUID_PATTERN.matcher(teacherIdd).matches()) {
                    try {
                        throw new NotUUID("Invalid ID");
                    } catch (NotUUID exception) {
                        throw new RuntimeException(exception);
                    }
                }
                else teacherId = UUID.fromString(teacherIdd);
                if(teacherService.getById(teacherId).isPresent()){
                    teacherService.removeTeacher(teacherId);
                    System.out.println("You have successfully deleted the teacher!");
                    System.out.println();
                }
                else{
                    System.out.println("The teacher with this Id doesn't exist!");
                    System.out.println();
                }

            case 3:
                System.out.println("Please enter the following information about the new student: ");
                System.out.println();

                System.out.println("First name: ");
                String sFirstName = console.next();

                System.out.println("Last name: ");
                String sLastName = console.next();

                System.out.println("Age: ");
                Integer sAge = Integer.valueOf(console.next());

                System.out.println("Student's email: ");
                String sEmail = console.next();

                System.out.println("Student's phone number: ");
                String sPhone = console.next();

                LocalDate dateOfBirth = null;
                while(dateOfBirth == null) {
                    try {
                        System.out.println("Student's date of birth (format dd/MM/yyy) : ");
                        String dateOfBirthString = console.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);
                    }catch(DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter date in the format dd/MM/yyyy.");
                    }
                }
                System.out.println();
                System.out.println("Please enter the following details about the new student's parent: ");
                System.out.println("Parent's first name: ");
                String pFirstName = console.next();

                System.out.println("Parent's last name: ");
                String pLastName = console.next();

                System.out.println("Age: ");
                Integer pAge = Integer.valueOf(console.next());

                System.out.println("Parent's phone number: ");
                String pPhone = console.next();

                Parent parent = Parent.builder()
                        .firstName(pFirstName)
                        .lastName(pLastName)
                        .age(pAge)
                        .parentId(UUID.randomUUID())
                        .parentPhoneNumber(pPhone)
                        .build();

                Teacher teacher1 = Teacher.builder()
                        .firstName("Michael")
                        .lastName("Scofield")
                        .age(54)
                        .teacherId(UUID.randomUUID())
                        .salary(3200)
                        .teacherEmail("mich.scf@yahoo.com")
                        .teacherPhoneNumber("0785264")
                        .build();

                Teacher teacher2 = Teacher.builder()
                        .firstName("Gina")
                        .lastName("Com")
                        .age(34)
                        .teacherId(UUID.randomUUID())
                        .salary(4000)
                        .teacherEmail("ginna@yahoo.com")
                        .teacherPhoneNumber("0769465378")
                        .build();


                ArrayList<Subject> subjects = new ArrayList<>();
                ArrayList<Grade> gradess = null;
                TreeSet<LocalDate> absencess = null;
                Subject subject1 =  Subject.builder()
                        .subjectName(SubjectName.MATH)
                        .teacher(teacher1)
                        .absences(absencess)
                        .gpa(0.0)
                        .grades(gradess)
                        .build();

                Subject subject2 =  Subject.builder()
                        .subjectName(SubjectName.ENGLISH)
                        .teacher(teacher2)
                        .absences(absencess)
                        .gpa(0.0)
                        .grades(gradess)
                        .build();

                subjects.add(subject1);
                subjects.add(subject2);


                Student student = Student.builder()
                        .firstName(sFirstName)
                        .lastName(sLastName)
                        .age(sAge)
                        .studentId(UUID.randomUUID())
                        .studentEmail(sEmail)
                        .studentPhoneNumber(sPhone)
                        .birth(dateOfBirth)
                        .parent(parent)
                        .semester(Semester.SECOND_SEMESTER)
                        .results(subjects)
                        .build();

                studentService.addStudent(student);
                System.out.println();
                System.out.println();
                System.out.println("You have successfully added the new student:");
                System.out.println();
                studentService.showStudent(student);

            case 4:
                System.out.println("Please enter the ID for the student you want to remove: ");
                System.out.println();

                UUID studentId = UUID.fromString(console.next());
                //3bf5d7bb-9c94-4477-89f6-24c7ee30f6c2 ca sa rulez
                if(studentService.getById(studentId).isPresent()){
                    studentService.removeStudent(studentId);
                    System.out.println("You have successfully deleted the student!");
                    System.out.println();
                }
                else{
                    System.out.println("The student with this Id doesn't exist!");
                    System.out.println();
                }

            case 5:
               /* System.out.println("Please enter the first name and last name for the student: ");
                System.out.println("First name: ");
                String newFirstName = console.next();

                System.out.println("Last name: ");
                String newLastName = console.next();

                if(studentService.getByName(newFirstName,newLastName).isPresent()){
                    Optional<Student> st = studentService.getByName(newFirstName,newLastName);
                    studentService.showStudent(st);
                    System.out.println("You have successfully displayed the student!");
                    System.out.println();
                }
                else{
                    try {
                        throw new WhosThisStudent(nume, prenume);
                    } catch (WhosThisStudent exception) {
                        System.out.println(exception.getMessage());}
                */

            case 10:
                System.out.println("The subject of this year of study are:");
                subjectService.showSubjects();

            case 11:
                System.out.println("The teacher of each subject:");
                subjectService.showTeacherForEachSubject(subjectVector);

           /* case 12:
                System.out.println("Students sorted by their ggpa");

                List<Student> sortedStudents = students0.stream()
                        .sorted(Comparator.comparingDouble(Student::getGgpa))
                        .collect(Collectors.toList());
            */


        }
    }
}
