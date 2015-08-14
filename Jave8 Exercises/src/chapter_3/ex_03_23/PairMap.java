package chapter_3.ex_03_23;

import java.util.function.Function;


public class PairMap {
    public static <T, U> Pair<U> map(Pair<T> pair, Function<T, U> func) {
        return new Pair<U>(
                func.apply(pair.getP1()),
                func.apply(pair.getP2())
                );
    }

    public static void main(String args[]) {
        Pair<String> LR = new Pair<String>("left", "right");
        Pair<Integer> LRnum = map(LR, String::length);

        System.out.println(LR.getP1() + ": length = " + LRnum.getP1());
        System.out.println(LR.getP2() + ": length = " + LRnum.getP2());
    }
}
