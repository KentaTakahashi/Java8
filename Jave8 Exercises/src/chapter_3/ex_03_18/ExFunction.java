package chapter_3.ex_03_18;

@FunctionalInterface
public interface ExFunction<T, U> {
    U apply(T t) throws Exception;
}
