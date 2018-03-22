/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.dal;

import autisticattendence.be.Student;
import autisticattendence.be.Teacher;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesper Riis
 */
public class StudentDAO {
    
    private DataBaseConnector dbConnector;
    
    public StudentDAO() throws IOException {
        dbConnector = new DataBaseConnector();
    }
    
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList();
        
        try (Connection con = dbConnector.getConnection()) {
            PreparedStatement pstmt
                    = con.prepareStatement("SELECT * FROM Student");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setEmail(rs.getString("mail"));
                student.setPhoneNr(rs.getInt("phone"));
                student.setAddress(rs.getString("address"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setAbsence(rs.getInt("Absence"));
                
                allStudents.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allStudents;
    }
    
}
