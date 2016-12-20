import java.util.Scanner;

public class calculate2 {


        public static double sum(int a, int b){
            int x;
            x = a + b;
            return x;
        }

        public static double multiplication(int a, int b){
            double y;
            y = a * b;
            return y;
        }

        public static double minus(double a, int b){
            double n;
            n = a - b;
            return n;
        }

        public static double divide(double a, int b){
            double t;
            t = a / b;
            return t;
        }

        public static double equationResult (String  numbers){

            String equal [] = numbers.split(" ");
            for (int t = 0; t < equal.length; t++) {}
            int a = Integer.parseInt(equal[0]);
            int b = Integer.parseInt(equal[2]);
            String c = equal[1];
            double qqq = compareSymbol(c, a, b);
            return qqq;
        }

        public static double compareSymbol (String c, int a , int b) {

            switch (c) {
                case "+": {
                    double x = sum(a, b);
                    return x;
                }
                case "-": {
                    double n = minus(a, b);
                    return n;
                }
                case "*": {
                    double y = multiplication(a, b);
                    return y;
                }
                case "/": {
                    double t = divide(a, b);
                    return t;
                }
            }
            return 0;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String answer = "exit";
            while (!answer.equals(in)){
                System.out.println("Input your equation");
                String numbers = in.nextLine();
                double otvet = equationResult(numbers);
                System.out.println(otvet);

            }

        }

    }
