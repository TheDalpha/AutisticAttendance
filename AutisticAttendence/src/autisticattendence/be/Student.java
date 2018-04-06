/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.be;

import javafx.scene.image.ImageView;

/**
 *
 * @author Jesper Riis
 */
public class Student extends Person{
    
    private int studentId;

    private int absencePercent;

    private int studentAbsenceDays;
    
    private String Address;
    
    private boolean didAttend;
    
    private String studentImg;
    
    private ImageView image;

    public int getStudentAbsenceDays() {
        return studentAbsenceDays;
    }

    public void setStudentAbsenceDays(int studentAbsenceDays) {
        this.studentAbsenceDays = studentAbsenceDays;
    }

    public boolean isDidAttend() {
        return didAttend;
    }

    public void setDidAttend(boolean didAttend) {
        this.didAttend = didAttend;
    }

    /**
     * Get the value of Address
     *
     * @return the value of Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Set the value of Address
     *
     * @param Address new value of Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * Get the value of absence
     *
     * @return the value of absence
     */
    public int getAbsencePercent() {
        return absencePercent;
    }

    /**
     * Set the value of absence
     *
     * @param absence new value of absence
     */
    public void setAbsencePercent(int absencePercent) {
        this.absencePercent = absencePercent;
    }

    /**
     * Get the value of studentId
     *
     * @return the value of studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Set the value of studentId
     *
     * @param studentId new value of studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentImg() {
        return studentImg;
    }

    public void setStudentImg(String studentImg) {
        this.studentImg = studentImg;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    
    
    

}
