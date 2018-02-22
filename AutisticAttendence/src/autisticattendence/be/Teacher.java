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
public class Teacher
{
    
    public String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    public double absence;

    /**
     * Get the value of absence
     *
     * @return the value of absence
     */
    public double getAbsence()
    {
        return absence;
    }

    /**
     * Set the value of absence
     *
     * @param absence new value of absence
     */
    public void setAbsence(double absence)
    {
        this.absence = absence;
    }
    
    public int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    
}
