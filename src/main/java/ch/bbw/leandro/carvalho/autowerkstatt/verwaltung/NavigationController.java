package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Diese Klasse hier dient als Controller für die Navigationsfunktion der Applikation.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class NavigationController {

    private HelloApplication helloApplication;

    /**
     * Hiermit wird die Seite zum Anmelden wieder aufgerufen.
     */
    public void logout(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene loginStart = new Scene(fxmlLoader.load());
            stage.setTitle("Login");
            stage.setScene(loginStart);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Hiermit wird die Startseite der Applikation geöffnet.
     */
    public void openHome(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene home = new Scene(fxmlLoader.load());
            stage.setTitle("Home");
            stage.setScene(home);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Hiermit wird die Startseite der Mitarbeiter geöffnet.
     */
    public void openMitarbeiter(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mitarbeiter_home.fxml"));
            Scene mitarbeiterHome = new Scene(fxmlLoader.load());
            MitarbeiterController controller = fxmlLoader.getController();
            controller.renderMitarbeiter();
            stage.setTitle("Mitarbeiter | Home");
            stage.setScene(mitarbeiterHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Hiermit wird die Startseite der Kunden geöffnet.
     */
    public void openKunden(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("kunden_home.fxml"));
            Scene kundenHome = new Scene(fxmlLoader.load());
            KundenController controller = fxmlLoader.getController();
            controller.renderKunden();
            stage.setTitle("Kunden | Home");
            stage.setScene(kundenHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Hiermit wird die Startseite der Fahrzeuge geöffnet.
     */
    public void openFahrzeuge(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fahrzeug_home.fxml"));
            Scene fahrzeugHome = new Scene(fxmlLoader.load());
            FahrzeugeController controller = fxmlLoader.getController();
            controller.renderCarsPendent();
            stage.setTitle("Fahrzeuge | Home");
            stage.setScene(fahrzeugHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Hiermit wird die Startseite der Ersatzteile geöffnet.
     */
    public void openErsatzteile(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ersatzteile_home.fxml"));
            Scene ersatzteileHome = new Scene(fxmlLoader.load());
            ErsatzteileController controller = fxmlLoader.getController();
            controller.renderErsatzteile();
            stage.setTitle("Ersatzteile | Home");
            stage.setScene(ersatzteileHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Hiermit wird die Startseite der Aufträge geöffnet.
     */
    public void openAuftraege(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("auftaege_home.fxml"));
            Scene auftraegeHome = new Scene(fxmlLoader.load());
            AuftraegeController controller = fxmlLoader.getController();
            stage.setTitle("Aufträge | Home");
            stage.setScene(auftraegeHome);
            stage.setResizable(false);
            stage.show();
            controller.renderAuftraegePendent();
            controller.renderAuftraegeErledigt();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
