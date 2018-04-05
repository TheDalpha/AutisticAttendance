/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.model;

import autisticattendence.be.AttendanceDay;
import autisticattendence.be.Student;
import autisticattendence.bll.AttendanceDayManager;
import autisticattendence.bll.StudentManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jesper
 */
public class StudentViewModel {
    
        private static StudentViewModel instance;
        private int studentAbsenceDays;
        private int studentAbsencePercents;
        StudentManager stdMan;
        AttendanceDayManager attDay;
        Student student;
        ObservableList<AttendanceDay> atd;

    public StudentViewModel() {
        stdMan = new StudentManager();
        attDay = new AttendanceDayManager();
        student = new Student();
        studentAbsenceDays = student.getStudentAbsenceDays();
        studentAbsencePercents = student.getAbsencePercent();
        this.atd = FXCollections.observableArrayList(attDay.getStudentDays(student.getStudentId()));
    }
    
    
    public AttendanceDay addDay(AttendanceDay day) {
        return attDay.addDay(day);
    }
    
    public List<AttendanceDay> getAllStudentDays(int id) {
        return attDay.getStudentDays(id);
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Student getStudent() {
        return student;
    }
    public static StudentViewModel getInstance() throws SQLException, IOException
    {
        if (instance == null)
        {
            instance = new StudentViewModel();
        }
        return instance;
    }

    public ObservableList<AttendanceDay> getatd() {
        return atd;
    }

    public int getStudentAbsenceDays() {
        return studentAbsenceDays;
    }

    public void setStudentAbsenceDays(int i) {
        studentAbsenceDays = i;
        student.setStudentAbsenceDays(i);
    }

    public void setStudentAbsencePercent(double studentAbsencePercent) {
        student.setAbsencePercent((int) (studentAbsencePercent / atd.size() * 100));
        studentAbsencePercents = student.getAbsencePercent();
    }

    public void updateStudent(Student student) {
        stdMan.updateStudent(student);
    }

    public void updateDay(AttendanceDay day) {
        attDay.updateDay(day);
    }
}
