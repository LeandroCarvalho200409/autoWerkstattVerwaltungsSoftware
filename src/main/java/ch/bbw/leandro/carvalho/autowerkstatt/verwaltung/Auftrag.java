package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;
import java.util.ArrayList;

public class Auftrag {
    private Fahrzeug fahrzeug;
    private ArrayList<Ersatzteil> ersatzteile;
    private String art;
    private int preis;
    private ArrayList<String> gebieteDesFahrzeuges;
    private String status;
    private LocalDate zuErledigenBis;
    private ArrayList<Mitarbeiter> zustaendigeMitarbeiter;
    private Mitarbeiter verantwortlicheMitarbeiter;

    public Auftrag(Fahrzeug fahrzeug, String art, int preis, String status, LocalDate zuErledigenBis, Mitarbeiter verantwortlicheMitarbeiter) {
        this.fahrzeug = fahrzeug;
        this.art = art;
        this.preis = preis;
        this.status = status;
        this.zuErledigenBis = zuErledigenBis;
        this.verantwortlicheMitarbeiter = verantwortlicheMitarbeiter;
        this.ersatzteile = new ArrayList<>();
        this.gebieteDesFahrzeuges = new ArrayList<>();
        this.zustaendigeMitarbeiter = new ArrayList<>();
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public ArrayList<Ersatzteil> getErsatzteile() {
        return ersatzteile;
    }

    public void setErsatzteile(ArrayList<Ersatzteil> ersatzteile) {
        this.ersatzteile = ersatzteile;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public ArrayList<String> getGebieteDesFahrzeuges() {
        return gebieteDesFahrzeuges;
    }

    public void setGebieteDesFahrzeuges(ArrayList<String> gebieteDesFahrzeuges) {
        this.gebieteDesFahrzeuges = gebieteDesFahrzeuges;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getZuErledigenBis() {
        return zuErledigenBis;
    }

    public void setZuErledigenBis(LocalDate zuErledigenBis) {
        this.zuErledigenBis = zuErledigenBis;
    }

    public ArrayList<Mitarbeiter> getZustaendigeMitarbeiter() {
        return zustaendigeMitarbeiter;
    }

    public void setZustaendigeMitarbeiter(Mitarbeiter mitarbeiter) {
        boolean equalfound = false;
        for (Person p:zustaendigeMitarbeiter) {
            if(p instanceof Mitarbeiter){
                Mitarbeiter m = (Mitarbeiter) p;
                if(m.getBenutzername().equals(mitarbeiter.getBenutzername())){
                    equalfound = true;
                }
            }
        }
        if(equalfound){
            this.zustaendigeMitarbeiter.add(mitarbeiter);
        }
    }

    public Mitarbeiter getVerantwortlicheMitarbeiter() {
        return verantwortlicheMitarbeiter;
    }

    public void setVerantwortlicheMitarbeiter(Mitarbeiter verantwortlicheMitarbeiter) {
        this.verantwortlicheMitarbeiter = verantwortlicheMitarbeiter;
    }
}
