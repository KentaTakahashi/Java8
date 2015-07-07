package chapter_1.ex_01_12;

import java.util.stream.Stream;

public interface AtherStream<E> {
    default Stream<E> stream(){return null;};
}
