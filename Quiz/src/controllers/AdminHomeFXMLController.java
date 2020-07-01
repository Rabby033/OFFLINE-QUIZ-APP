/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTabPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author Md Ataullha
 */
public class AdminHomeFXMLController implements Initializable {

    @FXML
    private Tab addQuiz;
    @FXML
    private Tab addStudent;
    @FXML
    private JFXTabPane adminTab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddQuizFXML.fxml"));
            addQuiz.setContent(root);
            
            Parent StudentTabnode = FXMLLoader.load(getClass().getResource("/fxml/AdminStudentTab.fxml"));
            addStudent.setContent(StudentTabnode);
        } catch (Exception e) {
         e.printStackTrace();
    }    
    }
    
    
}
     
