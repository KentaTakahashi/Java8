package chapter_2.ex_02_09;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class MargeArrayList {

    //use reduce "1" pram
    //Optional<T> reduce(BinaryOperator<T> accumulator)
    public static <T> ArrayList<T> margeArrayList1(Stream<ArrayList<T>> stream) {
        Optional<ArrayList<T>>  res = stream.reduce((x, y) -> {
            x.addAll(y);
            return x;
        });
        return res.get();
    }

    //use reduce "2" prams
    //T reduce(T identity, BinaryOperator<T> accumulator)
    public static <T> ArrayList<T> margeArrayList2(Stream<ArrayList<T>> stream) {
        ArrayList<T>  res = stream.reduce(new ArrayList<>(), (x, y) -> {
            x.addAll(y);
            return x;
        });
        return res;
    }

    //use reduce "3" prams
    //<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
    public static <T> ArrayList<T> margeArrayList3(Stream<ArrayList<T>> stream) {
        ArrayList<T>  res = stream.reduce(
                new ArrayList<>(),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                },
                (total1, total2) -> {
                    total1.addAll(total2);
                    return total1;
                });
        return res;
    }
}
