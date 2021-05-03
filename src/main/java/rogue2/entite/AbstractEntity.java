package rogue2.entite;

import rogue0.utils.Pos;

public abstract class AbstractEntity {
    private Pos position;
    private int LifePoints;
    private final double movement;
    private final int damages;

    public AbstractEntity(Pos position, int lifePoints, double movement, int damages) {
        this.position = position;
        LifePoints = lifePoints;
        this.movement = movement;
        this.damages = damages;
    }

    public Pos getPosition() {
        return position;
    }

    public void setPosition(Pos position) {
        this.position = position;
    }

    public int getLifePoints() {
        return LifePoints;
    }

    public void setLifePoints(int lifePoints) {
        LifePoints = lifePoints;
    }

    public double getMovement() {
        return movement;
    }

    public int getDamages() {
        return damages;
    }
}
