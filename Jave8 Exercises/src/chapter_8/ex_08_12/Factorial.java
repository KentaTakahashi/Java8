package chapter_8.ex_08_12;

public class Factorial{

    @MyTestCase(params=4, expected=24)
    @MyTestCase(params=1, expected=1)
    @MyTestCase(params=-1, expected=1)
    public static long factorial(int n) {
        long ret = 1;
        while(0 < n)
            ret *= n--;
        return ret;
    }
}
