import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue1.map.map.Draw;
import rogue1.map.map.Map;
import rogue1.map.map.Salle;

public class Run {
    public static void main(String[] args) {
        Draw draw = new Draw();
        Map map = new Map();
        Grille grille1 = map.generateSalle();
        map.generateSalle();
        draw.draw(grille1);
    }
}
