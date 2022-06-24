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
        LocalDate date = LocalDate.of(2022, 2, 2);
        Kunde kunde = new Kunde("Carvalho", "Leandro", LocalDate.of(2022, 12, 12), new Adresse("Haselhalden", 18, "Saland", 8493), "test", "0778884455", "kunde1", LocalDate.of(2022, 12, 12));
        Mitarbeiter mitarbeiter = new Mitarbeiter("test", "test", LocalDate.of(2022, 2, 1), new Adresse("Haselhalden", 18, "Saland", 8493), "test", "test", "test", "12345", LocalDate.of(2022, 12, 20), "fest", true, 12, 5);
        Verkaufsfahrzeug fahrzeug = new Verkaufsfahrzeug("Mercedes-Benz", "E270 CDI Classic", "W210", 2700, 170, 5, "limousine", "schwarz", "ka", "W...", LocalDate.of(2001, 11, 12), 7500.0, false, kunde, LocalDate.of(2022, 6, 10));
        Ersatzteil ersatzteil = new Ersatzteil("test", "011", "Innenraum, Multimedia", "Bosch", 5, 560.99);
        Auftrag auftrag = new Auftrag(1 ,fahrzeug, "Service A", 1200, "pendent", LocalDate.of(2022, 7, 1), mitarbeiter);

        Auftrag auftrag1 = new Auftrag(2 ,fahrzeug, "Service A", 1200, "pendent", LocalDate.of(2022, 7, 1), mitarbeiter);
        Auftrag auftrag2 = new Auftrag(3 ,fahrzeug, "Service A", 1200, "pendent", LocalDate.of(2022, 7, 1), mitarbeiter);
        Auftrag auftrag3 = new Auftrag(4 ,fahrzeug, "Service A", 1200, "pendent", LocalDate.of(2022, 7, 1), mitarbeiter);
        Auftrag auftrag4 = new Auftrag(5 ,fahrzeug, "Service A", 1200, "pendent", LocalDate.of(2022, 7, 1), mitarbeiter);
        Auftrag auftrag5 = new Auftrag(6 ,fahrzeug, "Service A", 1200, "pendent", LocalDate.of(2022, 7, 1), mitarbeiter);
        Auftrag auftrag6 = new Auftrag(7 ,fahrzeug, "Service A", 1200, "pendent", LocalDate.of(2022, 7, 1), mitarbeiter);

        autogarage.addAuftrag(auftrag1);
        autogarage.addAuftrag(auftrag2);
        autogarage.addAuftrag(auftrag3);
        autogarage.addAuftrag(auftrag4);
        autogarage.addAuftrag(auftrag5);
        autogarage.addAuftrag(auftrag6);


        autogarage.addAuftrag(auftrag);
        autogarage.addErsatzteil(ersatzteil);
        autogarage.addFahrzeug(fahrzeug);
        autogarage.addPerson(kunde);
        autogarage.addPerson(mitarbeiter);
        autogarage.saveData();
        autogarage.getData();
        autogarage.getPerson();
        launch();
    }
}