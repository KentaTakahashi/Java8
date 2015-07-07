package chapter_1.ex_01_06;


public class Main{
	public static void main(String args[]){
		new Thread(uncheck(() -> {
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();

    }

	public static Runnable uncheck(RunnableEX runner) {
		return new Thread(() -> {
			try {
				runner.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
