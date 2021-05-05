package rogue3.artefact;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue2.entite.player.PlayerInterface;

import java.util.ArrayList;

public class Potion extends abstractArtefact{
    public Potion(Position position, String symbol) {
        super(position, "! ");
    }

    @Override
    public void effect(Grille grille, Position position) {
        PlayerInterface player = grille.getPlayer();
        if (!checkPvPlayer(player)){
            player.setHitPoints(player.getHitPoints() + 5);
        } else {
         player.setReserveHitpoints(player.getReserveHitpoints() + 1);
        }
        grille.addPoint(position);
        removePotionFromList(grille, position);
    }

    public static void hasDrunkPotion(Grille grille, Position position){
        PlayerInterface player = grille.getPlayer();
        if (!checkPvPlayer(player)){
            player.setHitPoints(player.getHitPoints() + 5);
        } else {
            player.setReserveHitpoints(player.getReserveHitpoints() + 1);
        }
        grille.addPoint(position);
        removePotionFromList(grille, position);
    }

    private static boolean checkPvPlayer(PlayerInterface player){
        return player.getHitPoints() == player.getMaxHitPoints();

    }
    private static void removePotionFromList(Grille grille, Position position) {
        ArrayList<Potion> listePotion = grille.getListPotion();
        listePotion.removeIf(potion -> potion.getPosition() == position);
    }

}
