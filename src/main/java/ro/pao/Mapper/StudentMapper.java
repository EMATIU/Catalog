package ro.pao.mapper;


import ro.pao.model.abstracts.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentMapper {

    private static final StudentMapper INSTANCE = new StudentMapper();

    private StudentMapper() {
    }

    public static StudentMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Student> mapToStudent(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Student.builder()
                            .studentId(UUID.fromString(resultSet.getString(1)))
                            .studentEmail(resultSet.getString(2))
                            .studentPhoneNumber(resultSet.getString(3))
                            .birth(resultSet.getDate(4).toLocalDate())
                            .ggpa(resultSet.getDouble(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Student> mapToStudentList(ResultSet resultSet) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            studentList.add(
                    Student.builder()
                            .studentId(UUID.fromString(resultSet.getString(1)))
                            .studentEmail(resultSet.getString(2))
                            .studentPhoneNumber(resultSet.getString(3))
                            .birth(resultSet.getDate(4).toLocalDate())
                            .ggpa(resultSet.getDouble(5))
                            .build()
            );
        }

        return studentList;
    }
}