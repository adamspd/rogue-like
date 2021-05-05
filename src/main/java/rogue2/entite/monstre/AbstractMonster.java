package rogue2.entite.monstre;

import rogue0.utils.Position;
import rogue0.utils.Utils;
import rogue1.map.map.Grille;
import rogue2.entite.abstrait.AbstractEntity;
import rogue2.entite.player.Player;
import rogue2.entite.player.PlayerInterface;

import java.util.ArrayList;

public abstract class  AbstractMonster extends AbstractEntity implements Monster {

    public AbstractMonster(Position position, int hitPoints, double movement, int damages, String symbol) {
        super(position, hitPoints, movement, damages, symbol);
    }

    public void flee(Player player){
        double movement = getMovement();
        move(player, -movement);
    }

    public boolean moveAway(Player player, double distance){
        double movement = getMovement();
        boolean hasToMove = getDistance(player) < distance;
        if (hasToMove){
            move(player, -movement);
        }
        return hasToMove;
    }

    private void move(Player player, double distance){
        Position monsterPosition = getPosition();
        Position playerPosition = player.getPosition();
        setPosition(monsterPosition.moveToward(playerPosition, -distance));
    }

    private double getDistance(Player player){
        Position monsterPosition = getPosition();
        Position playerPosition = player.getPosition();
        return monsterPosition.getDistance(playerPosition);
    }

    public boolean engage(Player player){
        double movement = getMovement();
        boolean hasToMove = getDistance(player) > 1;
        if (hasToMove){
            move(player, movement);
        }
        return hasToMove;
    }

    public void attack(Player player){
        player.setHitPoints(player.getHitPoints() - getDamages());
    }

    @Override
    public boolean isAlive(){
        return this.getHitPoints() > 0;
    }

}
