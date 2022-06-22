module ch.bbw.leandro.carvalho.autowerkstattverwaltung.autowerkstattverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;
}