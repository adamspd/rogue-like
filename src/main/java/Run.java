import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue1.map.map.Draw;
import rogue1.map.map.Map;
import rogue1.map.map.Salle;
import rogue2.entite.move.Move;
import rogue2.entite.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Draw draw = new Draw();
        Map map = new Map();
        Grille grille = map.generateSalle();
        map.generateSalle();
        draw.draw(grille);
        Player player = grille.getListePlayer().get(0);
        while(player.isAlive()) {
            Scanner scan = new Scanner(System.in);
            /*if (touche.next().equals("s")){Move.moveUp(grille, player);}
            else if (touche.next().equals("q")){Move.moveLeft(grille, player);}
            else if (touche.next().equals("s")){Move.moveDown(grille, player);}
            else if (touche.next().equals("d")){Move.moveRight(grille, player);}*/
            while (scan.hasNext()) {
                if (scan.next().equals("s")) {
                    Move.moveDown(grille, grille.getListePlayer().get(0));
                    draw.draw(grille);
                } else if (scan.next().equals("z")) {
                    Move.moveUp(grille, grille.getListePlayer().get(0));
                    draw.draw(grille);
                } else if (scan.next().equals("q")) {
                    Move.moveLeft(grille, grille.getListePlayer().get(0));
                    draw.draw(grille);
                } else if (scan.next().equals("d")) {
                    Move.moveRight(grille, grille.getListePlayer().get(0));
                    draw.draw(grille);
                } else {
                    System.out.println("error");
                    draw.draw(grille);
                }
            }
        }
    }
}
