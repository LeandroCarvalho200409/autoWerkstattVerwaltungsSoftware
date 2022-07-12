package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.login;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Autogarage;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Diese Klasse dient als Controller für die Login-Seite.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField pwdField;
    @FXML
    private Button loginButton;
    @FXML
    private Label errorLabel;

    private MainApplication mainApplication;

    /**
     * In dieser Methode wird die Anmeldung eines Users getätigt. Falls die Anmeldedaten nicht übereinstimmen oder schlichtweg nicht existieren, wird die
     * LoginException geworfen und somit im Login-Fenster eine Nachricht ausgegeben.
     */
    public void loginHandler(){
        try {
            String username = usernameField.getText();
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            if(autogarage.anmelden(username, pwdField.getText()) == true){
                Stage stage = mainApplication.getStage();
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                String css = this.getClass().getResource("/ch/bbw/leandro/carvalho/autowerkstatt/verwaltung/home.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.close();
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.setResizable(false);
                stage.show();
            }else{
                throw new LoginException("Anmeldungsdaten falsch oder User nicht vorhanden");
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (LoginException e){
            errorLabel.setText(e.getMessage());
        }
    }
}
