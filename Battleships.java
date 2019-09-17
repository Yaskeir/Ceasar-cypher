import java.util.*;

class Battleships {
    static char[][] map = new char[10][10];
    public static void main(String[] args) {
        oceanMap();
        System.out.println("Deploy your ships:");
        for (int i = 0; i < 5; i++) {
            choice();
        };
        oceanMap();
    }

    public static void oceanMap() {
        System.out.println("**** Welcome to the Battle Ships game **** \n");
        System.out.println("Right now, the sea is empty. \n");
        System.out.println("   0123456789");
        for (int row = 0; row < map.length; row++) {
                System.out.print(row + " |");
                for (int col = 0; col < map[row].length; col++) {
                    if (map[row][col] == 1) {
                        System.out.print("@");
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

    public static void choice() {
        int x = choiceX();
        int y = choiceY();
        while (map[x][y] == 1) {
            System.out.println("There is already a ship at that position!");
            y = choiceY();
        }
        map[x][y] = 1;
    }

}