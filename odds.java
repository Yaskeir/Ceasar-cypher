import java.util.*;

public class odds {
    public static void main(String[] args) {
            greeting();
            String choice = choose(); // need to store the returned value in a variable for it to be reusable later
            System.out.print("Choose a number between 0 and 5. ");
            Scanner in = new Scanner(System.in);
            int user = in.nextInt();
            while (user < 0 || user > 5) {
                System.out.print("Please put in an integer between 0 and 5. ");
                Scanner sc3 = new Scanner(System.in);
                user = sc3.nextInt();
            };
            Random rand = new Random();
            int computer = rand.nextInt(6);
            System.out.println("The computer played the number " + computer + ".");
            System.out.print("\n");
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println("\n");
            int sum = 0;
            sum = user + computer;
            System.out.println("You chose " + user + ". The computer chose " + computer + ".");
            System.out.println("The sum is as follows: " + user + " + " + computer + " = " + sum);
            boolean oddOrEven = (sum % 2 == 0);
            if (oddOrEven) {
                System.out.print(sum + " is even.");
                if (choice.equalsIgnoreCase("e")) {
                    System.out.print(" Therefore, you win!");
                }
                else {
                    System.out.print(" Therefore, you lose.");
                }
            }
            else {
                System.out.print(sum + " is odd.");
                if (choice.equalsIgnoreCase("o")) {
                    System.out.print(" Therefore, you win!");
                }
                else {
                    System.out.print(" Therefore, you lose.");
                }
            }            
        };

    public static void greeting() {
        System.out.println("Let's play a game called \"Odds and Evens\"!");
        System.out.println("What's your name?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello, " + name + ". Which do you choose? (O)dds or (E)vens?");
    }

    public static String choose() {
        Scanner sc2 = new Scanner(System.in);
        String choice = sc2.next();
        while (!choice.equalsIgnoreCase("O") && !choice.equalsIgnoreCase("E")) {
            System.out.print("Please type in either O or E. ");
            Scanner sc3 = new Scanner(System.in);
            choice = sc3.next();
        }
        if (choice.equalsIgnoreCase("o")) {
            System.out.println("You have chosen odds. The computer will be evens.");
        }
        else {
            System.out.println("You have chosen evens. The computer will be odds.");
        };
        System.out.println("");
        for (int i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        return choice;
    }
    
}