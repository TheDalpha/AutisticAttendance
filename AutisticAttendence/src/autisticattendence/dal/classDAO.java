/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.dal;

import autisticattendence.be.Class;
import autisticattendence.be.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Captain
 */
public class classDAO {
    
    
    
    private DataBaseConnector dbConnector;
    
    public classDAO(){
        dbConnector = new DataBaseConnector();
    }
    
    public List<Class> getAllClasses() {
        List<Class> allClasses = new ArrayList();
        
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
    
}
