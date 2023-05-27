package ro.pao.service;

import ro.pao.model.Subject;
import ro.pao.model.abstracts.Teacher;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

public interface SubjectService {
    void showSubjects();
    void addGrade(Vector<Subject> subjectVector, Integer subjectIndex, Integer newGrade, LocalDate date); //subjectIndex e pozitia materiei la care vreau sa adaug o noua nota
    void addAbsence(Vector<Subject> subjectVector, Integer subjectIndex, LocalDate absence);
    void removeAbsence(Vector<Subject> subjectVector, Integer subjectIndex, LocalDate absence);
    void setTeacherToEachSubject(Vector<Subject> subjectVector,Integer subjectIndex, Teacher teacher);
    void showTeacherForEachSubject(Vector<Subject> subjectVector);
    List<Subject> getAllFromList();

}
