/* A class designed for entering operations
   on fractions on a single line,
   isn't executable though, since 
   it lacks a main method */

class FractionCalculatorAdvanced extends FractionCalculator {
    public static getOperation() {
        System.out.println("Please enter an operation in the form: [FRACTION] [OPERATION] [FRACTION]:");
        String operation = input.next();
        while(!validOperation(operation)) {

        }
    }

    public static boolean validOperation(String input) {
        boolean validOp = false;
        String[] arrOfInput = input.split(" ");
        if (validFraction(arrOfInput[0]) && (arrOfInput[1].equalsIgnoreCase("+") || arrOfInput[1].equalsIgnoreCase("-") || arrOfInput[1].equalsIgnoreCase("*") || arrOfInput[1].equalsIgnoreCase("/")) && validFraction(arrOfInput[2])) {
            validOp = true;
        }
        else {
            validOp = false;
        }
        return validOp;
    }
}