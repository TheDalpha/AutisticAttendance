/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.model;

import autisticattendence.be.Class;
import autisticattendence.be.Student;
import autisticattendence.be.Teacher;
import autisticattendence.bll.TeacherManager;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ollie
 */
public class TeacherViewModel
{
    TeacherManager tm;
    Teacher teacher;
    public ObservableList<Teacher> teacherList;
    public ObservableList<Class> classList;
    private static TeacherViewModel instance;
    
    public TeacherViewModel() throws IOException {
        this.tm = new TeacherManager();
        teacher = new Teacher();
        teacherList = FXCollections.observableArrayList();
        classList = FXCollections.observableArrayList();
    }
    
    public ObservableList<Teacher> getTeachers() {
        return teacherList;
    }
    
    public void loadTeachers() {
       teacherList.clear();
       teacherList.addAll(tm.getAllTeachers());
    }
    
    public static TeacherViewModel getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new TeacherViewModel();
        }
        return instance;
    }
    
    public void loadClasses() {
        classList.clear();
        classList.addAll(tm.getAllClasses());
    }
    
    public void loadStudentsInClasses() {
        tm.getAllClassesStudents();
    }
    
    public ObservableList<Class> getClasses() {
        return classList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void loadClassesTeachers() {
        classList.clear();
        classList.addAll(tm.getAllClassesTeachers());
    }

    public void updateTeacher(Teacher teacher) {
        tm.updateTeacher(teacher);
    }
    
    
    
}
