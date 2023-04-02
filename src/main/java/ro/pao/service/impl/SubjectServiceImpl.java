package ro.pao.service.impl;

import ro.pao.model.Subject;
import ro.pao.model.Teacher;
import ro.pao.model.enums.SubjectName;
import ro.pao.service.SubjectService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SubjectServiceImpl implements SubjectService {
    private static List<Subject> subjectList = new ArrayList<>();
    @Override
    public void showSubjects(){
        for(SubjectName subjectName : SubjectName.values()) {
            System.out.println(subjectName);
        }
    }

    @Override
    public void addGrade(Vector<Subject> subjectVector, Integer subjectIndex, Integer newGrade, LocalDate date) {
        subjectVector.get(subjectIndex).getGrades().add(subjectVector.get(subjectIndex).getGradeFormat(newGrade, date));
    }

    @Override
    public void addAbsence(Vector<Subject> subjectVector, Integer subjectIndex, LocalDate absence) {
        subjectVector.get(subjectIndex).getAbsences().add(absence);
    }

    @Override
    public void removeAbsence(Vector<Subject> subjectVector, Integer subjectIndex, LocalDate absence) {
        subjectVector.get(subjectIndex).getAbsences().remove(absence);
    }

    @Override
    public void setTeacherToEachSubject(Vector<Subject> subjectVector, Integer subjectIndex, Teacher teacher) {
        subjectVector.get(subjectIndex).setTeacher((teacher));
    }

    @Override
    public void showTeacherForEachSubject(Vector<Subject> subjectVector) {
        for(Subject subject : subjectVector){
            System.out.println( subject.getTeacher().getFirstName() + " " + subject.getTeacher().getLastName() + " teaches " + subject.getSubjectName() + ".");
        }
    }

    @Override
    public List<Subject> getAllFromList() {
        return subjectList;
    }
}
