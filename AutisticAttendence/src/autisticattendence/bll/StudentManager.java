/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.bll;

import autisticattendence.be.AttendanceDay;
import autisticattendence.be.Student;
import autisticattendence.dal.StudentDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jesper Riis
 */
public class StudentManager {
    
    StudentDAO sdao;
    AttendanceDayManager attMan;
    
    private int absentMondays;
    private int absentTuesdays;
    private int absentWednesdays;
    private int absentThursdays;
    private int absentFridays;
    
    public StudentManager(){
        this.sdao = new StudentDAO();
        this.attMan = new AttendanceDayManager();
    }
    
    public List<Student> getAllStudents() {
        return sdao.getAllStudents();
    }

    public void updateStudent(Student student) {
        sdao.updateStudent(student);
    }

    public int absentMondays(int studentId) {
    
        for (AttendanceDay day : attMan.getStudentDays(studentId))
        {
            if (day.getWeekDay().equals("MONDAY") && day.isBeenToSchool() == false)
            {
                absentMondays++;
            }
        }
        return absentMondays;
    }

    public int absentTuesday(int studentId) {
        for (AttendanceDay day : attMan.getStudentDays(studentId))
        {
            if (day.getWeekDay().equals("TUESDAY") && day.isBeenToSchool() == false)
            {
                absentTuesdays++;
            }
        }
        return absentTuesdays;
    }

    public int absentWednesday(int studentId) {
        for (AttendanceDay day : attMan.getStudentDays(studentId))
        {
            if (day.getWeekDay().equals("WEDNESDAY") && day.isBeenToSchool() == false)
            {
                absentWednesdays++;
            }
        }
        return absentWednesdays;
    }

    public int absentThursday(int studentId) {
        for (AttendanceDay day : attMan.getStudentDays(studentId))
        {
            if (day.getWeekDay().equals("THURSDAY") && day.isBeenToSchool() == false)
            {
                absentThursdays++;
            }
        }
        return absentThursdays;
    }

    public int absentFriday(int studentId) {
        for (AttendanceDay day : attMan.getStudentDays(studentId))
        {
            if (day.getWeekDay().equals("FRIDAY") && day.isBeenToSchool() == false)
            {
                absentFridays++;
            }
        }
        return absentFridays;
    }
}
