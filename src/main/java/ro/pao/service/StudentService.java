package ro.pao.service;

import ro.pao.model.Student;
import ro.pao.model.Subject;
import ro.pao.model.Teacher;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    void showStudent(Student student);
    void removeStudent(UUID id);
    void addStudent(Student student);
    void modifyStudent(UUID id, Student newStudent);
    List<Student> getAllFromList();

}
