package rogue3.artefact;

import rogue0.utils.Position;
import rogue0.utils.Utils;
import rogue1.map.map.Grille;
import rogue2.entite.player.Player;
import rogue2.entite.player.PlayerInterface;

import java.util.ArrayList;

public class Coffre extends abstractArtefact{
    public Coffre(Position position, String symbol) {
        super(position, "¤ ");
    }

    public static void hasOpenSafe(Grille grille, Position position){
        int nbresCoffre = grille.getListCoffre().size();
        int nbresRandom = Utils.randInt(1, nbresCoffre);
        //int nbreRestant = nbresCoffre - nbresRandom;
        if (nbresRandom <= nbresCoffre/2){
            System.out.println("C'ETAIT UN PIEGE, VOUS ETES TOMBER DEDANT");
            grille.getPlayer().setHitPoints(0); }

        else{
            Player player = grille.getPlayer();
            if (!checkPvPlayer(player)){
                player.setHitPoints(player.getHitPoints() + 5);
            } else {
                player.setPotionReserve(player.getPotionReserve() + 1);
            }}
        removeCoffreFromList(grille, position);
    }

    private static void removeCoffreFromList(Grille grille, Position position) {
        ArrayList<Coffre> listeCoffre = grille.getListCoffre();
        listeCoffre.removeIf(coffre -> coffre.getPosition() == position);
    }

    private static boolean checkPvPlayer(PlayerInterface player){
        return player.getHitPoints() == player.getMaxHitPoints();

    }

    public static String getSymbole(){
        return "¤ ";
    }
}
