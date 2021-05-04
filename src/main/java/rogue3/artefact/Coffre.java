package rogue3.artefact;

import rogue0.utils.Position;
import rogue1.map.map.Grille;

public class Coffre extends abstractArtefact{
    public Coffre(Position position, String symbol) {
        super(position, "¤ ");
    }

    @Override
    public void effect(Grille grille, Position position) {

    }
}
