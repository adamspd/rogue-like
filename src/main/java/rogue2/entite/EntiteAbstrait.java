package rogue2.entite;
import rogue0.utils.Position;
import rogue1.map.map.Grille;


public abstract class EntiteAbstrait {
    private static String symbole;
    private Position position;

    public EntiteAbstrait(String symbole, Position position){
        this.symbole = symbole;
        this.position = position;
    }

    public abstract void addSpecificEntiteList(Grille grille);

    public String getSymbole() { return symbole; }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public Position getPos() {
        return position;
    }

    public void setPos(Position position) {
        this.position = position;
    }


}
