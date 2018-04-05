/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.be;

/**
 *
 * @author Jesper
 */
public class AttendanceDay {
    
    private int studentId;
    private String dateTime;
    private boolean beenToSchool;
    private String weekDay;
    private Long dateNr;

    public AttendanceDay(int studentId, String dateTime, boolean beenToSchool, String weekDay, Long dateNr) {
        this.studentId = studentId;
        this.dateTime = dateTime;
        this.beenToSchool = beenToSchool;
        this.weekDay = weekDay;
        this.dateNr = dateNr;
    }

    public AttendanceDay() {
    
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isBeenToSchool() {
        return beenToSchool;
    }

    public void setBeenToSchool(boolean beenToSchool) {
        this.beenToSchool = beenToSchool;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Long getDateNr() {
        return dateNr;
    }

    public void setDateNr(Long dateNr) {
        this.dateNr = dateNr;
    }
    
}
