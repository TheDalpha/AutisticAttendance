/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.dal;

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
 * @author ollie
 */
public class TeacherDAO
{
    private DataBaseConnector dbConnector;
    
    public TeacherDAO() {
        dbConnector = new DataBaseConnector();
    }
    
    public List<Teacher> getAllTeachers() {
        List<Teacher> allTeachers = new ArrayList();
        
        try (Connection con = dbConnector.getConnection()) {
            PreparedStatement pstmt
                    = con.prepareStatement("SELECT * FROM Teacher");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getInt("teacherId"));
                teacher.setFirstName(rs.getString("firstName"));
                teacher.setLastName(rs.getString("lastName"));
                teacher.setEmail(rs.getString("mail"));
                teacher.setPhoneNr(rs.getInt("phone"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                
                allTeachers.add(teacher);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
            return null;
        }
        return allTeachers;
    }
    
}
