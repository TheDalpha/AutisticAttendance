/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.dal;

import autisticattendence.be.AttendanceDay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class AttendanceDayDAO {
    private DataBaseConnector dbConnector;
    
    
    public AttendanceDayDAO(){
        dbConnector = new DataBaseConnector();
    }
    public AttendanceDay addDay(AttendanceDay day)
    {
        String sql = "INSERT INTO AttendanceDay(StudentId, dateTime, beenToSchool, weekDay, dateNr) VALUES(?,?,?,?,?)";
        try (Connection con = dbConnector.getConnection())
        {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, day.getStudentId());
            ps.setString(2, day.getDateTime());
            ps.setBoolean(3, day.isBeenToSchool());
            ps.setString(4, day.getWeekDay());
            ps.setLong(5, day.getDateNr());
            ps.executeUpdate();

            ResultSet generatedKey = ps.getGeneratedKeys();
            generatedKey.next();
            int id = generatedKey.getInt(1);
            return new AttendanceDay(id, sql, true, sql, Long.MAX_VALUE);
        } catch (SQLException ex) {
            System.err.print(ex);
            return null;
        }

    }

    public List<AttendanceDay> getStudentDays(int id) {
    
        List<AttendanceDay> days = new ArrayList<>();
        String sql = "SELECT * FROM AttendanceDay WHERE StudentId = ?";
        try (Connection con = dbConnector.getConnection())
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                days.add(getOneDay(rs));
            }
        }catch (SQLException ex) {
            System.err.print(ex);
            return null;
        }
        return days;
    }
        
    private AttendanceDay getOneDay(ResultSet rs) throws SQLException
    {
        int studentId = rs.getInt("StudentId");
        String dateTime = rs.getString("dateTime");
        boolean beenToSchool = rs.getBoolean("beenToSchool");
        long dateNr = rs.getLong("dateNr");
        String weekDay = rs.getString("weekDay");
        return new AttendanceDay(studentId, dateTime, beenToSchool, weekDay, dateNr);
    }

    public void updateDay(AttendanceDay day) {
       {
        String sql = "UPDATE AttendanceDay "
                + "SET dateTime = ?, "
                + "beenToSchool = ?, "
                + "dateNr = ? "
                + "WHERE StudentId = ? ;";
        try (Connection con = dbConnector.getConnection())
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, day.getDateTime());
            ps.setBoolean(2, day.isBeenToSchool());
            ps.setLong(3, day.getDateNr());
            ps.setInt(4, day.getStudentId());
            ps.executeUpdate();

        }catch (SQLException ex) {
            System.err.print(ex);

       }
     }
   }
}
