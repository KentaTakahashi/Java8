package chapter_5.ex_05_06;


import java.time.DayOfWeek;
import java.time.LocalDate;

public class FryDay13in20century {

    public static void main(String args[]){
        for(int year = 1901; year <= 2000; year++) {
            for(int month = 1; month <= 12; month++) {
                LocalDate thirteen = LocalDate.of(year, month, 13);
                if(thirteen.getDayOfWeek() == DayOfWeek.FRIDAY)
                    System.out.println(thirteen);
            }
        }
    }
}

