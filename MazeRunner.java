import java.util.*;

class MazeRunner {
    static Maze myMap = new Maze();
    public static Scanner userInput = new Scanner(System.in);
    public static String input;
    public static int moves = 0;
    public static void main(String[] args) {
        intro();
        executeMove();
    }

    public static void intro() {
        myMap.printMap();
    }

    public static String userMove() {
        System.out.println("Where would you like to move? (R, L, U, D)");
        String move = userInput.nextLine();
        while(!move.equalsIgnoreCase("R") && !move.equalsIgnoreCase("L") && !move.equalsIgnoreCase("U") && !move.equalsIgnoreCase("D")) {
            System.out.print("Invalid input, please type either R, L, U or D.");
            Scanner validInput = new Scanner(System.in);
            move = validInput.nextLine();
        }
        return move;
    }

    public static void executeMove() {
        movesMessage(moves);
        try {
            input = userMove();
            if (myMap.isThereAPit(input)) {
                navigatePit();
            }
            if (input.equalsIgnoreCase("R")) {
                if (myMap.canIMoveRight()) {
                    myMap.moveRight();
                    myMap.printMap();
                }
                else {
                    System.out.println("Sorry, you've hit a wall.");
            }
        }
            else if (input.equalsIgnoreCase("D")) {
                if (myMap.canIMoveDown()) {
                    myMap.moveDown();
                    myMap.printMap();
                }
                else {
                    System.out.println("Sorry, you've hit a wall.");
            }
        }
            else if (input.equalsIgnoreCase("L")) {
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                    myMap.printMap();
                }
                else {
                    System.out.println("Sorry, you've hit a wall.");
                }
            }
            else if (input.equalsIgnoreCase("U")) {
                if (myMap.canIMoveUp()) {
                    myMap.moveUp();
                    myMap.printMap();
                }
                else {
                    System.out.println("Sorry, you've hit a wall.");
            }
        }
        if (!myMap.didIWin()) {
            moves++;
            executeMove();
        }
        else {
            System.out.println("Congratulations, you've made it out alive!");
            movesMessage(moves);
            userInput.close();
        }
    }
    catch (IllegalArgumentException e) {
        System.out.println("Illegal.");
        executeMove();
    }
    catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("");
    }
    }

    public static void movesMessage(int moves) {
        if (moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
        }
        else if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }
        else if (moves == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }
        else if (moves == 100) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time - you lose!");

        }
        else if (myMap.didIWin()) {
            System.out.print("You've escaped and did it in " + moves + " moves.");
        }
    }
    public static void navigatePit() {
        System.out.println("Watch out! There's a pit ahead, jump it?");
        String answer = userInput.next();
        if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
            myMap.jumpOverPit(input);
        }
        else {
            executeMove();
        }
    }
}