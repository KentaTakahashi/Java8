package chapter_5.ex_05_03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class SatisfyDay {

    public static TemporalAdjuster next(Predicate<LocalDate> f) {
        return w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            } while(f.test(result));
            return result.plusDays(1);//翌日の日付を返す
        };
    }

    public static void main(String args[]){
        LocalDate today = LocalDate.now();
        System.out.println(today.with(next(w -> w.getDayOfWeek().getValue() < 6)));
    }
}