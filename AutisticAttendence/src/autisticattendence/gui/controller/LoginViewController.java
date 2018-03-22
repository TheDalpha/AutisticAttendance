/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import autisticattendence.be.Student;
import autisticattendence.be.Teacher;
import autisticattendence.gui.model.LoginModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ollie
 */
public class LoginViewController implements Initializable
{

    LoginModel loginModel;
    
    boolean teacher = false;
    boolean student = false;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        loginModel = new LoginModel();
    }    

    @FXML
    private void loginBtn(ActionEvent event) throws IOException {
        loginBtn.arm();
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        
        loginModel.loadStudents();
        List<Student> students = loginModel.getAllStudents();
    
    for (int i = 0; i < students.size(); i++) {
        Student st = students.get(i);
    if(username.equals(st.getUsername()) && password.equals(st.getPassword()) && student == false) {
        student = true;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/autisticattendence/gui/view/StudentView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        stage.close();
        Stage studentView = new Stage();
        StudentViewController svController=fxmlLoader.getController();
        studentView.setTitle("EASV Students Window");
        studentView.setScene(new Scene(root1));
        svController.setStudent(st);
        studentView.show();
        loginBtn.disarm();
        }
    }
    loginModel.loadTeachers();
    List<Teacher> teachers = loginModel.getAllTeachers();
    
    for (int i = 0; i < teachers.size(); i++) {
        Teacher te = teachers.get(i);
            if (username.equals(te.getUsername()) && password.equals(te.getPassword()) && teacher == false) {
            teacher = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/autisticattendence/gui/view/TeacherView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();
            Stage teacherWindow = new Stage();
            TeacherViewController twController=fxmlLoader.getController();
            teacherWindow.setTitle("EASV Teachers Window");
            teacherWindow.setScene(new Scene(root1));
            twController.setTeacher(te);
            teacherWindow.show(); 
            loginBtn.disarm();
            }
       } 
    if(student == false && teacher == false) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Failed to login.");
            alert.setHeaderText("Login failed.");
            alert.setContentText("Wrong username or password");
            alert.showAndWait();
            alert.close();
            loginBtn.disarm();
            } 
    }
    
    public void setModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
    }
    

