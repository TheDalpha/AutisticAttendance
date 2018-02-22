/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        totalLbl.setText("Total Absence: ");
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
    
}
