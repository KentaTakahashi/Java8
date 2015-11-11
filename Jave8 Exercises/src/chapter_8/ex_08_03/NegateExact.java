package chapter_8.ex_08_03;

public class NegateExact {

    public static void main(String[] args) throws Throwable {
        System.out.println(gcd1(-160,-128));
        System.out.println(gcd2(-160,-128));
        System.out.println(gcd3(-160,-128));
    }

    public static int gcd1(int a, int b) {
        if(a < 0) a = -a;
        if(b < 0) b = -b;

        int m, n;
        if(a < b)   {m = b; n = a;}
        else        {m = a; n = b;}

        while(n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        return m;
    }

    public static int gcd2(int a, int b) {
        if(a < 0) a = -a;
        if(b < 0) b = -b;

        int m, n;
        if(a < b)   {m = b; n = a;}
        else        {m = a; n = b;}

        while(n != 0) {
            int tmp = Math.floorMod(m, n);
            m = n;
            n = tmp;
        }
        return m;
    }

    public static int gcd3(int a, int b) {
        if(a < 0) a = -a;
        if(b < 0) b = -b;

        int m, n;
        if(a < b)   {m = b; n = a;}
        else        {m = a; n = b;}

        while(n != 0) {
            int tmp = rem(m, n);
            m = n;
            n = tmp;
        }
        return m;
    }

    private static int rem(int m, int n) {
        int r =  m % n;
        if(0 < r)
            return r;
        else
            return -r;
    }
}
