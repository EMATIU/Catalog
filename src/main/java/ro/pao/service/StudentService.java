package ro.pao.service;

import ro.pao.model.abstracts.Student;
import ro.pao.model.enums.SubjectName;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
    void showStudent(Student student);
    void removeStudent(UUID id);
    void addStudent(Student student);
    void modifyStudent(UUID id, Student newStudent);
    List<Student> getAllFromList();
    Map<SubjectName, Double> calculateGpa();//media la fiecare materie, map-ul returneaza numele fiecarei materii cu media asociata

    Optional<Student> getById(UUID id);
    Optional<Student> getByName(String firstName, String lastName);

}
