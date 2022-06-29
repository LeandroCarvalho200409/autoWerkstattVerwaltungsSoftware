package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Dies ist die Hauptklasse der ganzen Applikation. Diese Klasse verwaltet eine ganze Autogarage.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */
public class Autogarage {
    private String name;
    private ArrayList<Fahrzeug> fahrzeuge;
    private ArrayList<Person> personen;
    private ArrayList<Auftrag> auftraege;
    private ArrayList<Ersatzteil> ersatzteile;

    /**
     * Dies ist der Constructor der Klasse Autogarage.
     * @param name Der Name der Autogarage.
     */
    public Autogarage(String name){
        this.name = name;
        fahrzeuge = new ArrayList<>();
        personen = new ArrayList<>();
        auftraege = new ArrayList<>();
        ersatzteile = new ArrayList<>();
    }

    /**
     * Hiermit kann ein neues Fahrzeug in die ArrayList fahrzeuge eingefügt werden.
     * @param fahrzeug Das Fahrzeug, welches eingefügt werden soll.
     */
    public void addFahrzeug(Fahrzeug fahrzeug){
        boolean equalFound = false;
        for (Fahrzeug f:fahrzeuge) {
            if(f.getVehicleIdentificationNumber().equals(fahrzeug.getVehicleIdentificationNumber())){
                equalFound = true;
            }
        }
        if(!equalFound){
            fahrzeuge.add(fahrzeug);
        }
    }

    /**
     * Hiermit kann eine neue Person in die ArrayList personen eingefügt werden.
     * @param person Person, welche eingefügt werden soll.
     */
    public void addPerson(Person person){
        boolean equalFound = false;
        if(person instanceof Mitarbeiter){
            Mitarbeiter mitarbeiter = (Mitarbeiter) person;
            for (Person p:personen) {
                if(p instanceof Mitarbeiter){
                    Mitarbeiter vergleich = (Mitarbeiter) p;
                    if(vergleich.getBenutzername().equals(mitarbeiter.getBenutzername())){
                        equalFound = true;
                    }
                }
            }
        }else if(person instanceof Kunde){
            Kunde kunde = (Kunde) person;
            for (Person p:personen) {
                if(p instanceof Kunde){
                    Kunde vergleich = (Kunde) p;
                    if(vergleich.getKundenNummer().equals(kunde.getKundenNummer())){
                        equalFound = true;
                    }
                }
            }
        }
        if(!equalFound){
            personen.add(person);
        }
    }

    /**
     * Hiermit kann ein neuer Auftrag in die ArrayList auftraege eingesetzt werden.
     * @param auftrag Auftrag, welcher neu hinzugefügt werden soll.
     */
    public void addAuftrag(Auftrag auftrag){
        boolean equalFound = false;
        for (Auftrag a:auftraege) {
            if(a.getAuftragNr() == auftrag.getAuftragNr()){
                equalFound = true;
            }
        }
        if(!equalFound){
            auftraege.add(auftrag);
        }
    }

    /**
     * Hiermit kann ein neues Ersatzteil in die ArrayList ersatzteile eingefügt werden.
     * @param ersatzteil Ersatzteil, welches in die ArrayList eingefügt werden soll.
     */
    public void addErsatzteil(Ersatzteil ersatzteil){
        boolean equalFound = false;
        for (Ersatzteil e:ersatzteile) {
            if(ersatzteil.getProduktNr().equals(e.getProduktNr())){
                equalFound = true;
            }
        }
        if(!equalFound){
            ersatzteile.add(ersatzteil);
        }
    }

    /**
     * Mithilfe dieser Methode kann ein spezifisches Fahrzeug aus der ArrayList fahrzeuge entfernt werden.
     * @param fahrzeug
     */
    public void removeFahrzeug(Fahrzeug fahrzeug){
        fahrzeuge.remove(fahrzeug);
    }
    /**
     * Mithilfe dieser Methode kann eine spezifische Person aus der ArrayList personen entfernt werden.
     * @param person
     */
    public void removePerson(Person person){
        personen.remove(person);
    }
    /**
     * Mithilfe dieser Methode kann ein spezifischer Auftrag aus der ArrayList auftraege entfernt werden.
     * @param auftrag
     */
    public void removeAuftrag(Auftrag auftrag){
        auftraege.remove(auftrag);
    }
    /**
     * Mithilfe dieser Methode kann ein spezifisches Ersatzteil aus der ArrayList ersatzteile entfernt werden.
     * @param ersatzteil
     */
    public void removeErsatzteil(Ersatzteil ersatzteil){
        ersatzteile.remove(ersatzteil);
    }

    /**
     * Mit dieser Methode kann man anhand einer spezifischen Kundennummer ein Kunde aus der ArrayList personen holen.
     * @param kundenNummer
     * @return Kunde, welches allenfalls in der ArrayList gefunden wird.
     */
    public Kunde getPersonByKundenNummer(String kundenNummer) {
        Kunde k = null;
        for (Person p:this.personen) {
            if(p instanceof Kunde){
                Kunde kunde = (Kunde) p;
                if(kunde.getKundenNummer().equals(kundenNummer)){
                    k = kunde;
                }
            }
        }
        return k;
    }

    /**
     * Diese Methode speichert alle Daten, welche in den respektiven ArrayLists gespeichert waren in das data.txt-File ab. Dies macht es indem es mehrere JSON-Arrays
     * und Objekte, je nach Notwendigkeit, erstellt und diese in das File schreibt.
     */
    public void saveData(){
        try{
            FileWriter fileWriter = new FileWriter("data.txt");
            JSONObject autogarage = new JSONObject();
            JSONObject contentAutogarage = new JSONObject();
            JSONArray fahrzeugeJSON = new JSONArray();
            JSONArray personenArray = new JSONArray();
            JSONArray ersatzteileArray = new JSONArray();
            JSONArray auftraegeArray = new JSONArray();

            for(Person p:personen){
                JSONObject person = new JSONObject();
                if(p instanceof Kunde){
                    Kunde kunde = (Kunde) p;
                    person.put("type", "kunde");
                    person.put("name", kunde.getName());
                    person.put("vorname", kunde.getVorname());
                    JSONArray geburtsDatum = new JSONArray();
                    geburtsDatum.put(kunde.getGeburtsDatum().getYear());
                    geburtsDatum.put(kunde.getGeburtsDatum().getMonthValue());
                    geburtsDatum.put(kunde.getGeburtsDatum().getDayOfMonth());
                    person.put("geburtsDatum", geburtsDatum);
                    JSONObject adresse = new JSONObject();
                    adresse.put("strasse", kunde.getAdresse().getStrasse());
                    adresse.put("ort", kunde.getAdresse().getOrt());
                    adresse.put("nummer", kunde.getAdresse().getNummer());
                    adresse.put("plz", kunde.getAdresse().getPlz());
                    person.put("adresse", adresse);
                    person.put("email", kunde.getEmail());
                    person.put("telNummer", kunde.getTelNummer());
                    person.put("kundenNummer", kunde.getKundenNummer());
                    JSONArray kundeSeit = new JSONArray();
                    kundeSeit.put(kunde.getKundeSeit().getYear());
                    kundeSeit.put(kunde.getKundeSeit().getMonthValue());
                    kundeSeit.put(kunde.getKundeSeit().getDayOfMonth());
                    person.put("kundeSeit", kundeSeit);
                }else if(p instanceof Mitarbeiter){
                    Mitarbeiter mitarbeiter = (Mitarbeiter) p;
                    person.put("type", "mitarbeiter");
                    person.put("name", mitarbeiter.getName());
                    person.put("vorname", mitarbeiter.getVorname());
                    JSONArray geburtsDatum = new JSONArray();
                    geburtsDatum.put(mitarbeiter.getGeburtsDatum().getYear());
                    geburtsDatum.put(mitarbeiter.getGeburtsDatum().getMonthValue());
                    geburtsDatum.put(mitarbeiter.getGeburtsDatum().getDayOfMonth());
                    person.put("geburtsDatum", geburtsDatum);
                    JSONObject adresse = new JSONObject();
                    adresse.put("strasse", mitarbeiter.getAdresse().getStrasse());
                    adresse.put("ort", mitarbeiter.getAdresse().getOrt());
                    adresse.put("nummer", mitarbeiter.getAdresse().getNummer());
                    adresse.put("plz", mitarbeiter.getAdresse().getPlz());
                    person.put("adresse", adresse);
                    person.put("email", mitarbeiter.getEmail());
                    person.put("telNummer", mitarbeiter.getTelNummer());
                    person.put("benutzername", mitarbeiter.getBenutzername());
                    person.put("passwort", mitarbeiter.getPasswort());
                    JSONArray eintrittsDatum = new JSONArray();
                    eintrittsDatum.put(mitarbeiter.getEintrittsDatum().getYear());
                    eintrittsDatum.put(mitarbeiter.getEintrittsDatum().getMonthValue());
                    eintrittsDatum.put(mitarbeiter.getEintrittsDatum().getDayOfMonth());
                    person.put("eintrittsDatum", eintrittsDatum);
                    person.put("funktion", mitarbeiter.getFunktion());
                    person.put("geschaeftsfuehrer", mitarbeiter.isGeschaeftsfuehrer());
                    person.put("anzStunden", mitarbeiter.getAnzStunden());
                    person.put("ferienTage", mitarbeiter.getFerienTage());
                }
                personenArray.put(person);
            }

            for (Fahrzeug f:fahrzeuge) {
                JSONObject fahrzeug = new JSONObject();
                if(f instanceof Verkaufsfahrzeug){
                    Verkaufsfahrzeug verkaufsfahrzeug = (Verkaufsfahrzeug) f;
                    fahrzeug.put("Type", "Verkaufsfahrzeug");
                    fahrzeug.put("VIN" ,verkaufsfahrzeug.getVehicleIdentificationNumber());
                    fahrzeug.put("Marke", verkaufsfahrzeug.getMarke());
                    fahrzeug.put("Modell", verkaufsfahrzeug.getModell());
                    fahrzeug.put("Baureihe", verkaufsfahrzeug.getBaureihe());
                    fahrzeug.put("CCM", verkaufsfahrzeug.getCcm());
                    fahrzeug.put("PS", verkaufsfahrzeug.getPs());
                    fahrzeug.put("anzPlaetze", verkaufsfahrzeug.getAnzPlaetze());
                    fahrzeug.put("Aufbau", verkaufsfahrzeug.getAufbau());
                    fahrzeug.put("Farbe", verkaufsfahrzeug.getFarbe());
                    fahrzeug.put("Farbencode", verkaufsfahrzeug.getFarbencode());
                    JSONArray ersteIVS = new JSONArray();
                    ersteIVS.put(verkaufsfahrzeug.getErsteInverkehrssetzung().getYear());
                    ersteIVS.put(verkaufsfahrzeug.getErsteInverkehrssetzung().getMonthValue());
                    ersteIVS.put(verkaufsfahrzeug.getErsteInverkehrssetzung().getDayOfMonth());
                    fahrzeug.put("ErsteInverkehrssetzung", ersteIVS);
                    fahrzeug.put("Preis", verkaufsfahrzeug.getPreis());
                    fahrzeug.put("Verkauft", verkaufsfahrzeug.isVerkauft());

                    JSONObject besitzer = new JSONObject();
                    besitzer.put("name", verkaufsfahrzeug.getVerkauftAn().getName());
                    besitzer.put("vorname", verkaufsfahrzeug.getVerkauftAn().getVorname());
                    JSONArray geburtsDatum = new JSONArray();
                    geburtsDatum.put(verkaufsfahrzeug.getVerkauftAn().getGeburtsDatum().getYear());
                    geburtsDatum.put(verkaufsfahrzeug.getVerkauftAn().getGeburtsDatum().getMonthValue());
                    geburtsDatum.put(verkaufsfahrzeug.getVerkauftAn().getGeburtsDatum().getDayOfMonth());
                    besitzer.put("geburtsDatum", geburtsDatum);

                    JSONObject adresse = new JSONObject();
                    adresse.put("strasse", verkaufsfahrzeug.getVerkauftAn().getAdresse().getStrasse());
                    adresse.put("nummer", verkaufsfahrzeug.getVerkauftAn().getAdresse().getNummer());
                    adresse.put("ort", verkaufsfahrzeug.getVerkauftAn().getAdresse().getOrt());
                    adresse.put("plz", verkaufsfahrzeug.getVerkauftAn().getAdresse().getPlz());

                    besitzer.put("adresse", adresse);
                    besitzer.put("email", verkaufsfahrzeug.getVerkauftAn().getEmail());
                    besitzer.put("telNummer", verkaufsfahrzeug.getVerkauftAn().getTelNummer());
                    besitzer.put("kundenNummer", verkaufsfahrzeug.getVerkauftAn().getKundenNummer());
                    JSONArray kundeSeit = new JSONArray();
                    kundeSeit.put(verkaufsfahrzeug.getVerkauftAn().getKundeSeit().getYear());
                    kundeSeit.put(verkaufsfahrzeug.getVerkauftAn().getKundeSeit().getMonthValue());
                    kundeSeit.put(verkaufsfahrzeug.getVerkauftAn().getKundeSeit().getDayOfMonth());
                    besitzer.put("kundeSeit", kundeSeit);

                    fahrzeug.put("VerkauftAn", besitzer);
                    JSONArray gekauftDate = new JSONArray();
                    gekauftDate.put(verkaufsfahrzeug.getGekauftDate().getYear());
                    gekauftDate.put(verkaufsfahrzeug.getGekauftDate().getMonthValue());
                    gekauftDate.put(verkaufsfahrzeug.getGekauftDate().getDayOfMonth());
                    fahrzeug.put("gekauftDate", gekauftDate);
                }else if( f instanceof  Kundenfahrzeug){
                    Kundenfahrzeug kundenfahrzeug = (Kundenfahrzeug) f;
                    fahrzeug.put("Type", "Kundenfahrzeug");
                    fahrzeug.put("VIN" ,kundenfahrzeug.getVehicleIdentificationNumber());
                    fahrzeug.put("Marke", kundenfahrzeug.getMarke());
                    fahrzeug.put("Modell", kundenfahrzeug.getModell());
                    fahrzeug.put("Baureihe", kundenfahrzeug.getBaureihe());
                    fahrzeug.put("CCM", kundenfahrzeug.getCcm());
                    fahrzeug.put("PS", kundenfahrzeug.getPs());
                    fahrzeug.put("anzPlaetze", kundenfahrzeug.getAnzPlaetze());
                    fahrzeug.put("Aufbau", kundenfahrzeug.getAufbau());
                    fahrzeug.put("Farbe", kundenfahrzeug.getFarbe());
                    fahrzeug.put("Farbencode", kundenfahrzeug.getFarbencode());
                    JSONArray ersteIVS = new JSONArray();
                    ersteIVS.put(kundenfahrzeug.getErsteInverkehrssetzung().getYear());
                    ersteIVS.put(kundenfahrzeug.getErsteInverkehrssetzung().getMonthValue());
                    ersteIVS.put(kundenfahrzeug.getErsteInverkehrssetzung().getDayOfMonth());
                    fahrzeug.put("ErsteInverkehrssetzung", ersteIVS);

                    JSONObject besitzer = new JSONObject();
                    besitzer.put("name", kundenfahrzeug.getBesitzer().getName());
                    besitzer.put("vorname", kundenfahrzeug.getBesitzer().getVorname());
                    JSONArray geburtsDatum = new JSONArray();
                    geburtsDatum.put(kundenfahrzeug.getBesitzer().getGeburtsDatum().getYear());
                    geburtsDatum.put(kundenfahrzeug.getBesitzer().getGeburtsDatum().getMonthValue());
                    geburtsDatum.put(kundenfahrzeug.getBesitzer().getGeburtsDatum().getDayOfMonth());
                    besitzer.put("geburtsDatum", geburtsDatum);

                    JSONObject adresse = new JSONObject();
                    adresse.put("strasse", kundenfahrzeug.getBesitzer().getAdresse().getStrasse());
                    adresse.put("nummer", kundenfahrzeug.getBesitzer().getAdresse().getNummer());
                    adresse.put("ort", kundenfahrzeug.getBesitzer().getAdresse().getOrt());
                    adresse.put("plz", kundenfahrzeug.getBesitzer().getAdresse().getPlz());

                    besitzer.put("adresse", adresse);
                    besitzer.put("email", kundenfahrzeug.getBesitzer().getEmail());
                    besitzer.put("telNummer", kundenfahrzeug.getBesitzer().getTelNummer());
                    besitzer.put("kundenNummer", kundenfahrzeug.getBesitzer().getKundenNummer());
                    JSONArray kundeSeit = new JSONArray();
                    kundeSeit.put(kundenfahrzeug.getBesitzer().getKundeSeit().getYear());
                    kundeSeit.put(kundenfahrzeug.getBesitzer().getKundeSeit().getMonthValue());
                    kundeSeit.put(kundenfahrzeug.getBesitzer().getKundeSeit().getDayOfMonth());
                    besitzer.put("kundeSeit", kundeSeit);

                    fahrzeug.put("besitzer", besitzer);
                }
                fahrzeugeJSON.put(fahrzeug);
            }
            for (Ersatzteil e:ersatzteile) {
                JSONObject ersatzteil = new JSONObject();
                ersatzteil.put("name", e.getName());
                ersatzteil.put("produktNr", e.getProduktNr());
                ersatzteil.put("anwendung", e.getAnwendung());
                ersatzteil.put("marke", e.getMarke());
                JSONArray modelle = new JSONArray();
                if(e.getGeeignetFuerModelle() != null){
                    for (String  modell:e.getGeeignetFuerModelle()) {
                        modelle.put(modell);
                    }
                }
                ersatzteil.put("geeignetFuerModelle", modelle);
                ersatzteil.put("anzAufLager", e.getAnzAufLager());
                ersatzteil.put("preisProStueck", e.getPreisProStueck());
                ersatzteileArray.put(ersatzteil);
            }

            for (Auftrag a:auftraege) {
                JSONObject auftrag = new JSONObject();
                auftrag.put("auftragsNr", a.getAuftragNr());
                auftrag.put("fahrzeug", a.getFahrzeug().getVehicleIdentificationNumber());
                JSONArray ersatzteileJSON = new JSONArray();
                for (Ersatzteil e:a.getErsatzteile()) {
                    ersatzteileJSON.put(e.getProduktNr());
                }
                auftrag.put("ersatzteile", ersatzteileJSON);
                auftrag.put("art", a.getArt());
                auftrag.put("preis", a.getPreis());
                JSONArray gebiete = new JSONArray();
                for (String s:a.getGebieteDesFahrzeuges()) {
                    gebiete.put(s);
                }
                auftrag.put("gebieteDesFahrzeuges", gebiete);
                auftrag.put("status", a.getStatus());
                JSONArray zuErledigenBis = new JSONArray();
                zuErledigenBis.put(a.getZuErledigenBis().getYear());
                zuErledigenBis.put(a.getZuErledigenBis().getMonthValue());
                zuErledigenBis.put(a.getZuErledigenBis().getDayOfMonth());
                auftrag.put("zuErledigenBis", zuErledigenBis);
                JSONArray mitarbeiterJSON = new JSONArray();
                for (Mitarbeiter m:a.getZustaendigeMitarbeiter()) {
                    mitarbeiterJSON.put(m.getBenutzername());
                }
                auftrag.put("zustaendigeMitarbeiter", mitarbeiterJSON);
                auftrag.put("verantwortlicheMitarbeiter", a.getVerantwortlicheMitarbeiter().getBenutzername());

                auftraegeArray.put(auftrag);
            }
            contentAutogarage.put("personen", personenArray);
            contentAutogarage.put("fahrzeuge", fahrzeugeJSON);
            contentAutogarage.put("ersatzteile", ersatzteileArray);
            contentAutogarage.put("auftraege", auftraegeArray);
            autogarage.put(this.name, contentAutogarage);
            fileWriter.write(autogarage.toString());
            fileWriter.flush();
            fileWriter.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Wird beim Start der Applikation aufgerufen um die Daten vom data.txt file abzuholen und lokal zu speichern. Dies macht die Methode indem es den String wieder in
     * JSON-Arrays oder Objekte um konvertiert und die respektiven Objekte erstellt und speichert.
     */
    public void getData(){
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            JSONObject data = new JSONObject(line);
            System.out.println(data);
            JSONObject contentJSON = (JSONObject) data.get(this.name);
            JSONArray fahrzeugeJSON = contentJSON.getJSONArray("fahrzeuge");
            JSONArray personenJSON = contentJSON.getJSONArray("personen");
            JSONArray ersatzteileJSON = contentJSON.getJSONArray("ersatzteile");
            JSONArray auftraegeJSON = contentJSON.getJSONArray("auftraege");
            for (int i=0; i< personenJSON.length(); i++){
                JSONObject person = personenJSON.getJSONObject(i);
                if(person.get("type").equals("kunde")){
                    JSONObject adresse = person.getJSONObject("adresse");
                    JSONArray geburtsDatum = person.getJSONArray("geburtsDatum");
                    JSONArray kundeSeit = person.getJSONArray("kundeSeit");
                    Adresse adresse1 = new Adresse(adresse.getString("strasse"), adresse.getInt("nummer"), adresse.getString("ort"), adresse.getInt("plz"));
                    Kunde kunde = new Kunde(person.getString("name"), person.getString("vorname"), LocalDate.of(geburtsDatum.getInt(0), geburtsDatum.getInt(1), geburtsDatum.getInt(2)), adresse1, person.getString("email"), person.getString("telNummer"), person.getString("kundenNummer"), LocalDate.of(kundeSeit.getInt(0), kundeSeit.getInt(1), kundeSeit.getInt(2)));
                    addPerson(kunde);
                }else if(person.get("type").equals("mitarbeiter")){
                    JSONObject adresse = person.getJSONObject("adresse");
                    JSONArray geburtsDatum = person.getJSONArray("geburtsDatum");
                    JSONArray eintrittsDatum = person.getJSONArray("eintrittsDatum");
                    Adresse adresse1 = new Adresse(adresse.getString("strasse"), adresse.getInt("nummer"), adresse.getString("ort"), adresse.getInt("plz"));
                    Mitarbeiter mitarbeiter = new Mitarbeiter(person.getString("name"), person.getString("vorname"), LocalDate.of(geburtsDatum.getInt(0), geburtsDatum.getInt(1), geburtsDatum.getInt(2)), adresse1, person.getString("email"), person.getString("telNummer"), person.getString("benutzername"), person.getString("passwort"), LocalDate.of(eintrittsDatum.getInt(0), eintrittsDatum.getInt(1), eintrittsDatum.getInt(2)), person.getString("funktion"), person.getBoolean("geschaeftsfuehrer"), person.getInt("anzStunden"), person.getInt("ferienTage"));
                    addPerson(mitarbeiter);
                }
            }
            for (int i=0; i<fahrzeugeJSON.length(); i++) {
                JSONObject fahrzeug = fahrzeugeJSON.getJSONObject(i);
                if(fahrzeug.get("Type").equals("Verkaufsfahrzeug")){
                    JSONArray ersteInverkehrssetzung = fahrzeug.getJSONArray("ErsteInverkehrssetzung");
                    JSONObject besitzer = fahrzeug.getJSONObject("VerkauftAn");
                    JSONArray gekauftDate = fahrzeug.getJSONArray("gekauftDate");
                    Verkaufsfahrzeug verkaufsfahrzeug = new Verkaufsfahrzeug(fahrzeug.getString("Marke"), fahrzeug.getString("Modell"), fahrzeug.getString("Baureihe"), fahrzeug.getInt("CCM"), fahrzeug.getInt("PS"), fahrzeug.getInt("anzPlaetze"), fahrzeug.getString("Aufbau"), fahrzeug.getString("Farbe"), fahrzeug.getString("Farbencode"), fahrzeug.getString("VIN"), LocalDate.of(ersteInverkehrssetzung.getInt(0), ersteInverkehrssetzung.getInt(1), ersteInverkehrssetzung.getInt(2)), fahrzeug.getInt("Preis"), fahrzeug.getBoolean("Verkauft"), getPersonByKundenNummer(besitzer.getString("kundenNummer")), LocalDate.of(gekauftDate.getInt(0), gekauftDate.getInt(1), gekauftDate.getInt(2)));
                    addFahrzeug(verkaufsfahrzeug);

                }else if(fahrzeug.get("Type").equals("Kundenfahrzeug")){
                    JSONArray ersteInverkehrssetzung = fahrzeug.getJSONArray("ErsteInverkehrssetzung");
                    JSONObject besitzer = fahrzeug.getJSONObject("besitzer");
                    Kundenfahrzeug kundenfahrzeug = new Kundenfahrzeug(fahrzeug.getString("Marke"), fahrzeug.getString("Modell"), fahrzeug.getString("Baureihe"), fahrzeug.getInt("CCM"), fahrzeug.getInt("PS"), fahrzeug.getInt("anzPlaetze"), fahrzeug.getString("Aufbau"), fahrzeug.getString("Farbe"), fahrzeug.getString("Farbencode"), fahrzeug.getString("VIN"), LocalDate.of(ersteInverkehrssetzung.getInt(0), ersteInverkehrssetzung.getInt(1), ersteInverkehrssetzung.getInt(2)), getPersonByKundenNummer(besitzer.getString("kundenNummer")));
                    addFahrzeug(kundenfahrzeug);
                }
            }
            for(int i=0; i<ersatzteileJSON.length(); i++){
                JSONObject ersatzteilJSON = ersatzteileJSON.getJSONObject(i);
                JSONArray geeignetFuerModelle = ersatzteilJSON.getJSONArray("geeignetFuerModelle");
                Ersatzteil ersatzteil = new Ersatzteil(ersatzteilJSON.getString("name"), ersatzteilJSON.getString("produktNr"), ersatzteilJSON.getString("anwendung"), ersatzteilJSON.getString("marke"), ersatzteilJSON.getInt("anzAufLager"), ersatzteilJSON.getDouble("preisProStueck"));
                for (Object s:geeignetFuerModelle) {
                    String string = (String) s;
                    ersatzteil.addModell(string);
                }
                addErsatzteil(ersatzteil);
            }
            for(int i=0; i<auftraegeJSON.length(); i++){
                JSONObject auftragJSON = auftraegeJSON.getJSONObject(i);
                JSONArray ersatzteileJSONArray = auftragJSON.getJSONArray("ersatzteile");
                JSONArray gebieteDesFahrzeugesJSONArray = auftragJSON.getJSONArray("gebieteDesFahrzeuges");
                JSONArray zuErledigenBisJSONArray = auftragJSON.getJSONArray("zuErledigenBis");
                JSONArray zustaendigeMitarbeiter = auftragJSON.getJSONArray("zustaendigeMitarbeiter");
                String verantwortlicheMitarbeiterBN = auftragJSON.getString("verantwortlicheMitarbeiter");
                Mitarbeiter zustaendigMitarbeiter = null;
                Fahrzeug fahrzeugAuftrag = null;

                for (Person p:personen) {
                    if(p instanceof Mitarbeiter){
                        Mitarbeiter mitarbeiter = (Mitarbeiter) p;
                        if(mitarbeiter.getBenutzername().equals(verantwortlicheMitarbeiterBN)){
                            zustaendigMitarbeiter = mitarbeiter;
                        }
                    }
                }

                for (Fahrzeug fahrzeug:fahrzeuge) {
                    if(fahrzeug.getVehicleIdentificationNumber().equals(auftragJSON.getString("fahrzeug"))){
                        fahrzeugAuftrag = fahrzeug;
                    }
                }

                Auftrag auftrag = new Auftrag(this ,fahrzeugAuftrag, auftragJSON.getString("art"), auftragJSON.getInt("preis"), auftragJSON.getString("status"), LocalDate.of(zuErledigenBisJSONArray.getInt(0), zuErledigenBisJSONArray.getInt(1), zuErledigenBisJSONArray.getInt(2)), zustaendigMitarbeiter);

                for (Object s:zustaendigeMitarbeiter) {
                    String string = (String) s;
                    for (Person p:personen) {
                        if(p instanceof Mitarbeiter){
                            Mitarbeiter m = (Mitarbeiter) p;
                            if(((Mitarbeiter) p).getBenutzername().equals(string)){
                                auftrag.setZustaendigeMitarbeiter(m);
                            }
                        }
                    }
                }
                for (Object s:gebieteDesFahrzeugesJSONArray) {
                    String gebiet = (String) s;
                    auftrag.setGebietDesFahrzeuges(gebiet);
                }
                for (Object s:ersatzteileJSONArray) {
                    String produktNr = (String) s;
                    for (Ersatzteil ersatzteil:ersatzteile) {
                        if(ersatzteil.getProduktNr().equals(produktNr)){
                            auftrag.setErsatzteil(ersatzteil);
                        }
                    }
                }
                addAuftrag(auftrag);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Gibt die ArrayList aller Personen zurück.
     * @return ArrayList aller Personen.
     */
    public ArrayList<Person> getPersonen() {
        return personen;
    }

    /**
     * Setzt die ArrayList aller Personen gleich der ArrayList, welche als Parameter mitgegeben wird.
     * @param personen
     */
    public void setPersonen(ArrayList<Person> personen) {
        this.personen = personen;
    }

    /**
     * Diese Methode ist teil der Anmeldungsfunktion dieser Applikation. Hier bekommt die Methode den Benutzername und das Passwort, welches eingegeben wurde mit und
     * schaut, ob diese irgendwo auch existieren. Falls es gefunden wurde, gibt es den Wert true zurück, sonst gibt es den Wert false zurück.
     * @param username
     * @param password
     * @return Boolean, welches besagt, ob die Anmeldungsdaten irgendwo gefunden wurden oder nicht.
     */
    public boolean anmelden(String username, String password){
        boolean anmeldungEfrolgreich = false;
        for (Person p: personen) {
            if(p instanceof Mitarbeiter){
                Mitarbeiter mitarbeiter = (Mitarbeiter) p;
                if(username.equals(mitarbeiter.getBenutzername())){
                    anmeldungEfrolgreich = mitarbeiter.anmelden(password);
                }
            }
        }
        return anmeldungEfrolgreich;
    }

    /**
     * Gibt eine ArrayList aller Fahrzeuge zurück.
     * @return ArrayList aller Fahrzeuge.
     */
    public ArrayList<Fahrzeug> getFahrzeuge(){
        return this.fahrzeuge;
    }

    /**
     * Gibt eine ArrayList aller Aufträge zurück.
     * @return ArrayLsit aller Aufträge.
     */
    public ArrayList<Auftrag> getAuftraege(){
        return this.auftraege;
    }

    /**
     * Gibt eine ArrayList aller Ersatzteile zurück.
     * @return ArrayList aller Ersatzteile.
     */
    public ArrayList<Ersatzteil> getErsatzteile(){
        return this.ersatzteile;
    }
}
