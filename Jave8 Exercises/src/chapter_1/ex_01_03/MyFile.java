package chapter_1.ex_01_03;

import java.io.File;

public class MyFile {
    static public String[] selectFile(String path, String extension ) {

        File root = new File(path);

        String [] files = root.list((dir, name) ->
        {
            if(extension.equals(getExtension(name)))
                return true;
            else
                return false;
        });

        return files;
    }
    static private String getExtension(String fileName) {
        if (fileName == null) {
            return null;
        }

        // 最後の『 . 』の位置を取得します。
        int lastDotPosition = fileName.lastIndexOf(".");

        // 『 . 』が存在する場合は、『 . 』以降を返します。
        if (lastDotPosition != -1) {
            return fileName.substring(lastDotPosition + 1);
        }
        return null;
    }

}
