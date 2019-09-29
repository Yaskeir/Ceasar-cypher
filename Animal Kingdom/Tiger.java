import java.awt.*;
import java.util.*;

class Tiger extends Critter {
    public int moveCounter = 0;
    Color currentColor = randomColor();
    public void randomize() {
        if (moveCounter % 3 == 0) {
            currentColor = randomColor();
        }
    }
    public Tiger() {
        super();
    }
    public Color getColor() {
        return currentColor;
    }
    public Color randomColor() {
        Random random = new Random();
        float color = random.nextFloat();
        if (color > 0 && color < 0.33) {
            return Color.RED;
        }
        else if (color > 0.33 && color < 0.67) {
            return Color.BLUE;
        }
        else return Color.GREEN;
    }
    public String toString() {
        return "TGR";
    }
    public Action getMove(CritterInfo info) {
        moveCounter++;
        randomize();
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        }
        else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        }
        else {
            return Action.HOP;
        } 
    }
}