package chapter_1.ex_01_01;

import java.util.Arrays;
import java.util.Comparator;

public class ThreadCheck{
    public static void main(String args[]){

        //文字数で比較するコンパレータを生成
        Comparator<String> lengthComp = (first, second) -> {
            //スレッドチェック
            System.out.println("comparator method running : " + Thread.currentThread().getName());
            return Integer.compare(first.length(), second.length());
        };

        //スレッドチェック
        System.out.println("Main method running : " + Thread.currentThread().getName());

        String[] strings = {"a", "aaa", "aa"};
        Arrays.sort(strings, lengthComp);

        //文字数順にソートされているか確認
        for(String s: strings)
            System.out.println(s);
    }
}
