package chapter_1.ex_01_04;

import java.io.File;
import java.util.Arrays;

public class FileSort {
	public static void main(String args[]){

		//ユーザディレクトリ下のFileを配列として格納
        String path = System.getProperty("user.dir");
        File root = new File(path);
        File[] files = root.listFiles();

        //ラムダ式でソート
        Arrays.sort(files, (file_1, file_2)-> {
        	if(file_1.isDirectory() && file_2.isFile())
        		return -1;
        	else if(file_1.isFile() && file_2.isDirectory())
        		return 1;
        	else
        		return file_1.getPath().compareTo(file_2.getPath());
        });

        //出力確認
        for(File f: files)
            System.out.println(f.getName());
    }
}
