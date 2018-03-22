/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.be;

/**
 *
 * @author ollie
 */
public class Teacher extends Person
{
    
        private int teacherId;

    /**
     * Get the value of teacherId
     *
     * @return the value of teacherId
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Set the value of teacherId
     *
     * @param teacherId new value of teacherId
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
}
