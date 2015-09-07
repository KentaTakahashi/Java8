package chapter_5.ex_05_02;

import java.io.IOException;
import java.time.LocalDate;

public class AddYear {

    public static void main(String args[]) throws IOException{
        LocalDate programmersDay;

        programmersDay = LocalDate.of(2000, 2, 29).plusYears(1);
        System.out.println(programmersDay);

        programmersDay = LocalDate.of(2000, 2, 29).plusYears(4);
        System.out.println(programmersDay);

        programmersDay = LocalDate.of(2000, 2, 29).plusYears(1).plusYears(1).plusYears(1).plusYears(1);
        System.out.println(programmersDay);

        /*
         * 実行結果
         * 2001-02-28
         * 2004-02-29
         * 2004-02-28
         */
    }
}
