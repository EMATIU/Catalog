package ro.pao.repository;

import ro.pao.model.abstracts.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository {

    Optional<Student> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Student newObject);

    void addNewObject(Student exampleClass);

    List<Student> getAll();

    void addAllFromGivenList(List<Student> exampleClassList);
}