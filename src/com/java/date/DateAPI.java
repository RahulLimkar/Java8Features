package com.java.date;

import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.TimeZone;

/**
 * Created by a171535 on 28-04-2017.
 */
public class DateAPI {
    public static void main(String[] s){
        // 1. LocalDate
        LocalDate d = LocalDate.now();
        System.out.println(d);
        LocalDate d2 = LocalDate.of(2017,03,28);
        System.out.println(d2.isAfter(d));
        System.out.println(d.isAfter(d2));
        LocalDate parday = LocalDate.ofYearDay(2017,365);
        System.out.println(parday);



        //2. LocalTime
        LocalTime lt = LocalTime.now();





    }
}
