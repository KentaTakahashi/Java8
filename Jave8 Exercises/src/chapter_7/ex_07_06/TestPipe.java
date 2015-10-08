package chapter_7.ex_07_06;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestPipe {

    public static void main(String[] args) throws Throwable {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engin = manager.getEngineByName("nashorn");
        File jsFile = new File(".\\src\\chapter_7\\ex_07_06\\Pipe.js");
        Reader reader = Files.newBufferedReader(jsFile.toPath());
        Object result = engin.eval(reader);
        //System.out.println(result); //戻り値の表示
    }

}
