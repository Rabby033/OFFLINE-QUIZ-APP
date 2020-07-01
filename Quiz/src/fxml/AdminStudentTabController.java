/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.VBox;
import javax.management.Notification;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Md Ataullha
 */
public class AdminStudentTabController implements Initializable {

    @FXML
    private VBox formContainer;
    @FXML
    private JFXTextField studentName;
    @FXML
    private JFXTextField regNo;
    @FXML
    private TreeTableView<?> studentTable;
    @FXML
    private TreeTableColumn<?, ?> studentNameColumn;
    @FXML
    private TreeTableColumn<?, ?> registrationNoColumn;
    @FXML
    private JFXButton saveButton;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveStudent(ActionEvent event) {
       String sName = this.studentName.getText();
       String sRegNo = this.regNo.getText();
       System.out.println(sName);
        System.out.println(sRegNo);
        String msg = null;
        if(sName.length()<=0 || sRegNo.length()!=10){
            msg="Student Name && Registration No. Must be filled!";
            }
        if(msg!=null){
             Notifications.create()
                        .title("Insert Both Name & Reg Correctly")
                        .darkStyle()
                        .position(Pos.CENTER_LEFT)
                        .text(msg)
                        .showError();
        } 
    }
    
    
}
