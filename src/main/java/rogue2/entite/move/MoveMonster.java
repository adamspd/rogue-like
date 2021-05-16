package rogue2.entite.move;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue2.entite.monstre.Monster;

public class MoveMonster {
    public static boolean isInCouloir = false;
    private static boolean isEnteredInPortal = false;
    private static String direction;


    public static void moveDown(Grille grille, Monster player) {
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        direction = "down";
        Position position = new Position(x, y + 1);
        move(grille, player, position);
    }

    public static void moveUp(Grille grille, Monster player) {
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        direction = "up";
        Position position = new Position(x, y - 1);
        move(grille, player, position);
    }

    public static void moveLeft(Grille grille, Monster player) {
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        direction = "left";
        Position position = new Position(x - 1, y);
        move(grille, player, position);
    }

    public static void moveRight(Grille grille, Monster player) {
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        direction = "right";
        Position position = new Position(x + 1, y);
        move(grille, player, position);
    }

    public static void move(Grille grille, Monster player, Position position){
        if(grille.isInSalle(position)||grille.isInCouloir(position)){
            if(isInCouloir) {
                grille.addElement(player.getPosition(), grille.getSymbolCouloir());
            }

            if(grille.isInCouloir(position)) {
                isInCouloir = true;
            } else {
                isInCouloir = false;
            }
            player.setPosition(position);
            grille.addEntite(player);
        }

        for(Monster monster : grille.getListMonster()) {
            grille.SearchPlayer(grille, monster);
        }
    }
}
