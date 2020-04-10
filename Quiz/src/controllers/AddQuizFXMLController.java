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
import jason.stdlib.count;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javax.management.Notification;
import static javax.management.Query.value;
import static javax.print.attribute.standard.MediaSizeName.C;
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
    static int count = 1;

    /**
     * Initializes the controller class.
     */
    /**
     * Variables That Created by Programmer
     */
    private String title = null;
//    private HashMap<String, String[]> questions = new HashMap<>();
    @FXML
    private TextField noOfQuestion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radioButtonSetup();
    }

    private void radioButtonSetup() {
        radioGroup = new ToggleGroup();
        option1radio.setToggleGroup(radioGroup);
        option2radio.setToggleGroup(radioGroup);
        option3radio.setToggleGroup(radioGroup);
        option4radio.setToggleGroup(radioGroup);
    }

    @FXML
    private void setQuizTitle(ActionEvent event) {
        System.out.println("SetQuizTitle");
        if (quizTitle.getText().trim().isEmpty()) {
            System.out.println("Enter a valid title");
            Notifications notification = Notifications.create();
            notification.text("Add A Valid Title");
            notification.title("QUIZ TITLE");
            notification.darkStyle();
            notification.position(Pos.TOP_RIGHT);
            notification.showError();
            notification.hideAfter(javafx.util.Duration.millis(2000));

        } else {
            Notifications notification = Notifications.create();
            notification.text("By Clicking here from now you are unable to edit this Title ");
            notification.title("Click Cancel to Edit Again!");
            notification.darkStyle();
            notification.position(Pos.CENTER);
            notification.showInformation();
            System.out.println("Save");
            quizTitle.setEditable(false);
            title = quizTitle.getText();
            System.out.println(title);
        }

    }

    @FXML
    private void submitQuiz(ActionEvent event) {
        Notifications notification = Notifications.create();
        if (question.getText().length() > 0) {
            String qu = question.getText();
            String nae = title;
            String R = nae + ".txt";
            String name = R;
            String a, b, c, d, ans = "";

            {

                a = option1.getText();
                b = option2.getText();
                c = option3.getText();
                d = option4.getText();

                Toggle selected = radioGroup.getSelectedToggle();
                if (selected == option1radio) {
                    ans = option1.getText();
                } else if (selected == option2radio) {
                    ans = option2.getText();
                } else if (selected == option3radio) {
                    ans = option3.getText();
                } else if (selected == option4radio) {
                    ans = option4.getText();
                }

                // data[4] = ans.getText();
                //  int flag=true;
                try {
                    String fname = name;
                    File file = new File(fname);
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    br.write(+count + "." + qu + "\n");
                    br.write("A :" + a + "\n");
                    br.write("B :" + b + "\n");
                    br.write("C :" + c + "\n");
                    br.write("D :" + d + "\n");
                    br.write("Answer :" + ans + "\n");
                    br.close();
                    count++;
                    question.clear();
                    option1.clear();
                    option2.clear();
                    option3.clear();
                    option4.clear();
                    quizTitle.setEditable(true);
                    notification.text("Check The F:\\NetBeansProjects\\Quiz\\" + title + ".txt file for your question Data");
                    notification.title("SUBMITTED!");
                    notification.position(Pos.CENTER);
                    notification.showInformation();
                    quizTitle.clear();
                    count = 1;
                    noOfQuestion.setText(count + "");
                } catch (IOException e) {
                }
                noOfQuestion.setText(count + "");
                if (quizTitle.getText().trim().isEmpty()) {
                    System.out.println("Enter a valid title");
                    //    Notifications notification = Notifications.create();
                    notification.text("Add A Valid Title");
                    notification.title("QUIZ TITLE");
                    notification.darkStyle();
                    notification.position(Pos.TOP_RIGHT);
                    notification.showError();
                    notification.hideAfter(javafx.util.Duration.millis(2000));

                } else {
                    //  Notifications notification = Notifications.create();
                    notification.text("By Clicking here from now you are unable to edit this Title ");
                    notification.title("Click Cancel to Edit Again!");
                    notification.darkStyle();
                    notification.position(Pos.CENTER);
                    notification.showInformation();
                    System.out.println("Save");
                    quizTitle.setEditable(false);
                    title = quizTitle.getText();
                    System.out.println(title);
                }

            }
        } else {
            notification.text("Check The F:\\NetBeansProjects\\Quiz\\" + title + ".txt file for your question Data");
            notification.title("SUBMITTED!");
            notification.position(Pos.CENTER);
            notification.showInformation();
            quizTitle.clear();
            quizTitle.setEditable(true);
            count = 1;
            noOfQuestion.setText(count + "");
            if (quizTitle.getText().trim().isEmpty()) {
                System.out.println("Enter a valid title");
                //  Notifications notification = Notifications.create();
                notification.text("Add A Valid Title");
                notification.title("QUIZ TITLE");
                notification.darkStyle();
                notification.position(Pos.TOP_RIGHT);
                notification.showError();
                notification.hideAfter(javafx.util.Duration.millis(2000));

            } else {
                //  Notifications notification = Notifications.create();
                notification.text("By Clicking here from now you are unable to edit this Title ");
                notification.title("Click Cancel to Edit Again!");
                notification.darkStyle();
                notification.position(Pos.CENTER);
                notification.showInformation();
                System.out.println("Save");
                quizTitle.setEditable(false);
                title = quizTitle.getText();
                System.out.println(title);
            }
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Notifications notification = Notifications.create();
        notification.text("By Clicking here you are now able to edit the title");
        notification.title("Cancel Title");
        notification.darkStyle();
        notification.position(Pos.CENTER);
        notification.showConfirm();
        System.out.println("Cancel");
        quizTitle.setEditable(true);
    }

    @FXML
    private void addNextQuestion(ActionEvent event) throws IOException {
        String ques = this.question.getText();
        String op1 = this.question.getText();
        String op2 = this.question.getText();
        String op3 = this.question.getText();
        String op4 = this.question.getText();
        Toggle selectanop = radioGroup.getSelectedToggle();
        ///*************  System.out.println(selectanop);
        int mark = 0;
        if (ques.trim().isEmpty() || op1.trim().isEmpty() || op2.trim().isEmpty() || op3.trim().isEmpty() || op4.trim().isEmpty()) {
            if (ques.trim().isEmpty()) {
                mark = 1;
                System.out.println("");
                Notifications notification = Notifications.create();
                notification.text("Add your question for the next setps");
                notification.title("ENTER A VALID WORD FOR YOUR QUESTION(BLANK QUESTION IS NOT ALLOWED)");
                notification.darkStyle();
                notification.position(Pos.TOP_RIGHT);
                notification.showError();
                notification.hideAfter(javafx.util.Duration.millis(2000));
            } else if (op1.trim().isEmpty() || op2.trim().isEmpty() || op3.trim().isEmpty() || op4.trim().isEmpty()) {
                System.out.println("");
                Notifications notification = Notifications.create();
                notification.text("Add All Four Options of This Questions If Have");
                notification.title("QUIZ ALL OPTIONS [OPTION A,OPTION B,OPTION C,OPTION D]");
                notification.darkStyle();
                notification.position(Pos.TOP_RIGHT);
                notification.showError();
                notification.hideAfter(javafx.util.Duration.millis(2000));
            }
        } else {
            if (selectanop == null) {
                System.out.println("Enter a valid title");
                Notifications notification = Notifications.create();
                notification.text("Add A Valid Option For Quiz Answer If Have");
                notification.title("QUIZ CORRECT OPTION");
                notification.darkStyle();
                notification.position(Pos.TOP_RIGHT);
                notification.showWarning();
                notification.hideAfter(javafx.util.Duration.millis(2000));
            } else {
                String qu = question.getText();
                String nae = title;
                String R = nae + ".txt";
                String name = R;
                String a, b, c, d, ans = "";

                {

                    a = option1.getText();
                    b = option2.getText();
                    c = option3.getText();
                    d = option4.getText();

                    Toggle selected = radioGroup.getSelectedToggle();
                    if (selected == option1radio) {
                        ans = option1.getText();
                    } else if (selected == option2radio) {
                        ans = option2.getText();
                    } else if (selected == option3radio) {
                        ans = option3.getText();
                    } else if (selected == option4radio) {
                        ans = option4.getText();
                    }

                    // data[4] = ans.getText();
                    //  int flag=true;
                    try {
                        String fname = name;
                        File file = new File(fname);
                        FileWriter fr = new FileWriter(file, true);
                        BufferedWriter br = new BufferedWriter(fr);
                        br.write(+count + "." + qu + "\n");
                        br.write("A :" + a + "\n");
                        br.write("B :" + b + "\n");
                        br.write("C :" + c + "\n");
                        br.write("D :" + d + "\n");
                        br.write("Answer :" + ans + "\n");
                        br.close();
                        count++;
                        question.clear();
                        option1.clear();
                        option2.clear();
                        option3.clear();
                        option4.clear();
                    } catch (IOException e) {
                    }
                    noOfQuestion.setText(count + "");

                }

            }
        }

    }

    @FXML
    private void close(ActionEvent event) {
        Notifications notification = Notifications.create();
        notification.text("By Clicking here you are exiting from this Application");
        notification.title("Confirm?");
        notification.darkStyle();
        notification.position(Pos.CENTER);
        notification.showConfirm();
        System.exit(200);
    }
}
