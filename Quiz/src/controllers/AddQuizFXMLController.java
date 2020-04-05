/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javax.management.Notification;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Md Ataullha
 */
public class AddQuizFXMLController implements Initializable {

    @FXML
    private JFXTextField quizTitle;
    @FXML
    private JFXTextArea question;
    @FXML
    private JFXTextField option1;
    @FXML
    private JFXTextField option2;
    @FXML
    private JFXTextField option3;
    @FXML
    private JFXTextField option4;
    @FXML
    private JFXRadioButton option1radio;
    @FXML
    private JFXRadioButton option2radio;
    @FXML
    private JFXRadioButton option3radio;
    @FXML
    private JFXRadioButton option4radio;
    @FXML
    private Button AddNextQuestion;
    @FXML
    private Button SumbitQuestion;
    
    private ToggleGroup radioGroup;
    @FXML
    private JFXButton setQuizTitleButton;
    @FXML
    private Button SumbitQuestion1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radioButtonSetup();
    }  
    
    private void radioButtonSetup(){
        radioGroup = new ToggleGroup();
        option1radio.setToggleGroup(radioGroup);
        option2radio.setToggleGroup(radioGroup);
        option3radio.setToggleGroup(radioGroup);
        option4radio.setToggleGroup(radioGroup);
    }

    @FXML
    private void setQuizTitle(ActionEvent event) {
        System.out.println("SetQuizTitle");
        if(quizTitle.getText().trim().isEmpty()){
            System.out.println("Enter a valid title");
            Notifications notification = Notifications.create();
            notification.text("Add A Valid Title");
            notification.title("QUIZ TITLE");
            notification.darkStyle();
            notification.position(Pos.TOP_RIGHT);
           notification.showError();
           notification.hideAfter(javafx.util.Duration.millis(2000));
            
            
            
//            Alert a = new Alert(AlertType.NONE);
//            a.setAlertType(AlertType.WARNING);
//            //setContentText("Please Enter a valid Title");
//            a.setTitle("Enter A Valid Title");
//            a.setContentText("Please Enter A valid Title for your Quiz");
//            a.show();
            
            
        }
        else{
            System.out.println("Save");
            quizTitle.setEditable(false);
        }
    }


    @FXML
    private void submitQuiz(ActionEvent event) {
        
    }

    @FXML
    private void cancel(ActionEvent event) {
        
    }

    @FXML
    private void addNextQuestion(ActionEvent event) {
          String ques = this.question.getText();
         String op1 = this.question.getText();
         String op2 = this.question.getText();
         String op3 = this.question.getText();
         String op4 = this.question.getText();
         Toggle selectanop = radioGroup.getSelectedToggle();
       ///*************  System.out.println(selectanop);
            int mark=0;
            if(ques.trim().isEmpty()||op1.trim().isEmpty()||op2.trim().isEmpty()||op3.trim().isEmpty()||op4.trim().isEmpty()){
        if(ques.trim().isEmpty()){
            mark=1;
            System.out.println("");
            Notifications notification = Notifications.create();
            notification.text("Add your question for the next setps");
            notification.title("ENTER A VALID WORD FOR YOUR QUESTION(BLANK QUESTION IS NOT ALLOWED)");
            notification.darkStyle();
            notification.position(Pos.TOP_RIGHT);
           notification.showError();
           notification.hideAfter(javafx.util.Duration.millis(2000));
        }
        else if(op1.trim().isEmpty()||op2.trim().isEmpty()||op3.trim().isEmpty()||op4.trim().isEmpty()){
              System.out.println("");
            Notifications notification = Notifications.create();
            notification.text("Add All Four Options of This Questions If Have");
            notification.title("QUIZ ALL OPTIONS [OPTION A,OPTION B,OPTION C,OPTION D]");
            notification.darkStyle();
            notification.position(Pos.TOP_RIGHT);
           notification.showError();
           notification.hideAfter(javafx.util.Duration.millis(2000));
        }
        }
        else{
            if(selectanop==null){
                  System.out.println("Enter a valid title");
            Notifications notification = Notifications.create();
            notification.text("Add A Valid Option For Quiz Answer If Have");
            notification.title("QUIZ CORRECT OPTION");
            notification.darkStyle();
            notification.position(Pos.TOP_RIGHT);
           notification.showWarning();
           notification.hideAfter(javafx.util.Duration.millis(2000));
            }
            else{
                ///save the questions in file and show this
                
            }
        }
        
    }
}
