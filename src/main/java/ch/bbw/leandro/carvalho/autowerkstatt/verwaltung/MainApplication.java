package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Diese ist die Main Klasse, welche einerseits die initiale Autogarage erstellt, aber auch das Login-Fenster aufruft.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class MainApplication extends Application {

    private static Stage stage;

    /**
     * Hiermit wird das Login-Fenster aufgerufen.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene loginStart = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(loginStart);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Hiermit wird das Stage, welches über das ganze Projekt gebraucht wird zurückgegeben.
     * @return
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * Dies ist die Main-Methode, welche die Autogarage initialisiert und die Applikation startet.
     * @param args
     */
    public static void main(String[] args) {
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        launch();
    }
}