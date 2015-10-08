package chapter_7.ex_07_07;

public class TestPipe {

    public static void main(String[] args) throws Throwable {
    	ProcessBuilder pb = new ProcessBuilder("ls");
    	pb.start();
    	// 'find .' 'grep -v class' 'sort'
    }

}
