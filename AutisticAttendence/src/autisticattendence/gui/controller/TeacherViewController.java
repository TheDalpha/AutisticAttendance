/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import autisticattendence.be.Teacher;
import autisticattendence.gui.model.TeacherViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ollie
 */
public class TeacherViewController implements Initializable {
    
    private TeacherViewModel tvm;

    @FXML
    private TableView<Teacher> tableStudent;
    @FXML
    private TableColumn<Teacher, String> studentClmName;
    @FXML
    private TableColumn<Teacher, String> studentClmAbsence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tvm = TeacherViewModel.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(TeacherViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableStudent.setItems(tvm.getStudents());
        
        studentClmName.setCellValueFactory(
                new PropertyValueFactory("name"));
        studentClmAbsence.setCellValueFactory(
                new PropertyValueFactory("name"));
        
        tvm.loadStudents();
        
        
    }    
    
}
