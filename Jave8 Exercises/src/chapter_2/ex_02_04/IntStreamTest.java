package chapter_2.ex_02_04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamTest {

    public static void main(String args[]){
        int[] values = {1, 4, 9, 16};

        System.out.println("\n--------use Normal Stream--------");
        Stream<int[]> strem = Stream.of(values);
        strem.forEach((i) -> {
            System.out.println(i + ":" + i.getClass());
        });


        System.out.println("\n--------use IntStream--------");
        IntStream intstream = Arrays.stream(values);
        intstream.forEach(System.out::println);
    }
}
