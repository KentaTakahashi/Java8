package chapter_8.ex_08_14;

import java.util.Objects;

public class RequireNonNull {
    Object object;

    public RequireNonNull(Object object) {
        try {
            this.object = Objects.requireNonNull(object);
        }catch(NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }
    public static void main(String args[]){
        new RequireNonNull("test");
        new RequireNonNull(null); //throws NullPointerException
    }

}
