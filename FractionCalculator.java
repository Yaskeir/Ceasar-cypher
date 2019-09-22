import java.util.*;

class FractionCalculator {
    public static Scanner input = new Scanner(System.in); 
    public static void main(String[] args) {
        System.out.println("This program is a Fraction Calculator.");
        System.out.println("It will add, subtract, multiply and divide until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        while(true) {
            String operation = getOperation();
            Fraction fraction1 = getFraction();
            Fraction fraction2 = getFraction();
            if (operation.equals("+")) System.out.println(fraction1 + " " + operation + " " + fraction2 + " = " + fraction1.add(fraction2));
            else if(operation.equals("-")) System.out.println(fraction1 + " " + operation + " " + fraction2 + " = " + fraction1.subtract(fraction2));
            else if(operation.equals("*")) System.out.println(fraction1 + " " + operation + " " + fraction2 + " = " + fraction1.multiply(fraction2));
            else if(operation.equals("/")) System.out.println(fraction1 + " " + operation + " " + fraction2 + " = " + fraction1.divide(fraction2));
        }
    }

    public static String getOperation() {
        for (int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        System.out.println("Please enter an operation (+, -, *, /, = or Q to quit): ");
        String operation = input.nextLine();
        while (!operation.equalsIgnoreCase("+") && !operation.equalsIgnoreCase("-") && !operation.equalsIgnoreCase("*") && !operation.equalsIgnoreCase("/") && !operation.equalsIgnoreCase("q")) {
            System.out.println("Invalid input. Please enter an operation (+, -, *, /, = or Q to quit): ");
            operation = input.nextLine();
        }
        if (operation.equalsIgnoreCase("q")) {
            System.exit(0);
        }
        return operation;
    }

    public static Fraction getFraction() {
        System.out.println("Please enter a fraction (a/b) or an integer (a):");
        String ab = input.nextLine();
        while(!validFraction(ab)) {
            System.out.println("Please enter a fraction (a/b) or an integer (a):");
            ab = input.nextLine();
        }
        int num = 0;
        int den = 0;
        if (ab.contains("/")) { //Use Integer.parseInt() to change strings to int
            num = Integer.parseInt(ab.substring(0,ab.indexOf("/") ));
            den = Integer.parseInt(ab.substring(ab.indexOf("/")+1, ab.length()));
        } 
        else {
            num=Integer.parseInt(ab);
            den = 1;
        }
        Fraction fraction = new Fraction(num, den);
        return fraction;
    }

    public static boolean validFraction(String input) {
        boolean valid;
        if (input.contains("/")) {
            input = input.replace("/", "");
            if (input.matches("[0-9]+")) valid = true;
            else valid = false;
        }
        else if (input.length() == 1 && input.matches("[0-9]+")) {
            valid = true;
        }
        else {
            valid = false;
        }
        return valid;
    }
}