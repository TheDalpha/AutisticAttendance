/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.bll;

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
    
    public StudentManager(){
        this.sdao = new StudentDAO();
    }
    
    public List<Student> getAllStudents() {
        return sdao.getAllStudents();
    }

    public void updateStudent(Student student) {
        sdao.updateStudent(student);
    }
}
