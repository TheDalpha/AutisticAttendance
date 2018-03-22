/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.model;

import autisticattendence.be.Student;
import autisticattendence.be.Teacher;
import autisticattendence.bll.StudentManager;
import autisticattendence.bll.TeacherManager;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jesper Riis
 */
public class LoginModel {
    
    private StudentManager sManager = new StudentManager();
    private TeacherManager tManager = new TeacherManager();
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
    
    public ObservableList<Student> getAllStudents() {
        return students;
    }
    public ObservableList<Teacher> getAllTeachers() {
        return teachers;
    }
    
    public void loadStudents(){
    List<Student> allStudents = sManager.getAllStudents();
    students.addAll(allStudents);
    }
    
    public void loadTeachers(){
    List<Teacher> allTeachers = tManager.getAllTeachers();
    teachers.addAll(allTeachers);
    }
    
}
