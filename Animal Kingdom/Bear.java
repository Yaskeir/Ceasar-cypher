import java.awt.*;
import java.util.*;

class Bear extends Critter {
    private int moveCounter;
    private boolean polar;
    public Bear(boolean polar) {
        super();
        this.polar = polar;
    }
    public Color getColor() {
        if (polar) return Color.WHITE;
        else return Color.BLACK;
    }
    public String toString() {
        if (moveCounter % 2 == 0) {
            return "/";
        }
        else return "\\";
    }
    public Action getMove(CritterInfo info) {
        moveCounter++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        else {
            return Action.LEFT;
        }
    }
}