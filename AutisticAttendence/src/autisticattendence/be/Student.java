/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.be;

/**
 *
 * @author Jesper Riis
 */
public class Student extends Person{
    
    private int studentId;

    private int absence;

    private String Address;

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
    public int getAbsence() {
        return absence;
    }

    /**
     * Set the value of absence
     *
     * @param absence new value of absence
     */
    public void setAbsence(int absence) {
        this.absence = absence;
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

}
