package chapter_3.ex_03_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class InParallelAsync {

    public static void doInParallelAsyncAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            pool.submit(first);
            pool.submit(second);
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (Throwable t) {
            handler.accept(t);
        }
    }

    public static void main(String args[]) {

    }
}
