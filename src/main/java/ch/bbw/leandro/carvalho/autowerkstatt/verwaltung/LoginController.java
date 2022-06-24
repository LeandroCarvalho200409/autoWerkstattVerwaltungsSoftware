package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField pwdField;
    @FXML
    private Button loginButton;

    private HelloApplication helloApplication;

    public void loginHandler(){
        try {
            String username = usernameField.getText();
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            if(autogarage.anmelden(username, pwdField.getText()) == true){
                Stage stage = helloApplication.getStage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                String css = this.getClass().getResource("home.css").toExternalForm();
                scene.getStylesheets().add(css);
                stage.close();
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.setResizable(false);
                stage.show();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
