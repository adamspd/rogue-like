package rogue2.entite.monstre;

import rogue0.utils.Position;
import rogue2.entite.abstrait.AbstractEntity;
import rogue2.entite.player.PlayerInterface;

public abstract class  AbstractMonster extends AbstractEntity implements Monster {

    public AbstractMonster(Position position, int hitPoints, double movement, int damages, String symbol) {
        super(position, hitPoints, movement, damages, symbol);
    }

    public void flee(PlayerInterface playerInterface){
        double movement = getMovement();
        move(playerInterface, -movement);
    }

    public boolean moveAway(PlayerInterface playerInterface, double distance){
        double movement = getMovement();
        boolean hasToMove = getDistance(playerInterface) < distance;
        if (hasToMove){
            move(playerInterface, -movement);
        }
        return hasToMove;
    }

    private void move(PlayerInterface playerInterface, double distance){
        Position monsterPosition = getPosition();
        Position playerPosition = playerInterface.getPosition();
        setPosition(monsterPosition.moveToward(playerPosition, -distance));
    }

    private double getDistance(PlayerInterface playerInterface){
        Position monsterPosition = getPosition();
        Position playerPosition = playerInterface.getPosition();
        return monsterPosition.getDistance(playerPosition);
    }

    public boolean engage(PlayerInterface playerInterface){
        double movement = getMovement();
        boolean hasToMove = getDistance(playerInterface) > 1;
        if (hasToMove){
            move(playerInterface, movement);
        }
        return hasToMove;
    }

    public void attack(PlayerInterface playerInterface){
        playerInterface.setHitPoints(playerInterface.getHitPoints() - getDamages());
    }

}
