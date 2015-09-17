package chapter_6.ex_06_09;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String args[]){
    	int index = 50;
    	Matrix[] seeds = new Matrix[index];
    	Arrays.parallelSetAll(seeds, i -> new Matrix(1L, 1L, 1L, 0L));//配列の全要素を同じ行列で初期化
    	Arrays.parallelPrefix(seeds, (a, b)-> a.multiple(b));

    	System.out.println(seeds[index - 1].e1_1);
    }
}
