/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import autisticattendence.be.Student;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
    private JFXButton oneBtn;
    @FXML
    private JFXButton twoBtn;
    @FXML
    private JFXButton threeBtn;
    @FXML
    private JFXButton fourBtn;
    @FXML
    private JFXButton fiveBtn;
    @FXML
    private Label dateLbl1;
    @FXML
    private Label dateLbl2;
    @FXML
    private Label dateLbl3;
    @FXML
    private Label dateLbl4;
    @FXML
    private Label dateLbl5;
    @FXML
    private Label timeLbl1;
    @FXML
    private Label timeLbl2;
    @FXML
    private Label timeLbl3;
    @FXML
    private Label timeLbl4;
    @FXML
    private Label timeLbl5;
    @FXML
    private ToggleGroup group5;
    @FXML
    private JFXComboBox<?> weekCombo;
    @FXML
    private Label nameLbl;
    @FXML
    private Label totalLbl;
    @FXML
    private Label classLbl;
    
    private Student student;
    @FXML
    private JFXButton logOut;

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
    private void classOne(ActionEvent event)
    {
        
    }

    @FXML
    private void classTwo(ActionEvent event)
    {
        
    }

    @FXML
    private void classThree(ActionEvent event)
    {
        
    }

    @FXML
    private void classFour(ActionEvent event)
    {
        
    }

    @FXML
    private void classFive(ActionEvent event)
    {
        
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
