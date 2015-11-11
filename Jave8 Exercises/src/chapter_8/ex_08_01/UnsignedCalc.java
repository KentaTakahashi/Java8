package chapter_8.ex_08_01;

public class UnsignedCalc {
    public static int addition(int a, int b) {
        return a + b;
    }
    public static int subtraction(int a, int b) {
        return a - b;
    }
    public static int division(int a, int b) {
        return Integer.remainderUnsigned(a, b);
    }

    public static int compare(int a, int b) {
        return Integer.compareUnsigned(a, b);
    }
}
