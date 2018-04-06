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
    
    public StudentDAO(){
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
                student.setAbsencePercent(rs.getInt("AbsencePercent"));
                student.setStudentAbsenceDays(rs.getInt("studentAbsenceDays"));
                student.setStudentImg(rs.getString("fileLink"));
                student.setDidAttend(rs.getString("didAttend"));
                allStudents.add(student);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
            return null;
        }
        return allStudents;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE Student "
                + "SET firstName = ?, "
                + " lastName = ?, "
                + " mail = ?, "
                + " phone = ?, "
                + " address = ?, "
                + " password = ?, "
                + " username = ?, "
                + " absencePercent = ?, "
                + " studentAbsenceDays = ?, "
                + " fileLink = ?, "
                + " didAttend = ? "
                + " WHERE studentId = ? ;";
        try (Connection con = dbConnector.getConnection())
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getPhoneNr());
            ps.setString(5, student.getAddress());
            ps.setString(6, student.getPassword());
            ps.setString(7, student.getUsername());
            ps.setDouble(8, student.getAbsencePercent());
            ps.setInt(9, student.getStudentAbsenceDays());
            ps.setString(10, student.getStudentImg());
            ps.setString(11, student.getDidAttend());
            ps.setInt(12, student.getStudentId());

            ps.executeUpdate();
        }catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    
}
