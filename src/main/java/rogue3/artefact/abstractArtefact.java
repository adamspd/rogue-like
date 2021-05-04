package rogue3.artefact;

import rogue0.utils.Position;
import java.lang.String;

public abstract class abstractArtefact implements Artefact {
    private Position position;
    private String symbol;

    public Position getPosition() {
        return position;
    }

    public abstractArtefact(Position position, String symbol) {
        this.position = position;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
