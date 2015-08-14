package chapter_3.ex_03_16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class InOrderAsync {

    public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread() {
            public void run() {
                T result = null;
                try {
                    result = first.get();
                } catch (Throwable t) {
                    second.accept(result, t);
                }
            }
        };
        t.start();
    }

    public static void main(String args[]) {

    }
}
