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

/**
 *
 * @author ollie
 */
public class TeacherViewModel
{
    TeacherManager tm;
    
    public TeacherViewModel() throws IOException {
        this.tm = new TeacherManager();
    }
    
    public List<Teacher> getAllStudents() {
        return tm.getAllStudents();
    }
    
}
