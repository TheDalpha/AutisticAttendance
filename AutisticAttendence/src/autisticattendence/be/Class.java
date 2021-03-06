/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Captain
 */
public class Class {
    
    private int classId;
    private String className;
    private final List<Student> classList;
    private final List<Teacher> classListT;

    public Class() {
        this.classList = new ArrayList();
        this.classListT = new ArrayList();
    }

    /**
     * Get the value of className
     *
     * @return the value of className
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set the value of className
     *
     * @param className new value of className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get the value of classId
     *
     * @return the value of classId
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Set the value of classId
     *
     * @param classId new value of classId
     */
    public void setClassId(int classId) {
        this.classId = classId;
    } 

    public List<Student> getClassList() {
        return classList;
    }

    public List<Teacher> getClassListT() {
        return classListT;
    }
    
    /**
     *
     * @return
     */
    public String tostring() {
    return "Class{" + "name=" + className + ", id=" + classId + '}';
    }

}
