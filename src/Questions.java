import java.util.Scanner;

public class Questions {

public static String askName (){
    Scanner in = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = in.nextLine();
    return name;
}

public static int askAge (){
    Scanner yourAge = new Scanner(System.in);
    System.out.println("How old are you?");
    int age = yourAge.nextInt();
    return age;
}

//public void compare(){
//    boolean answer;
//    String yes = "yes";
//    Scanner a = new Scanner(System.in);
//    String answ = a.nextLine();
//
//    if (answer = answ.equals(yes)){
//        System.out.println("Thank you!");
//
//    }
//    else {
//        askName();
//        askAge();
//    }





    public static void main(String[] args) {

    System.out.println("Please input information about you!");
        String name = askName();
        int age = askAge();
        System.out.println("Is it correct information: " + " " + name + ", " + age + "?");
        String answer = "yes";
        Scanner ok = new Scanner(System.in);
        String ans = ok.nextLine();
        if (ans.equals(answer)){
            System.out.println("Thank you, " + name + "! We glad, that you choose our site;)");
        }
        else {
            System.out.println("Sorry, we had some mistake;(");
        }
    }
}
