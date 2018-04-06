/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.dal;

import autisticattendence.be.Class;
import autisticattendence.be.Student;
import autisticattendence.be.Teacher;
import autisticattendence.gui.model.TeacherViewModel;
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
 * @author Captain
 */
public class classDAO {
    
    
    List<Class> allClasses = new ArrayList();
    List<Class> allClassesTeacher = new ArrayList();
    private DataBaseConnector dbConnector;
    StudentDAO sDAO;
    TeacherDAO tDAO;
    Teacher teacher;
    TeacherViewModel tvm;
    
    public classDAO(){
        dbConnector = new DataBaseConnector();
        sDAO = new StudentDAO();
        tDAO = new TeacherDAO();
        teacher = new Teacher();
    }
    
    public List<Class> getAllClasses() {
        
        try (Connection con = dbConnector.getConnection()) {
            PreparedStatement pstmt
                    = con.prepareStatement("SELECT * FROM Class");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setClassId(rs.getInt("classId"));
                c.setClassName(rs.getString("className"));
                allClasses.add(c);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
            return null;
        }
        return allClasses;
    }
    public void getAllClassesStudents() {
            
        try (Connection con = dbConnector.getConnection()) {
            PreparedStatement pstmt
                    = con.prepareStatement("SELECT * FROM RelationsId, Class, Student"
                            + " WHERE RelationsId.studentId = Student.studentId AND RelationsId.classId = Class.classId ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Class classes = new Class();
                Student student = new Student();
//                Teacher teacher = new Teacher();
//                teacher.setTeacherId(rs.getInt("teacherId"));
//                teacher.setFirstName(rs.getString("firstName"));
//                teacher.setLastName(rs.getString("lastName"));
//                teacher.setEmail(rs.getString("mail"));
//                teacher.setPhoneNr(rs.getInt("phone"));
//                teacher.setUsername(rs.getString("username"));
//                teacher.setPassword(rs.getString("password"));
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
                classes.setClassId(rs.getInt("classId"));
                
                // Goes through the list of all playlists and if a id on the list is the same as one in database
                // it will get the song list from that specific playlist and add the song that is on the database.
                for (int i = 0; i < allClassesTeacher.size(); i++) { 
                    if(allClassesTeacher.get(i).getClassId() == classes.getClassId() ) 
                    {
                        allClassesTeacher.get(i).getClassList().add(student);
//                        allClasses.get(i).getClassListT().add(teacher);
                    }
                }
                
                    
            }
            } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }

    public List<Class> getAllClassesTeacher() {
        allClassesTeacher.clear();
            try (Connection con = dbConnector.getConnection()) {
            PreparedStatement pstmt
                    = con.prepareStatement("SELECT * FROM RelationsId, Class, Teacher"
                            + " WHERE RelationsId.teacherId = Teacher.teacherId AND RelationsId.classId = Class.classId ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Class classes = new Class();
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getInt("teacherId"));
                teacher.setFirstName(rs.getString("firstName"));
                teacher.setLastName(rs.getString("lastName"));
                teacher.setEmail(rs.getString("mail"));
                teacher.setPhoneNr(rs.getInt("phone"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setLoggedIn(rs.getBoolean("loggedIn"));
                classes.setClassId(rs.getInt("classId"));
                classes.setClassName(rs.getString("className"));
                for (int i = 0; i < allClasses.size(); i++) { 
                    if(allClasses.get(i).getClassId() == classes.getClassId() && teacher.isLoggedIn() == true) 
                    {
                        if(allClassesTeacher.isEmpty()) {
                        allClassesTeacher.add(classes);
                        } else
                        for (int j = 0; j < allClassesTeacher.size(); j++) {
                            if(allClassesTeacher.get(j).getClassId() != allClasses.get(i).getClassId()) {
                                allClassesTeacher.add(classes);
                            }
                            
                        }
                    }
                }
                
                    
            }
               
            } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
    }
            return allClassesTeacher;
   }
}
