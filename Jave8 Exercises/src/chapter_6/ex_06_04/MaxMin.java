package chapter_6.ex_06_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class MaxMin {
    public static void main(String args[]) {

        LongAccumulator maxLong = new LongAccumulator(Math::max, Long.MIN_VALUE);
        LongAccumulator minLong = new LongAccumulator(Math::min, Long.MAX_VALUE);

        Random rand = new Random();

        List<Runnable> runners = new ArrayList<Runnable>();
        for(int i = 0; i < 100; i++) {
            runners.add(()->{
                for(int j = 0; j < 100; j++) {
                    long r = rand.nextLong();
                    maxLong.accumulate(r);
                    minLong.accumulate(r);
                }
            });
        }
        runners.stream().parallel().forEach(x -> x.run());

        System.out.println("max : " + maxLong + "\nmin : " + minLong);
    }
}
