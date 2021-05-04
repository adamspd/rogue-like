package rogue2.entite.move;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue2.entite.player.Player;

public class Move {
    public static void moveDown(Grille grille, Player player){
            double x = player.getPosition().getX();
            double y = player.getPosition().getY();
            System.out.println("pos joueur \nx: " + x + "\ty: " + y);
            Position position = new Position(x, y + 1);
            System.out.println("pos supposé \nx: " + position.getX() + "\ty: " + position.getY());
            boolean canMove = checkBorderofSalle(grille, 'D');
            System.out.println(canMove);
            if (canMove){
                player.setPosition(position);
                System.out.println("pos changé \nx: " + position.getX() + "\ty: " + position.getY());
                grille.addElement(position, grille.getSymbolSalle());
                grille.addEntite(player);
            }
            /*grille.addElement(pos, grille.getSymbolSalle());
            pos.setY((int)pos.getY() + 1);
            player.setPosition(pos);
            grille.addEntite(player);*/

    }

    public static void moveUp(Grille grille){

    }

    public static void moveLeft(Grille grille){

    }

    public static void moveRight(Grille grille){

    }

    private boolean checkMap(Grille grille){
        return false;
    }

    /*
    Direction

         2                U
     -1     1   ou     L     R
        -2                D

     */

    public static boolean checkBorderofSalle(Grille grille, char direction){
        Player player = grille.getListePlayer().get(0);
        Position position = player.getPosition();
        boolean canMove = false;
        // direction == gauche
        if (direction == 'L'){
            position.setX((int)position.getX() - 1);
            if (!isWhatInLeftOfThisPostionEqualsTo(grille.getSymbolSalle(), position, grille)){
                canMove = true;
            }

        }
        // direction == droite
        else if (direction == 'R'){
            position.setX((int)position.getX() + 1);
            if (!isWhatInLeftOfThisPostionEqualsTo(grille.getSymbolSalle(), position, grille)){
                canMove = true;
            }

        }
        // direction == haut
        else if (direction == 'U'){
            position.setX((int)position.getY() - 1);
            if (!isWhatInLeftOfThisPostionEqualsTo(grille.getSymbolSalle(), position, grille)){
                canMove = true;
            }

        }
        // direction == bas
        else if (direction == 'D'){
            position.setX((int)position.getY() + 1);
            if (!isWhatInLeftOfThisPostionEqualsTo(grille.getSymbolSalle(), position, grille)){
                canMove = true;
            }

        }
        return canMove;
    }

    public static boolean isWhatInLeftOfThisPostionEqualsTo(String symbol, Position thisPostion, Grille grille){
        return grille.getSymbolAtCoord(thisPostion).equals(symbol);
    }

}
