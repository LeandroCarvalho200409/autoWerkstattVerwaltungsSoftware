package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationController {

    private HelloApplication helloApplication;

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

    public void openMitarbeiter(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mitarbeiter_home.fxml"));
            Scene mitarbeiterHome = new Scene(fxmlLoader.load());
            stage.setTitle("Mitarbeiter | Home");
            stage.setScene(mitarbeiterHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openKunden(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("kunden_home.fxml"));
            Scene kundenHome = new Scene(fxmlLoader.load());
            stage.setTitle("Kunden | Home");
            stage.setScene(kundenHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openFahrzeuge(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fahrzeug_home.fxml"));
            Scene fahrzeugHome = new Scene(fxmlLoader.load());
            stage.setTitle("Fahrzeuge | Home");
            stage.setScene(fahrzeugHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openErsatzteile(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ersatzteile_home.fxml"));
            Scene ersatzteileHome = new Scene(fxmlLoader.load());
            stage.setTitle("Ersatzteile | Home");
            stage.setScene(ersatzteileHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openAuftraege(){
        try {
            Stage stage = this.helloApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("auftaege_home.fxml"));
            Scene auftraegeHome = new Scene(fxmlLoader.load());
            stage.setTitle("Aufträge | Home");
            stage.setScene(auftraegeHome);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
