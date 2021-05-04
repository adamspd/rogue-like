package rogue2.entite.monstre;

import rogue0.utils.Position;
import rogue2.entite.player.PlayerInterface;

public class OrcWarrior extends AbstractMonster {
    public OrcWarrior(Position position){
        super(position, 10, 2, 3, "O ");
    }

    @Override
    public void act(PlayerInterface player) {
        if (!engage(player)){
            attack(player);
        }
    }
}
