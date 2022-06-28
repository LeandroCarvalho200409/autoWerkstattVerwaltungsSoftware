package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class HelloApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene loginStart = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(loginStart);
        stage.setResizable(false);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        launch();
    }
}