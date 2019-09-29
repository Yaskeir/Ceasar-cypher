import java.awt.*;
import java.util.*;

class Giant extends Critter {
    private int moveCounter = 0;
    private int cycleCounter = 0;
    public Giant() {
        super();
    }
    public Color getColor() {
        return Color.GRAY;
    }
    public String toString() {
        cycleTrigger();
        if (cycleCounter == 0) {
            return "fee";
        } 
        else if (cycleCounter == 1) {
            return "fie";
        }
        else if (cycleCounter == 2) {
            return "foe";
        }
        else {
            return "fum";
        }
    }
    public void cycleTrigger() {
        if (moveCounter % 6 == 0) {
            cycleCounter++;
        }
        if (cycleCounter > 3) {
            cycleCounter = 0;
        }
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
            return Action.RIGHT;
        }
    }
} 