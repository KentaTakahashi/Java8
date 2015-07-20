package chapter_3.ex_03_02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DelayLoging {

    public static void withLock(Lock myLock, Runnable runner) {
        myLock.lock();
        try {
            runner.run();
        } finally {
            myLock.unlock();
        }
    }

    public static void main(String args[]) {
        Lock myLock = new ReentrantLock();
        withLock(myLock, () -> System.out.println("called withLock"));

    }
}
