/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import autisticattendence.be.AttendanceDay;
import autisticattendence.be.Class;
import autisticattendence.be.Student;
import autisticattendence.be.Teacher;
import autisticattendence.gui.model.StudentViewModel;
import autisticattendence.gui.model.TeacherViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ollie
 */
public class TeacherViewController implements Initializable {
    
    private TeacherViewModel tvm;
    private StudentViewModel svm;

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
    private TableColumn<Class, String> classClm;
    @FXML
    private TableView<Student> todayTableView;
    @FXML
    private TableColumn<Student, ImageView> imageClm;
    @FXML
    private TableColumn<Student, String> nameClm;
    @FXML
    private TableColumn<Student, String> statusClm;
    @FXML
    private TableView<Student> overallTableView;
    @FXML
    private TableColumn<Student, ImageView> imageClm2;
    @FXML
    private TableColumn<Student, String> nameClm2;
    @FXML
    private TableView<Class> classTableView;
    @FXML
    private TableColumn<Student, String> lastNameClm;
    @FXML
    private TableColumn<Student, Integer> AbsentClm21;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tvm = TeacherViewModel.getInstance();
            svm = StudentViewModel.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(TeacherViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            tvm.updateTeacher(tvm.getTeacher());
        
        
            
        
        classTableView.setItems(tvm.getClasses());
        classClm.setCellValueFactory(
                new PropertyValueFactory("className")); 
        tvm.loadClasses();
        tvm.loadClassesTeachers();
        tvm.loadStudentsInClasses();
//        todayTableView.setItems(svm.getAllStudents());
//        imageClm.setCellValueFactory(
//                new PropertyValueFactory("fileLink"));
//        nameClm.setCellValueFactory(
//                new PropertyValueFactory("firstName"));
//        statusClm.setCellValueFactory(
//                new PropertyValueFactory("DidAttend"));
        //svm.loadStudents();
        AbsentClm21.setSortType(TableColumn.SortType.DESCENDING);
        overallTableView.setItems(svm.getAllStudents());
        nameClm2.setCellValueFactory(
                new PropertyValueFactory("firstName"));
        lastNameClm.setCellValueFactory(
                new PropertyValueFactory("lastName"));
        AbsentClm21.setCellValueFactory(
                new PropertyValueFactory("AbsencePercent"));
        svm.loadStudents();
        
        overallTableView.getSortOrder().add(AbsentClm21);
        
//        imageClm2.setCellValueFactory(
//        new PropertyValueFactory("filelink"));
//        //       Image image = new Image("profile-default-male.png");
//       TableColumn<Student, ImageView> setCellValueFactory = new TableColumn();
//       setCellValueFactory.getColumns();
//       setCellValueFactory.cellValueFactoryProperty();
//       final ImageView imageview = new ImageView();
//       imageview.setFitHeight(50);
//       imageview.setFitWidth(50);
//       
//
//       //Set up the Table
//       TableCell<Student, Image> cell = new TableCell<Student, Image>() {
//           public void updateItem(Image item, boolean empty) {
//             if (item != null) {
//                  imageview.setImage(item);
//             }
//           }
//        };
//        // Attach the imageview to the cell
//        cell.setGraphic(imageview);
//        return cell;
//   
// 
        
        
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
        tvm.getTeacher().setLoggedIn(false);
        tvm.updateTeacher(tvm.getTeacher());
    }

    @FXML
    private void getSelectedClass(MouseEvent event) {
        
        overallTableView.setItems(FXCollections.observableArrayList(classTableView.getSelectionModel().getSelectedItem().getClassList()));
        classLbl.setText(classTableView.getSelectionModel().getSelectedItem().getClassName());
    }

    
    
}
