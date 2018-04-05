/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.bll;

import autisticattendence.be.Class;
import autisticattendence.be.Teacher;
import autisticattendence.dal.TeacherDAO;
import autisticattendence.dal.classDAO;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ollie
 */
public class TeacherManager
{
    TeacherDAO tdao;
    classDAO cdao;
    
    public TeacherManager() {
        this.tdao = new TeacherDAO();
        this.cdao = new classDAO();
    }
    
    public List<Teacher> getAllTeachers() {
        return tdao.getAllTeachers();
    }
    
    public List<Class> getAllClasses() {
        return cdao.getAllClasses();
    }
    
}
