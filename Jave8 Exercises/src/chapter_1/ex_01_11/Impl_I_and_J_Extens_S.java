package chapter_1.ex_01_11;

public class Impl_I_and_J_Extens_S extends S implements I, J {

    public static void main(String args[]){
        Impl_I_and_J_Extens_S ij = new Impl_I_and_J_Extens_S();
        ij.f();
    }

    @Override
    public void f() {
        System.out.println("called Impl_I_and_J.f");
    }

}
