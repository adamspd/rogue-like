package rogue2.entite.monstre;

import rogue0.utils.Position;
import rogue2.entite.player.PlayerInterface;

public class GoblinArcher extends AbstractMonster {
    public GoblinArcher(Position position) {
        super(position, 4, 1, 1, "G ");
    }

    @Override
    public void act(PlayerInterface playerInterface) {
        if (getHitPoints() < getMaxHitPoints()){
            flee(playerInterface);
        } else if (!moveAway(playerInterface, 2)){
            attack(playerInterface);
        }
    }
}
