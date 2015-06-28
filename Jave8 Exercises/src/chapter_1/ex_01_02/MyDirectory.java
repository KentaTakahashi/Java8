package chapter_1.ex_01_02;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class MyDirectory {
    static public File[] treeDirectoryUseLambda(String path) {

        File root = new File(path);
        List<File> dirList = new ArrayList<File>();

        dirList = searchDirUseLambda(root, dirList);

        return dirList.toArray(new File[0]);
    }
    static private List<File> searchDirUseLambda(File current, List<File> dirs) {
        File [] files = current.listFiles(file ->
        {
            if(file.isDirectory())
                return true;
            else
                return false;
        });

        for(File f: files) {
            dirs.add(f);
            searchDirUseLambda(f, dirs);//再帰呼び出し
        }
        return dirs;
    }


    static public File[] treeDirectoryUseMethodRef(String path) {

        File root = new File(path);
        List<File> dirList = new ArrayList<File>();

        dirList = searchDirUseMethodRef(root, dirList);

        return dirList.toArray(new File[0]);
    }
    static private List<File> searchDirUseMethodRef(File current, List<File> dirs) {
        File [] files = current.listFiles(java.io.File::isDirectory);

        for(File f: files) {
            dirs.add(f);
            searchDirUseMethodRef(f, dirs);//再帰呼び出し
        }
        return dirs;
    }


    static public File[] treeDirectoryUseLegacyPattern(String path) {

        File root = new File(path);
        List<File> dirList = new ArrayList<File>();

        FileFilter filefilter = new FileFilter()
        {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory())
                    return true;
                else
                    return false;
            }
        };

        dirList = searchDir(root, dirList, filefilter);

        return dirList.toArray(new File[0]);
    }
    static private List<File> searchDir(File current, List<File> dirs, FileFilter filefilter) {
        for(File f: current.listFiles(filefilter)) {
            dirs.add(f);
            searchDir(f, dirs, filefilter);//再帰呼び出し
        }
        return dirs;
    }

}
