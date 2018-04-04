/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import autisticattendence.be.Student;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ollie
 */
public class StudentViewController implements Initializable
{

    @FXML
    private Label nameLbl;
    @FXML
    private Label totalLbl;
    
    private Student student;
    @FXML
    private JFXButton logOut;
    @FXML
    private Label dateLbl;
    @FXML
    private JFXRadioButton presentRbtn;
    @FXML
    private ToggleGroup grp;
    @FXML
    private JFXRadioButton absentRbtn;
    @FXML
    private JFXButton submitBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        totalLbl.setText("Total Absence: ");
    }

    public void setStudent(Student student) {
        this.student = student;
        String studentFName = student.getFirstName();
        String studentLName = student.getLastName();  
   //     String studentAttendance = Float.toString(student.getAttendance);
        nameLbl.setText(studentFName + " " + studentLName);
        //tfAbsence.setText("BABY IS DEAD");
        //tfCourse.setText(studentCourse);
    }    

    @FXML
    private void submit(ActionEvent event)
    {
       totalLbl.setText("Total Absence: ");
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
