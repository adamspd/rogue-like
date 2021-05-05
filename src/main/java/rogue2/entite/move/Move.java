package rogue2.entite.move;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue2.entite.player.Player;
import rogue3.artefact.Artefact;
import rogue3.artefact.Coffre;
import rogue3.artefact.Portal;
import rogue3.artefact.Potion;

public class Move {
    private static boolean isInCouloir = false;
    private static boolean isEnteredInPortal = false;


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
        Potion potion = grille.getListPotion().get(0);
        Coffre coffre = grille.getListCoffre().get(0);



        if(grille.isInSalle(position)||grille.isInCouloir(position)||
                grille.isPotionThere(position)||grille.isSafeThere(position)){
            if(isInCouloir) {
                grille.addElement(player.getPosition(), grille.getSymbolCouloir());
            }
            else {
                if (grille.isPotionThere(position)){
                    System.out.println("yes yes");
                    Potion.hasDrunkPotion(grille, position);
                } else if (grille.isSafeThere(position)){
                    Coffre.hasOpenSafe(grille, position);
                }
                grille.addPoint(player.getPosition());
                //if(grille.getSymbolAtCoord(position)!= Portal.getSymbole()){grille.addPoint(position);}
            }
            if(grille.isInCouloir(position)) {
                isInCouloir = true;
            } else {
                isInCouloir=false;
            }
            player.setPosition(position);
            grille.addEntite(player);
        }
        else if(grille.isPortalThere(position)){
            double x = position.getX();
            double y = position.getY();
            grille.addPoint(position);
            x-=1.0;
            Portal portail_de_sortie = Portal.entrerPortail(position, grille);
            x= portail_de_sortie.getPosition().getX();
            y= portail_de_sortie.getPosition().getY();
            isEnteredInPortal = true;

            if(grille.getSymbolAtCoord(new Position(x-1,y))==grille.getSymbolSalle()) {
                move(grille, player, position);
            } else {move(grille, player, position);}
            isEnteredInPortal = false;

            return;
        }
    }

}
