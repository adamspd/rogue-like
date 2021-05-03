import rogue0.utils.Pos;
import rogue1.map.map.Grille;
import rogue1.map.map.Draw;
import rogue1.map.map.Map;
import rogue1.map.map.Salle;

import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        Draw draw = new Draw();
        Grille grille = new Grille();
        draw.draw(grille);
        System.out.println("\n\n");



        Map map = new Map();
        Grille grille1 = map.generateSalle();
        map.generateSalle();
        draw.draw(grille1);
    }
}
