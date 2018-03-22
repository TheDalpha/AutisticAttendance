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

    @FXML
    private TableView<Teacher> tableStudent;
    @FXML
    private TableColumn<Teacher, String> studentClmName;
    @FXML
    private TableColumn<Teacher, String> studentClmAbsence;
    @FXML
    private Label nameLbl;
    @FXML
    private Label totalLbl;
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
    private Label classLbl;
    @FXML
    private JFXComboBox<?> weekCombo;
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
    private ToggleGroup group1;
    @FXML
    private ToggleGroup group2;
    @FXML
    private ToggleGroup group3;
    @FXML
    private ToggleGroup group4;
    @FXML
    private ToggleGroup group5;
    @FXML
    private JFXButton logOut;
    

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

    @FXML
    private void classOne(ActionEvent event) {
    }

    @FXML
    private void classTwo(ActionEvent event) {
    }

    @FXML
    private void classThree(ActionEvent event) {
    }

    @FXML
    private void classFour(ActionEvent event) {
    }

    @FXML
    private void classFive(ActionEvent event) {
    }

    @FXML
    private void submit(ActionEvent event) {
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
