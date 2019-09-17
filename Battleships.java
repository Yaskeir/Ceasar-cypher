import java.util.*;

class Battleships {
    static char[][] map = new char[10][10];
    static boolean playerSunk;
    static boolean computerSunk;
    public static void main(String[] args) {
        System.out.println("**** Welcome to the Battle Ships game **** \n");
        System.out.println("Right now, the sea is empty. \n");
        oceanMap();
        System.out.println("Deploy your ships:");
        for (int i = 0; i < 5; i++) {
            choice();
        };
        for (int j = 1; j < 6; j++) {
            computer();
            System.out.println(j + ". ship DEPLOYED");
        }
        oceanMap();
        playerTurn();
    }

    public static void oceanMap() {
        System.out.println("   0123456789");
        for (int row = 0; row < map.length; row++) {
                System.out.print(row + " |");
                for (int col = 0; col < map[row].length; col++) {
                    if (map[row][col] == 1) {
                        System.out.print("@");
                    }
                    else if (map[row][col] == 2) {
                        System.out.print("^");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println("| " + row);
        }
        System.out.println("   0123456789");
    };

    // a very elegant while loop made for asking the user for input until provided the right format
    public static int choiceX() {
        System.out.println("Enter the X coordinate for your ship: ");
        while(true) {
            try {
                Scanner input = new Scanner(System.in); 
                int choice = input.nextInt();
                if (choice >= 0 || choice <= 9) {
                    return choice;
                    }
                }
            catch(Exception e) {
                System.out.println("Please insert a value between 0 and 9.");
                continue;
                }
        }
    }
    public static int choiceY() {
        System.out.println("Enter the Y coordinate for your ship: ");
        while(true) {
            try {
                Scanner input = new Scanner(System.in); 
                int choice = input.nextInt();
                if (choice >= 0 && choice <= 9) {
                    return choice;
                    }
                else {
                    throw new Exception();
                }
                }
            catch(Exception e) {
                System.out.println("Please insert a value between 0 and 9.");
                continue;
                }
        }
    }

    public static void choice() {
        int x = choiceX();
        int y = choiceY();
        while (map[x][y] == 1) {
            System.out.println("There is already a ship at that position!");
            y = choiceY();
        }
        map[x][y] = 1;
    }

    public static void computer() {
        System.out.println("The computer is deploying ships.");
        int x = (int) (Math.random() * 9);
        int y = (int) (Math.random() * 9);
        while (map[x][y] == 1 || map[x][y] == 2) {
            y = (int) Math.random() * 9;
        }
        map[x][y] = 2;
    }

    public static int playerTurnX() {
        System.out.println("YOUR TURN");
        System.out.println("Enter the X coordinate: ");
        while(true) {
            try {
                Scanner input = new Scanner(System.in); 
                int choice = input.nextInt();
                if (choice >= 0 || choice <= 9) {
                    return choice;
                    }
                }
            catch(Exception e) {
                System.out.println("Please insert a value between 0 and 9.");
                continue;
                }
        }
    }
    public static int playerTurnY() {
        System.out.println("YOUR TURN");
        System.out.println("Enter the Y coordinate: ");
        while(true) {
            try {
                Scanner input = new Scanner(System.in); 
                int choice = input.nextInt();
                if (choice >= 0 || choice <= 9) {
                    return choice;
                    }
                }
            catch(Exception e) {
                System.out.println("Please insert a value between 0 and 9.");
                continue;
                }
        }
    }

    public static void playerTurn() {
        int playerX = playerTurnX();
        int playerY = playerTurnY();
        if (map[playerX][playerY] == 1) {
            System.out.println("You've sunk your own ship.");
            // playerSunk = true;
        }
        else if (map[playerX][playerY] == 2) {
            System.out.println("You've sunk the ship!");
            // computerSunk = true;
        }
        System.out.println("   0123456789");
        for (int row = 0; row < map.length; row++) {
                System.out.print(row + " |");
                for (int col = 0; col < map[row].length; col++) {
                    if (map[row][col] == 1 && playerSunk) {
                        System.out.print("X");
                    }
                    else if (map[row][col] == 1) {
                        System.out.print("@");
                    }
                    else if (map[row][col] == 2) {
                        System.out.print("^");
                    }
                    else if (map[row][col] == 2 & computerSunk) {
                        System.out.print("X");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println("| " + row);
        }
        System.out.println("   0123456789");
    }
    

}