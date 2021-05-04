package rogue2.entite.monstre;

import rogue2.entite.abstrait.Entity;
import rogue2.entite.player.PlayerInterface;

public interface Monster extends Entity {
    String getSymbol();
    void act(PlayerInterface playerInterface);
}
