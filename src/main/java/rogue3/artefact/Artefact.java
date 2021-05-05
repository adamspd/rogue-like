package rogue3.artefact;

import rogue0.utils.Position;
import rogue1.map.map.Grille;

public interface Artefact {
    Position getPosition();
    String getSymbol();
    void effect(Grille grille,Position position);

    /*static boolean isThere(Grille grille, Position position,String symbol) {
        return grille.getSymbolAtCoord(position).equals(symbol);
    }*/
}
