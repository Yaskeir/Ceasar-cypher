import java.util.Scanner;

public class LearnScanner {
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("What is your name?");
        String name = input.next();
        System.out.print("Hello " + name + "!");
    }
}