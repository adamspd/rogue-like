package rogue2.entite.move;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue2.entite.player.Player;

public class Move {
    private static boolean isInCouloir = false;


    public static void moveDown(Grille grille, Player player) {
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x, y + 1);

        move(grille, player, position);
    }

    public static void moveUp(Grille grille, Player player) {
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x, y - 1);

        move(grille, player, position);
    }

    public static void moveLeft(Grille grille, Player player) {
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x - 1, y);

        move(grille, player, position);
    }

    public static void moveRight(Grille grille, Player player) {
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x + 1, y);

        move(grille, player, position);
    }

    public static void move(Grille grille, Player player, Position position){
        if(grille.isInSalle(position)||grille.isInCouloir(position)) {
            if(isInCouloir) {
                grille.addElement(player.getPosition(), grille.getSymbolCouloir());
            } else {
                grille.addPoint(player.getPosition());
            }
            if(grille.isInCouloir(position)) {
                isInCouloir = true;
            } else {
                isInCouloir=false;
            }
            player.setPosition(position);
            grille.addEntite(player);
        }
    }
}
