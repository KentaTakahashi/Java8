package chapter_2.ex_02_01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelFor {

    public static void main(String args[]) throws IOException{

        String currentDir = new File("").getAbsolutePath();
        String contents = new String(Files.readAllBytes(
                Paths.get(currentDir + "\\src\\chapter_2\\ex_02_01\\Alice in Wonderland.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}}]+"));


        //単語分割の確認
        for(String s: words)
            System.out.println(s);

        //normal For
        int count = 0;
        for (String w: words)
            if(w.length() > 12) count++;
        System.out.println("\n Count = " + count + " As normal For");

        //parallelStream
        long countL = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println("\n Count = " + countL + " As parallelStream");



        //parallel For
        AtomicInteger atomicCount = new AtomicInteger();
        List<Thread> children = new ArrayList<Thread>();
        int SegmentSize = 100;

        //スレッドリスト登録
        for (int i = 0; i < words.size(); i = i + SegmentSize) {
            int start = i;
            int end   = Math.min(i+SegmentSize , words.size());
            children.add(new Thread(()-> {
                int localCount = 0;
                for(int j = start; j < end; j++)
                    if(words.get(j).length() > 12) localCount++;
                atomicCount.addAndGet(localCount);
            }));
        }
        //スレッド実行
        for (Thread th: children) {
            th.start();
        }
        //スレッド終了待ち
        for (Thread th: children) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n Count = " + atomicCount + " As parallel For");
    }
}
