package chapter_6.ex_06_09;

public class Matrix {
	public long e1_1;
	public long e1_2;
	public long e2_1;
	public long e2_2;

	public Matrix(long e1_1, long e1_2, long e2_1, long e2_2) {
		this.e1_1 = e1_1;
		this.e1_2 = e1_2;
		this.e2_1 = e2_1;
		this.e2_2 = e2_2;
	}

	public Matrix multiple(Matrix other) {
		long tmp_e1_1 = e1_1 * other.e1_1 + e1_2 * other.e2_1;
		long tmp_e1_2 = e1_1 * other.e1_2 + e1_2 * other.e2_2;
		long tmp_e2_1 = e2_1 * other.e1_1 + e2_2 * other.e2_1;
		long tmp_e2_2 = e2_1 * other.e1_2 + e2_2 * other.e2_2;

    	System.out.println(tmp_e1_1);
		return new Matrix(tmp_e1_1, tmp_e1_2, tmp_e2_1, tmp_e2_2) ;
	}

}
