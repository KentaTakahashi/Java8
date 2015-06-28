package chapter_1.ex_01_02;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

public class MyDirectoryTest {

    @Test
    public void test() {
        String path = System.getProperty("user.dir");

        File[] files_1 = MyDirectory.treeDirectoryUseLambda(path);
        File[] files_2 = MyDirectory.treeDirectoryUseMethodRef(path);

        assertTrue("結果が異なります", Arrays.equals(files_1, files_2));

        //サブディレクトリを表示
        for(File f: files_1)
            System.out.println(f.getAbsolutePath());
    }

}
