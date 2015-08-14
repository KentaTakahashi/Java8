package chapter_3.ex_03_23;

public class Pair<T> {
    private T p1;
    private T p2;

    public Pair(T p1, T p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void setP1(T value){p1 = value;}
    public void setP2(T value){p2 = value;}
    public T getP1(){return p1;}
    public T getP2(){return p2;}
}
