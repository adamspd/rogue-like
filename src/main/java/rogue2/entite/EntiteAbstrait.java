package rogue2.entite;
import rogue0.utils.Pos;
import rogue1.map.map.Grille;


public abstract class EntiteAbstrait {
    private static String symbole;
    private Pos pos;

    public EntiteAbstrait(String symbole, Pos pos){
        this.symbole = symbole;
        this.pos = pos;
    }

    public abstract void addSpecificEntiteList(Grille grille);

    public String getSymbole() { return symbole; }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }


}
