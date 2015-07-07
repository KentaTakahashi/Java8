package chapter_2.ex_02_05;

import java.util.stream.Stream;

public class RandomStream {

    public static void main(String args[]){

        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        Stream<Long> randomStream = Stream.iterate(0L,
                (x) -> (a * x + c) % m);

        //test
        randomStream.limit(100).forEach(System.out::println);

    }
}
