package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.abstracts.Teacher;
import ro.pao.service.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter


public class TeacherServiceImpl implements TeacherService {

    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public Optional<Teacher> getById(UUID id) {
        return teacherList.stream()
                .filter(object -> id.equals(object.getTeacherId()))
                .findFirst();
    }

    @Override
    public void showTeacher(Teacher teacher){
        System.out.println("First name: " + teacher.getFirstName());
        System.out.println("Last name: " + teacher.getLastName());
        System.out.println("Age: " + teacher.getAge());
        System.out.println("Teacher ID: " + teacher.getTeacherId());
        System.out.println("Salary: " + teacher.getSalary());
        System.out.println("Phone number: " + teacher.getTeacherPhoneNumber());
        System.out.println("Email address: " + teacher.getTeacherEmail());
        System.out.println();
    }

    @Override
    public void removeTeacher(UUID id){
        teacherList = teacherList.stream()
                .filter(element -> !id.equals(element.getTeacherId()))
                .collect(Collectors.toList());

        //teacherList va contine toti profesoii care au id-ul diferit de cel al profesorului pe care vrem sa il stergem
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    @Override
    public void modifyTeacher(UUID id, Teacher newTeacher){
        removeTeacher(id);
        addTeacher(newTeacher);

    }

    @Override
    public List<Teacher> getAllFromList() {
        return teacherList;
    }
}
