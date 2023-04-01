package ro.pao.service;

import ro.pao.model.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeacherService {
  void showTeacher(Teacher teacher);
  void addTeacher(Teacher teacher);
  void removeTeacher(UUID id);
  void modifyTeacher(UUID id, Teacher newTeacher);
  List<Teacher> getAllFromList();

}
