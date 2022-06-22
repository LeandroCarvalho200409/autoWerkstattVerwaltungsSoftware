package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
    private Date date;

    public DateConverter(Date date){
        this.date = date;
    }

    public int getDay(){
        LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfMonth();
    }

    public int getMonth(){
        LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getMonthValue();
    }

    public int getYear(){
        LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getYear();
    }
}
