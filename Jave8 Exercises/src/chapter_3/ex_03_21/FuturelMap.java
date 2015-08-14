package chapter_3.ex_03_21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class FuturelMap {

    public static <T, U> Future<U> map(Future<T> future, Function<T, U> func) {
        return new Future<U> (){

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return future.cancel(mayInterruptIfRunning);
            }

            @Override
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override
            public boolean isDone() {
                return future.isDone();
            }

            @Override
            public U get() throws InterruptedException, ExecutionException {
                return func.apply(future.get());
            }

            @Override
            public U get(long timeout, TimeUnit unit)
                    throws InterruptedException, ExecutionException, TimeoutException {
                return func.apply(future.get(timeout, unit));
            }

        };
    }

    public static void main(String args[]) {
        List<String> strList = new ArrayList<String>();
        strList.add("apple");
        strList.add("banana");
        strList.add("cherry");
    }
}
