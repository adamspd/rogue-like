package rogue2.entite.move;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue2.entite.player.Player;

public class Move {
    public static void moveDown(Grille grille, Player player){
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x, y + 1);
        move(grille, player, position);
    }

    public static void moveUp(Grille grille, Player player){
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x, y - 1);
        move(grille, player, position);
    }

    public static void moveLeft(Grille grille, Player player){
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x - 1, y);
        move(grille, player, position);
    }

    public static void moveRight(Grille grille, Player player){
        double x = player.getPosition().getX();
        double y = player.getPosition().getY();
        Position position = new Position(x + 1, y);
        move(grille, player, position);
    }

    private boolean checkMap(Grille grille){
        return false;
    }

    private static void move(Grille grille, Player player, Position position){
        Position pos = position;
        boolean canMove = isInsSDown(pos, grille);
        System.out.println(canMove);
        if (canMove){
            grille.addPoint(player.getPosition());
            //grille.addElement(position, grille.getSymbolSalle()); ne fonctionne pas
            player.setPosition(pos);
            System.out.println("pos changé \nx: " + pos.getX() + "\ty: " + pos.getY());
            grille.addEntite(player);
        }
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


    public static boolean isInsSLeft(Position position, Grille grille)
        {return grille.isInSalle(position);}
    public static boolean isInsSRight(Position position, Grille grille)
        {return grille.isInSalle(position);}
    public static boolean isInsSUp(Position position, Grille grille)
        {return grille.isInSalle(position);}
    public static boolean isInsSDown(Position position, Grille grille)
        {return grille.isInSalle(position);}

    public boolean isInsCLeft(Position position, Grille grille)
        {return grille.isInCouloir(position);}
    public boolean isInsCRight(Position position, Grille grille)
        {return grille.isInCouloir(position);}
    public boolean isInsCUp(Position position, Grille grille)
        {return grille.isInCouloir(position);}
    public boolean isInsCDown(Position position, Grille grille)
        {return grille.isInCouloir(position);}
}
