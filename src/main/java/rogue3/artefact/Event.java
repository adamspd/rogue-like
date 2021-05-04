package rogue3.artefact;

import rogue0.utils.Position;
import rogue1.map.map.Grille;

import java.lang.String;

public class Event extends abstractArtefact {
    public Event(Position position, String symbol) {
        super(position, "£ ");
    }

    @Override
    public void effect(Grille grille, Position position) {

    }
}
