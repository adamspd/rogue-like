package rogue2.entite;
import rogue0.utils.Pos;
import rogue1.map.map.Grille;


public class Joueur extends EntiteAbstrait{
    private int pv = 100;
    private int degat = 15;
    private int potionReserve = 0;

    public Joueur(Pos pos) {
        super("@ ", pos);
    }

    @Override
    public void addSpecificEntiteList(Grille grille) {
        grille.addJoueurList(this);
    }

    public int getPotionReserve() {
        return potionReserve;
    }

    public void setPotionReserve(int potionReserve) {
        this.potionReserve = potionReserve;
    }

    public String getSymbol(){ return this.getSymbol(); }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv)
    {
        this.pv = pv;
    }

    public boolean isAlive() {
        return pv>0;
    }

    private boolean isInCouloir = false;
}



