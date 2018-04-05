/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.bll;

import autisticattendence.be.AttendanceDay;
import autisticattendence.dal.AttendanceDayDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class AttendanceDayManager {
    
    private AttendanceDayDAO attDayDAO;

    public AttendanceDayManager() {
        attDayDAO = new AttendanceDayDAO();
    }
    
    
    public AttendanceDay addDay(AttendanceDay day){
        return attDayDAO.addDay(day);
    }
    
    public List<AttendanceDay> getStudentDays(int id)
    {
        return attDayDAO.getStudentDays(id);
    }

    public void updateDay(AttendanceDay day) {
        attDayDAO.updateDay(day);
    }
}
