package rogue0.utils;
import rogue1.map.map.Grille;
import rogue1.map.map.Salle;
import rogue2.entite.Joueur;

import java.util.Random;

public class Utils {
    /**
     *
     * @param pos
     * @param distanceMin
     * @param grille
     * @param joueur
     * @return a boolean telling if a position is far enough the player
     */
    public boolean estAssezLoinDuJoueur(Pos pos, int distanceMin, Grille grille, Joueur joueur){
        boolean isEnoughFar = true;
        try{
            for (int j = pos.getY() - distanceMin; j <= pos.getY() + distanceMin; j++){
                for (int i = pos.getX() - distanceMin; i <= pos.getX() + distanceMin; i++){
                    Pos pos1 = new Pos(i, j);
                    if(grille.getSymbolAtCoord(pos1).equals(joueur.getSymbole())){
                        isEnoughFar = false;
                    }
                }
            }
        } catch (Exception e){}
        return isEnoughFar;
    }

    /**
     * Fonction à refaire
     * @param salle
     * @return an Array of 2 numbers (integer) containing random coord in a specific room
     */
    public int[] getRandomCoordSalle(Salle salle){
        int[] randomCoord = new int[2];
        Pos pos = salle.getPos();
        int minX = pos.getX();;
        int minY = pos.getY();
        int maxX = salle.getSalleWidth() + minX;
        int maxY = salle.getSalleLenght() + minY;
        int coordRandomX = randInt(minX, maxX);
        int coordRandomY = randInt(minY, maxY);
        randomCoord[0] = coordRandomX;
        randomCoord[1] = coordRandomY;
        return randomCoord;
    }


    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, exclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min)) + min;

        return randomNum;
    }

    /**
     *
     * @param max
     * @return Integer  between 0 and max, exclusive.
     */
    public static int randInt(int max){
        return randInt(0, max);
    }
}


