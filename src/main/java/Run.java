import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue1.map.map.Draw;
import rogue1.map.map.Map;
import rogue1.map.map.Salle;
import rogue2.entite.move.Move;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Draw draw = new Draw();
        Map map = new Map();
        Grille grille = map.generateSalle();
        map.generateSalle();
        draw.draw(grille);
        while(grille.getListePlayer().get(0).isAlive()){
            Scanner scan = new Scanner(System.in);
            if (scan.next().equals("s")){
                Move.moveDown(grille, grille.getListePlayer().get(0));
                draw.draw(grille);
            }
        }

        /*
        ArrayList<Salle> listSalle = grille.getListOfSalle();
        ArrayList<Position> coord = new ArrayList<>();
        for (Salle salle : listSalle) {
            final int distancePlayerCoord = 2;
            coord = Grille.initialiseEntite(grille, 10, salle, grille.getListePlayer().get(0), distancePlayerCoord);
            }
        for (Position position : coord) {
            System.out.println(position.getX() + ":" + position.getY());
            System.out.println(Move.isWhatInLeftOfThisPostionEqualsTo("  ", position, grille));
            System.out.println(Move.isWhatInLeftOfThisPostionEqualsTo("* ", position, grille));
            System.out.println(Move.isWhatInLeftOfThisPostionEqualsTo("R ", position, grille));
            System.out.println(Move.isWhatInLeftOfThisPostionEqualsTo("G ", position, grille));
            System.out.println(Move.isWhatInLeftOfThisPostionEqualsTo("O ", position, grille));
        }*/
    }
}
