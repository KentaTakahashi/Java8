package chapter_5.ex_05_04;


import java.time.LocalDate;

public class Calendar {

    public static void main(String args[]){
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        LocalDate firstDay = LocalDate.of(year, month, 1);

        //offset計算、月初めが月曜日であれば0、日曜日であれば6となる
        int offset = firstDay.getDayOfWeek().getValue() - 1;

        //タブをオフセット分挿入
        for(int i = 0; i < offset;i++)
            System.out.print("\t");

        int day = 1;
        int lengthOfMonth = firstDay.lengthOfMonth();

        do {
            System.out.print(day);
            if((day + offset) % 7 == 0)
                System.out.println();
            else
                System.out.print("\t");

        } while(day++ < lengthOfMonth);

    }
}

