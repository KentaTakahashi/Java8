package chapter_1.ex_01_11;

public interface J {
    //abstract void f();
    default void f(){System.out.println("called J.f");};
    //static void f(){System.out.println("called J.f");};
}
