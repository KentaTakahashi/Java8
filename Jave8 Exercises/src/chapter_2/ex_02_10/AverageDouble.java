package chapter_2.ex_02_10;

import java.util.stream.Stream;

public class AverageDouble {
    public static double averageDouble(Stream<Double> stream) {
        //第1要素を合計値、第2要素をカウント数として収集
        //reduceは終端操作のため、平行して収集しないとストリームが閉じてしまう
        double[] ret = stream.reduce(
                new double[2],
                (double[] tmp,  Double add) -> {
                    tmp[0] += add;
                    tmp[1] += 1;//count up
                    return tmp;
                },
                (double[] total1, double[] total2) -> {
                    total1[0] += total2[0];
                    total1[1] += total2[1];
                    return total1;
                }
                );

        return ret[0] / ret[1];
    }
}
