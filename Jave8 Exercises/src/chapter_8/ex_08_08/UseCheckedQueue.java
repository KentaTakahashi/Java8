package chapter_8.ex_08_08;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class UseCheckedQueue{

    public static void main(String args[]) {
        Queue q = Collections.checkedQueue(new LinkedList<String>(), String.class);
        q.add("string");
        q.add(1);
    }
}
