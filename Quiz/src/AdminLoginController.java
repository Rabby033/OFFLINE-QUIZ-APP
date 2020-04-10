/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Md Ataullha
 */
public class AdminLoginController implements Initializable {

    @FXML
    private TextField adminEmail;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private Button adminLoginButton;
    @FXML
    private Button studentLoginButton;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentRegistrationNo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginAdmin(ActionEvent event) throws IOException {
        String email = adminEmail.getText();
        String password = adminPassword.getText();
        if(email.trim().equalsIgnoreCase(Singup.Email) && password.trim().equalsIgnoreCase(Singup.Password)){
            
            try{
                 Notifications notification = Notifications.create();
                notification.text("Now you are ready");
                notification.title("LOGIN SUCCESSED!");
                notification.darkStyle();
                notification.position(Pos.CENTER);
                notification.showConfirm();
                notification.hideAfter(javafx.util.Duration.millis(2000));
                 Parent root = FXMLLoader.load(getClass().getResource("/fxml/AdminHomeFXML.fxml"));
             Stage stage = (Stage)studentName.getScene().getWindow();
                     Scene scene = new Scene(root);
                     stage.setScene(scene); 
                     stage.setMaximized(true);
            }
            catch(Exception e){
                e.printStackTrace();
                System.exit(0);
            }
                     
            
            System.out.println("Login Success"); 
        }else{
             Notifications notification = Notifications.create();
                notification.text("Pleae Register or Enter Correct Email and Pasword");
                notification.title("LOGIN FAILED!");
                notification.darkStyle();
                notification.position(Pos.CENTER);
                notification.showError();
                notification.hideAfter(javafx.util.Duration.millis(2000));
            System.out.println("Login Failed"); 
        }
    }

    @FXML
    private void loginStudent(ActionEvent event) {
        
    }

    @FXML
    private void adminRegister(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegistrationFXML.fxml"));
         Scene scene = new Scene(root); Notifications notification = Notifications.create();
                notification.text("Enter Your Correct Email & Password");
                notification.title("Registration!");
                notification.darkStyle();
                notification.position(Pos.CENTER);
                notification.showConfirm();
                notification.hideAfter(javafx.util.Duration.millis(2000));
         
             Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
             window.setScene(scene);
             window.show();
    }
        }
