package chapter_1.ex_01_08;

import java.util.ArrayList;
import java.util.List;


public class CaptureTest {
    public static void main(String args[]){
        String[] names = {"Peter", ""
                + "", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for(String name: names)
            runners.add(() -> System.out.println(name));

        runners.get(0).run();
        runners.get(1).run();
        runners.get(2).run();


        runners.clear();

        for(int i = 0; i < names.length; i++)
            ;//下記はエラーが出るためコンパイル不可 "Local variable i defined in an enclosing scope must be final or effectively final"
             //runners.add(() -> System.out.println(names[i]));

        for(int i = 0; i < names.length; i++) {
            int j = i;//for文内の(実質ファイナルの)ローカル変数に置き換えればOK
            runners.add(() -> System.out.println(names[j]));
        }

        runners.get(0).run();
        runners.get(1).run();
        runners.get(2).run();
    }
}