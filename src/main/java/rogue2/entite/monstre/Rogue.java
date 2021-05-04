package rogue2.entite.monstre;

import rogue0.utils.Position;
import rogue2.entite.player.PlayerInterface;

public class Rogue extends AbstractMonster {
    public Rogue(Position position) {
        super(position, 8, 1, 2, "R ");
    }

    @Override
    public void act(PlayerInterface playerInterface) {
        if (getHitPoints() <= getMaxHitPoints() / 2){
            flee(playerInterface);
        } else if (!engage(playerInterface)){
            attack(playerInterface);
        }
    }
}
