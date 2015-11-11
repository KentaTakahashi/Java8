package chapter_8.ex_08_12;

import java.lang.reflect.Method;

public class Main {
    public static void main(String args[]) throws Exception {
        Method method = Factorial.class.getMethod("factorial", new Class[] {int.class});
        MyTestCases annnotation = (MyTestCases)method.getAnnotation(MyTestCases.class);

        for(MyTestCase testcase : annnotation.value())
            if(testcase.expected() != Factorial.factorial(testcase.params()))
                System.out.println("Test Failed");
    }

}
