import rogue0.utils.Position;
import rogue0.utils.Union;
import rogue1.map.map.Grille;
import rogue1.map.map.Draw;
import rogue1.map.map.Map;
import rogue1.map.map.Salle;
import rogue2.entite.move.Move;
import rogue2.entite.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Draw draw = new Draw();
        Map map = new Map();
        Grille grille = map.generateSalle();
        map.generateSalle();
        draw.draw(grille);


        /*Union union = new Union(grille);
        int[][] matrix = union.createMatrix();
        union.printMatrix(matrix);
        union.colorizeMatrix(matrix);
        List<Position> path = new ArrayList<>();
        union.searchPath(matrix, 10, 15, path);
        union.printListPosition(path);
        union.putPath(matrix, path);
        union.colorizeMatrix(matrix);*/



        Player player = grille.getPlayer();
        Scanner scan = new Scanner(System.in);
        while(player.isAlive()) {
            try {
                String touche = scan.nextLine();
                if (touche.matches("z.*")){Move.moveUp(grille, grille.getPlayer()); }
                else if (touche.matches("q.*")){Move.moveLeft(grille, grille.getPlayer());}
                else if (touche.matches("s.*")){Move.moveDown(grille, grille.getPlayer());}
                else if (touche.matches("d.*")){Move.moveRight(grille, grille.getPlayer());}
                grille.attack(grille, player);
                draw.draw(grille);
            } catch (Exception e) {
                System.out.println("error");
                draw.draw(grille);
            }
        }
    }
}
