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
import static com.sun.deploy.util.Waiter.set;
import static com.sun.javafx.fxml.expression.Expression.set;
import static java.lang.reflect.Array.set;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
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
import static javax.management.Query.value;
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
    private Button cancel;
    @FXML
    private Button close;

    /**
     * Initializes the controller class.
     */
    /**
     *  Variables That Created by Programmer
     */
    private String title = null;
    private HashMap<String,String[]> questions = new HashMap<>();
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
            
 
        }
        else{
            System.out.println("Save");
            quizTitle.setEditable(false);
            this.title=title;
//
        }
        
    }


    @FXML
    private void submitQuiz(ActionEvent event) {
        
    }

    @FXML
    private void cancel(ActionEvent event) {
           System.out.println("Cancel");
               quizTitle.setEditable(true);
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
                String[] data = new String[5];
                data[0] = option1.getText();
                 data[1] = option2.getText();
                  data[2] = option3.getText();
                   data[3] = option4.getText();
                   
                   Toggle selected = radioGroup.getSelectedToggle();
                   if(selected == option1radio){
                       data[4] = option1.getText();
                   }
                   else if(selected == option2radio){
                       data[4] = option2.getText();
                   }
                   else if(selected == option3radio){
                       data[4] = option3.getText();
                   }
                   else if(selected == option4radio) {
                       data[4] = option4.getText();
                   }
                   
                   // data[4] = ans.getText();
                questions.put(question.getText(),data);
                
                Set<String> keySet = questions.keySet();
                Iterator<String> it = keySet.iterator();
                while(it.hasNext()){
                   String qu = it.next();
                   String[] values = questions.get(qu);
                    System.out.println(qu);
                for(String s : values){
                    System.out.println(s);
                }
                
                }
            }
        }
        
    }
//

    @FXML
    private void close(ActionEvent event) {
    }
}
