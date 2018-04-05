/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import autisticattendence.be.Teacher;
import autisticattendence.gui.model.TeacherViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ollie
 */
public class TeacherViewController implements Initializable {
    
    private TeacherViewModel tvm;

    private TableColumn<Teacher, String> studentClmName;
    private TableColumn<Teacher, String> studentClmAbsence;
    @FXML
    private Label nameLbl;
    @FXML
    private Label classLbl;
    @FXML
    private JFXButton logOut;
    private Teacher teacher;
    @FXML
    private ListView<?> todayListView;
    @FXML
    private ListView<?> overallListView;
    

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
        
        studentClmName.setCellValueFactory(
                new PropertyValueFactory("name"));
        studentClmAbsence.setCellValueFactory(
                new PropertyValueFactory("absence"));
        
        
        
    }    
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        String studentFName = teacher.getFirstName();
        String studentLName = teacher.getLastName(); 
        nameLbl.setText(studentFName + " " + studentLName);
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) logOut.getScene().getWindow();
        stage1.close();
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/autisticattendence/gui/view/LoginView.fxml"));

        Scene scene = new Scene(root);
            

        stage.setScene(scene);
        stage.show();
    }

    
    
}
