package rogue3.artefact;

import rogue0.utils.Position;
import rogue1.map.map.Grille;

public class Portal extends abstractArtefact{
    public Portal(Position position,String symbol) {
        super(position, "P ");
    }

    @Override
    public void effect(Grille grille, Position position) {

    }
}
