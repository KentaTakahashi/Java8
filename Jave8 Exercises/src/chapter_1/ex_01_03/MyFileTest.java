package chapter_1.ex_01_03;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MyFileTest {

    @Test
    public void test() {
        String path = System.getProperty("user.dir");
        path = path + "\\src\\chapter_1\\ex_01_03";

        String[] files = MyFile.selectFile(path, "java");

        String[] expectation = {"MyFile.java", "MyFileTest.java"};

        assertTrue("結果が異なります", Arrays.equals(files, expectation));

        //指定した拡張子のファイルを表示
        for(String f: files)
            System.out.println(f);
    }

}
