import java.util.Scanner;

public class calculate2 {

    public static double sum(int a, int b){
        int x;
        x = a + b;
        return x;
    }

    public static double multiplication(int aa, int bb){
        double y;
        y = aa * bb;
        return y;
    }

    public static double minus(double y, int z){
        double n;
        n = y - z;
        return n;
    }

    public static double divide(double a, int b){
        double t;
        t = a / b;
        return t;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String answer = "exit";

        while (!answer.equals(in)) {

            System.out.println("Enter numbers");

            int a = in.nextInt();
            int b = in.nextInt();

            double m = sum(a, b);
            System.out.println("a + b = " + m);

            int aa = in.nextInt();
            int bb = in.nextInt();

            double p = multiplication(aa, bb);
            System.out.println("a * b = " + p);

            int z = in.nextInt();
            double u = minus(p, z);
            System.out.println(p + " - " + z + " = " + u);

            int r = in.nextInt();
            double t = divide(u, r);
            System.out.println(u + " / " + r + " = " + String.format("%,.3f", t));
        }
    }

}
