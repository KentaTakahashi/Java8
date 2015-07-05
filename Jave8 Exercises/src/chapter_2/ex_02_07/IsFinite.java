package chapter_2.ex_02_07;

import java.util.stream.Stream;

public class IsFinite {
    public static <T> boolean isFinite(Stream<T> stream) {
        Thread th = new Thread(() -> System.out.println(stream.count()));
        th.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //1秒経ってもまだカウント中であれば無限ストリームと判断
        if(th.isAlive()) {
            return false;
        } else {
            return true;
        }
    }

}
