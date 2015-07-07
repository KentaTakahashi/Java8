package chapter_1.ex_01_07;


public class AndThen {
    public static void main(String args[]){
        andThen(
                () -> System.out.println("first runner called!"),
                () -> System.out.println("second runner called!")
                ).run();
    }

    public static Runnable andThen(Runnable runner_1, Runnable runner_2) {
        return () -> {runner_1.run(); runner_2.run();};
    }
}
