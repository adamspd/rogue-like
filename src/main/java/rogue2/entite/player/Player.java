package rogue2.entite.player;

import rogue0.utils.Position;
import rogue2.entite.abstrait.AbstractEntity;

public class Player extends AbstractEntity implements PlayerInterface {
    public Player(Position position) {
        super(position, 100, 1, 5, "@ ");
    }

    @Override
    public String getName() {
        return null;
    }
    private boolean isInCouloir = false;

    public boolean getIsInCouloir() {
        return isInCouloir;
    }
}
