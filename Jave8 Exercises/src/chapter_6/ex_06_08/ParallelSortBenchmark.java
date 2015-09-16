package chapter_6.ex_06_08;

import java.util.Arrays;
import java.util.Random;

public class ParallelSortBenchmark {

    public static void main(String args[]){

    	for(int pow = 10; pow < 20; pow++) {
    		//配列の数
    		int arrayNum = (int) Math.pow(2, pow);
        	System.out.println("配列の数 :\t " + arrayNum);

    		//配列宣言、乱数にて初期化
    		double[] demo = new double[arrayNum];
        	Random rnd = new Random();
        	for(int i = 0; i < demo.length; i++)
        		demo[i] = rnd.nextDouble();

        	double[] demo2 = demo.clone();

        	long startTime, endTime;

        	//standerd sort
            startTime = System.nanoTime();
        	Arrays.sort(demo);
        	endTime = System.nanoTime();
        	System.out.println("    standerd sort time : \t " + (endTime - startTime) / 1000 + "\t (nanoseconds)");

        	//parallel sort
            startTime = System.nanoTime();
        	Arrays.parallelSort(demo2);
        	endTime = System.nanoTime();
        	System.out.println("    parallel sort time : \t " + (endTime - startTime) / 1000 + "\t (nanoseconds)");
    	}

    	System.out.println("done");
    }
}
