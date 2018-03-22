/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.model;

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
    public ObservableList<Teacher> teacherList;
    private static TeacherViewModel instance;
    
    public TeacherViewModel() throws IOException {
        this.tm = new TeacherManager();
        teacherList = FXCollections.observableArrayList();
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
    
    
    
}
