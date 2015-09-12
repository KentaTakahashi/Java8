package chapter_5.ex_05_05;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LifetimeCounter {

    public static void main(String args[]){
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);

        LocalDate birthday = LocalDate.of(year, month, day);
        long lifetime = birthday.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println(lifetime);
    }
}

