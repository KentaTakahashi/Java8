package chapter_3.ex_03_18;

import java.util.function.Function;

public class Unchecked {

    public static <T, U> Function<T, U> unchecked(ExFunction<T, U> f) {
        return t -> {
            try {
                return f.apply(t);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String args[]) {

    }
}
