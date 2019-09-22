import java.util.*;

class FractionCalculator {
    public static void main(String[] args) {
        System.out.println("This program is a Fraction Calculator.");
        System.out.println("It will add, subtract, multiply and divide until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        getOperation();

    }

    public static String getOperation() {
        for (int i = 0; i < 72; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        System.out.println("Please enter an operation (+, -, *, /, = or Q to quit): ");
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();
        while (!operation.equalsIgnoreCase("+") && !operation.equalsIgnoreCase("-") && !operation.equalsIgnoreCase("*") && !operation.equalsIgnoreCase("/") && !operation.equalsIgnoreCase("q")) {
            System.out.println("Invalid input. Please enter an operation (+, -, *, /, = or Q to quit): ");
            operation = input.nextLine();
        }
        input.close();
        return operation;

    }

    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            if (denominator == 0) {
                throw new IllegalArgumentException("The denominator cannot be 0.");
            }
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }

        public Fraction(int value) {
            this.numerator = value;
            this.denominator = 1;
        }

        public Fraction() {
            this.numerator = 0;
            this.denominator = 1;
        }

        public int getNumerator() {
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public double toDouble() {
            return numerator/denominator;
        }

        public Fraction add(Fraction other) {
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            if (this.denominator == other.denominator) {
                int resultNumerator = this.numerator + other.numerator;
                int resultDenominator = this.denominator;
            }
            return result;
        }

        public Fraction subtract(Fraction other) {
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            if (this.denominator == other.denominator) {
                int resultNumerator = this.numerator - other.numerator;
                int resultDenominator = this.denominator;
            }
            return result;
        }

        public Fraction multiply(Fraction other) {
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            int resultNumerator = this.numerator * other.numerator;
            int resultDenominator = this.denominator * other.denominator;
            return result;
        }

        public Fraction divide(Fraction other) {
            Fraction result = new Fraction(resultNumerator, resultDenominator);
            double resultNumerator = this.numerator / other.numerator;
            double resultDenominator = this.denominator / other.denominator;
        }

        public boolean equals(Object other) {
            if (other instanceof Fraction) {
                if ((Fraction) other.numerator/other.denominator == this.numerator/this.denominator)
                    return true;
            }
            else return false;
        }

        public void toLowestTerms() {
            int a = this.numerator;
            int b = this.denominator;
            while (a != 0 && b != 0) {
                int remainder = a % b;
                a = b;
                b = remainder;
            }
            this.numerator = a;
            this.denominator = b;
        }

        public static int gcd(int num, int den) {
            int gcd = num/den;
            return gcd; 
        }
    }
}