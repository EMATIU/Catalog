package ro.pao.service.impl;

import ro.pao.model.Grade;
import ro.pao.model.Student;
import ro.pao.model.Subject;
import ro.pao.model.Teacher;
import ro.pao.model.enums.SubjectName;
import ro.pao.service.StudentService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private static List<Student> studentList = new ArrayList<>();
    @Override
    public void showStudent(Student student) {
        System.out.println("First name: " + student.getFirstName());
        System.out.println("Last name: " + student.getLastName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Phone number: " + student.getStudentPhoneNumber());
        System.out.println("Email address: " + student.getStudentEmail());
        System.out.println("Birth date: " + student.getBirth());
        System.out.println("Parent's name: " + student.getParent().getFirstName() + " " + student.getParent().getLastName());
        System.out.println("General grade point average: " + student.getGgpa());
        System.out.println("Semester: " + student.getSemester());

        System.out.println("Student's grades of each subject: ");
        for(Subject subject : student.getResults()){

            System.out.println("==== " + subject.getSubjectName() + " ====");
            System.out.println("Grades:");

            for(Grade grade : subject.getGrades() ){
                System.out.println(grade.getGrade());
            }
        }

        System.out.println();
        System.out.println();

        System.out.println("Student's number of absences of each subject: ");
        for(Subject subject : student.getResults()){

            System.out.println("==== " + subject.getSubjectName() + " ====");
            System.out.println("Number of absences: " + subject.getAbsences().size());

            for(Grade grade : subject.getGrades() ){
                System.out.println(grade.getGrade());
            }
        }
    }

    @Override
    public void removeStudent(UUID id) {
        studentList = studentList.stream()
                .filter(element -> !id.equals(element.getStudentId()))
                .collect(Collectors.toList());
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void modifyStudent(UUID id, Student newStudent) {
        removeStudent(id);
        addStudent(newStudent);
    }

    @Override
    public List<Student> getAllFromList() {
        return studentList;
    }

    @Override
    public Map<SubjectName, Double> calculateGpa() {
        /* folosesc un obiect de tip HashMap pentru a reține media fiecarei materii. Cheia este un obiect de tip SubjectName,
         iar valoarea este media pentru acea materie
         */
        List<Subject> results = new ArrayList<>();
        Map<SubjectName, Double> subjectAvereges  =new HashMap<>();
        for(Subject subject : results){
            if(subject.getGrades().size() > 0){
                Double sum = 0.0;
                for(Grade grade : subject.getGrades()){
                    sum += grade.getGrade();
                }
                Double average = sum / subject.getGrades().size();
                subjectAvereges.put(subject.getSubjectName(),average);
            }
        }
        return subjectAvereges;
    }


}
