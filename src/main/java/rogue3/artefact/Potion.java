package rogue3.artefact;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue2.entite.player.PlayerInterface;
import java.lang.String;

public class Potion extends abstractArtefact{
    public Potion(Position position, String symbol) {
        super(position, "! ");
    }

  /*  @java.lang.Override
    public void effect(Grille grille, Position position) {
        PlayerInterface player = grille.getListePlayer().get(0);
        if (!checkPvJoueur(player)){
            player.setHitPoints(player.getHitPoints() + 5);
        } else {
         player.setReserveHitpoints(player.getReserveHitpoints() + 1);
        }
        grille.addPoint(position);
        removePotionFromList(grille, position);
    }
    private boolean checkPvJoueur(PlayerInterface player){
        return player.getHitPoints() == player.getMaxHitPoints();

    }
    private void removePotionFromList(Grille grille, Position position) {
        ArrayList<Potion> listePotion = grille.getListePotion();
        for (Potion potion : listePotion) {
            if (potion.getPosX() == posX && potion.getPosY() == posY){
                listePotion.remove(potion);
            }
        }
    }


}
}
/*
public static void hasDrunkPotion(Grille grille, int posX, int posY){
        Joueur joueur = grille.getListeJoueur().get(0);
        if (!checkPvJoueur(joueur)){
            joueur.setPv(joueur.getPv() + 5);
        } else {
            joueur.setPotionReserve(joueur.getPotionReserve() + 1);
        }
        grille.addPoint(posX, posY);
        removePotionFromList(grille, posX, posY);
    }

    private static void removePotionFromList(Grille grille, int posX, int posY) {
        ArrayList<Potion> listePotion = grille.getListePotion();
        for (Potion potion : listePotion) {
           if (potion.getPosX() == posX && potion.getPosY() == posY){
               listePotion.remove(potion);
           }
        }
    }

    private static boolean checkPvJoueur(Joueur joueur){
        return joueur.getPv() == 100;
    }
*/
}
