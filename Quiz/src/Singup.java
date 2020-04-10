
import jason.stdlib.length;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Md Ataullha
 */
public class Singup {
    public static String Email="@#@dsrewe54";
    public static String Password="w2453r33t5#@";
    @FXML
    private TextField adminRegistrationEmail;
    @FXML
    private PasswordField adminRegistrationPassword;
    @FXML
    private Button submitRegistrationForm;

    @FXML
    private void submitRegistration(ActionEvent event) throws IOException {
          Email = adminRegistrationEmail.getText();
        Password = adminRegistrationPassword.getText();
        if(Email.length()<11 || Password.length() <1){
        Notifications notification = Notifications.create();
                notification.text("Enter a valid gamil & Password");
                notification.title("IS This Valid?");
                notification.position(Pos.CENTER);
                notification.showError();
                notification.hideAfter(javafx.util.Duration.millis(2000));
    }
        else{
         Notifications notification = Notifications.create();
                notification.text("Registration Completed");
                notification.title("COMPLETED");
                notification.darkStyle();
                notification.position(Pos.CENTER);
                notification.showInformation();
                notification.hideAfter(javafx.util.Duration.millis(2000));
         Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
         Scene scene = new Scene(root);
             Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
             window.setScene(scene);
             window.show();
        
    }
}
    }
