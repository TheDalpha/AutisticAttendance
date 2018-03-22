/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.bll;

import autisticattendence.be.Teacher;
import autisticattendence.dal.TeacherDAO;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ollie
 */
public class TeacherManager
{
    TeacherDAO tdao;
    
    public TeacherManager() throws IOException {
        this.tdao = new TeacherDAO();
    }
    
    public List<Teacher> getAllTeachers() {
        return tdao.getAllTeachers();
    }
    
}
