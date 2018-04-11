/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autisticattendence.gui.controller;

import autisticattendence.be.AttendanceDay;
import autisticattendence.be.Student;
import autisticattendence.gui.model.StudentViewModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
public class StudentViewController implements Initializable
{

    StudentViewModel svm;
    
    @FXML
    private Label nameLbl;
    @FXML
    private Label totalLbl;
    
    private Student student;
    @FXML
    private JFXButton logOut;
    @FXML
    private JFXRadioButton presentRbtn;
    @FXML
    private ToggleGroup grp;
    @FXML
    private JFXRadioButton absentRbtn;
    @FXML
    private JFXButton submitBtn;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private Label regLbl;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private NumberAxis nrAxis;
    @FXML
    private CategoryAxis daysAxis;
    @FXML
    private PieChart pieChart;
    @FXML
    private TableView<AttendanceDay> daysTable;
    @FXML
    private TableColumn<AttendanceDay, String> dateClm;
    @FXML
    private TableColumn<AttendanceDay, String> absenceClm;
    @FXML
    private TableColumn<AttendanceDay, String> dayClm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try {
            svm = StudentViewModel.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(StudentViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) { 
            Logger.getLogger(StudentViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        datePicker.setValue(LocalDate.now());
//        regLbl.setVisible(false);
//        for (AttendanceDay day : svm.getAllStudentDays(svm.getStudent().getStudentId()))
//        {
//            if (day.getDateTime().equals(datePicker.getValue().toString())) {
//                submitBtn.setVisible(false);
//                regLbl.setVisible(true);
//                regLbl.setText("Attendance registred for today!");
//            }
//        }
        totalLbl.setText("Total percent:" + svm.getStudent().getAbsencePercent());
        svm.getatd().addAll(svm.getAllStudentDays(svm.getStudent().getStudentId()));
        
        daysTable.setItems(svm.getatd());
        dayClm.setCellValueFactory(
                new PropertyValueFactory("weekDay"));
        dateClm.setCellValueFactory(
                new PropertyValueFactory("dateTime"));
        absenceClm.setCellValueFactory(
                new PropertyValueFactory("BeenToSchool"));
    }

    public void setStudent(Student student) {
        this.student = student;
        String studentFName = student.getFirstName();
        String studentLName = student.getLastName();  
   //     String studentAttendance = Float.toString(student.getAttendance);
        nameLbl.setText(studentFName + " " + studentLName);
        //tfAbsence.setText("BABY IS DEAD");
        //tfCourse.setText(studentCourse);
        
        barChart.setTitle("Absent Days");
        nrAxis.setLabel("Days");
        daysAxis.setLabel("Absent Days");
        barChart.setLegendVisible(false);
        barChart.setVisible(true);
        XYChart.Series<String, Number> series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data("Monday", svm.absentMondays(svm.getStudent().getStudentId())));
        series1.getData().add(new XYChart.Data("Thuesday", svm.absentTuesday(svm.getStudent().getStudentId())));
        series1.getData().add(new XYChart.Data("Wednesday", svm.absentWednesday(svm.getStudent().getStudentId())));
        series1.getData().add(new XYChart.Data("Thursday", svm.absentThursday(svm.getStudent().getStudentId())));
        series1.getData().add(new XYChart.Data("Friday", svm.absentFriday(svm.getStudent().getStudentId())));
        
        List<XYChart.Series<String, Number>> list = new ArrayList<>();
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableList(list);
        data.add(series1);
        barChart.setData(data);
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Days attended", 100 - svm.getStudent().getAbsencePercent()),
        new PieChart.Data("Days absent", svm.getStudent().getAbsencePercent()));
        pieChart.setTitle("Attendance");
        pieChart.setData(pieChartData);
        
    }    

    @FXML
    private void submit(ActionEvent event)
    {
       if (grp.getSelectedToggle().equals(presentRbtn) && DoesDayExist() == false) {
            AttendanceDay day = new AttendanceDay();
            day.setDateTime(datePicker.getValue().toString());
            day.setBeenToSchool(true);
            day.setStudentId(svm.getStudent().getStudentId());
            day.setWeekDay(datePicker.getValue().getDayOfWeek().toString());
            day.setDateNr(datePicker.getValue().toEpochDay());
            svm.getatd().add(day);
            svm.getStudent().setDidAttend("Present");
            svm.getAllStudentDays(svm.getStudent().getStudentId());
            svm.setStudentAbsencePercent(student.getStudentAbsenceDays());
            svm.updateStudent(svm.getStudent());
            totalLbl.setText("Total percent:" + student.getAbsencePercent());
            svm.addDay(day);
//            submitBtn.setVisible(false);
//            regLbl.setVisible(true);
            regLbl.setText("Attendance registred for today!");
       } else if (grp.getSelectedToggle().equals(absentRbtn) && DoesDayExist() == false) {
            AttendanceDay day = new AttendanceDay();
            day.setDateTime(datePicker.getValue().toString());
            day.setBeenToSchool(false);
            day.setDateNr(datePicker.getValue().toEpochDay());

            day.setStudentId(svm.getStudent().getStudentId());
            day.setWeekDay(datePicker.getValue().getDayOfWeek().toString());
            svm.getatd().add(day);
            svm.getStudent().setDidAttend("Absent");
            svm.getAllStudentDays(svm.getStudent().getStudentId());
            svm.setStudentAbsenceDays(student.getStudentAbsenceDays() + 1);
            svm.setStudentAbsencePercent(student.getStudentAbsenceDays());
            totalLbl.setText("Total percent:" + student.getAbsencePercent());
            svm.updateStudent(svm.getStudent());
            svm.addDay(day);
//            submitBtn.setVisible(false);
//            regLbl.setVisible(true);
            regLbl.setText("Attendance registred for today!");
       }
    }
    
     private boolean DoesDayExist()
    {

        for (AttendanceDay day : svm.getAllStudentDays(svm.getStudent().getStudentId()))
        {
            if (day.getDateTime().equals(datePicker.getValue().toString()))
            {
                if (day.isBeenToSchool() == true)
                {
                    day.setBeenToSchool(false);
                    svm.setStudentAbsenceDays(svm.getStudent().getStudentAbsenceDays() + 1);
                    svm.setStudentAbsencePercent(svm.getStudent().getStudentAbsenceDays());
                    svm.updateDay(day);
                    svm.updateStudent(svm.getStudent());
                    System.out.println(svm.getStudent().getStudentAbsenceDays());

                } else if (day.isBeenToSchool() == false)
                {
                    day.setBeenToSchool(true);
                    svm.setStudentAbsenceDays(svm.getStudent().getStudentAbsenceDays() - 1);
                    svm.setStudentAbsencePercent(svm.getStudent().getStudentAbsenceDays());
                    svm.updateDay(day);
                    svm.updateStudent(svm.getStudent());

                }
                totalLbl.setText("Total percent:" + svm.getStudent().getAbsencePercent());
                return true;
            }

        }

        return false;
    }


    @FXML
    private void logOut(ActionEvent event) throws IOException {
        svm.updateStudent(student);
        Stage stage1 = (Stage) logOut.getScene().getWindow();
        stage1.close();
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/autisticattendence/gui/view/LoginView.fxml"));

        Scene scene = new Scene(root);
            

        stage.setScene(scene);
        stage.show();
    }
    
}
