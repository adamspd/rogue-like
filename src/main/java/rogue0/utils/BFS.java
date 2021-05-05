/*package rogue0.utils;

import rogue1.map.map.Grille;
import rogue2.entite.monstre.Monster;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class BFS {
    public LinkedList<Position> BFS(Grille grille, Position depart, Position fin, ArrayList<Monster> m) {
        LinkedList<Position> path = new LinkedList<Position>(); //Chemin de départ à fin
        LinkedList<Position> essais = new LinkedList<Position>();
        Queue<Position> queue = new LinkedList<Position>();
        ArrayList<Position> visited = new ArrayList<Position>();
        queue.add(depart);
        String[][] ArrayGrille = grille.getGrille();


        visited.add(depart);
        while (!queue.isEmpty()) {
            Position s = queue.remove();
            int x = (int) s.getX();
            int y = (int) s.getY();
            boolean ajout = true;

            //PARCOURS AUTOUR DE LUI
            if ((x - 1 >= 0 && x - 1 < grille.getLength())) {
                if (!(ArrayGrille[y][x - 1].equals("  ")) && !(ArrayGrille[y][x - 1].equals("¤ ")) &&
                        !(ArrayGrille[y][x - 1].equals("K ")) && !(ArrayGrille[y][x - 1].equals("£ ")) &&
                        !(ArrayGrille[y][x - 1].equals("P ")) && !(ArrayGrille[y][x - 1].equals("! "))
                        || (x - 1 == fin.getX() && y == fin.getY())){
                    Position tempo = new Position(x - 1, y);

                    if (voisin(fin, queue, visited, s, tempo)) break;
                }
            }
            if ((y - 1 >= 0 && y - 1 < grille.getWidth())) {
                if (!(ArrayGrille[y - 1][x].equals("  ")) && !(ArrayGrille[y - 1][x].equals("¤ ")) &&
                        !(ArrayGrille[y - 1][x].equals("K ")) && !(ArrayGrille[y - 1][x].equals("£ ")) &&
                        !(ArrayGrille[y - 1][x].equals("P ")) && !(ArrayGrille[y - 1][x].equals("! "))
                        || (x - 1 == fin.getX() && y == fin.getY())){
                    Position tempo = new Position(x, y - 1);
                    if (voisin(fin, queue, visited, s, tempo)) break;
                }
            }
            if ((x + 1 > 0 && x + 1 < grille.getLength())) {
                if (!(ArrayGrille[y][x + 1].equals("  ")) && !(ArrayGrille[y][x + 1].equals("¤ ")) &&
                        !(ArrayGrille[y][x + 1].equals("K ")) && !(ArrayGrille[y][x + 1].equals("£ ")) &&
                        !(ArrayGrille[y][x + 1].equals("P ")) && !(ArrayGrille[y][x + 1].equals("! "))
                        || (x - 1 == fin.getX() && y == fin.getY())){
                    Position tempo = new Position(x + 1, y);
                    if (voisin(fin, queue, visited, s, tempo)) break;
                }
            }
            if ((y + 1 > 0 && y + 1 < grille.getWidth())) {
                if (!(ArrayGrille[y + 1][x].equals("  ")) && !(ArrayGrille[y + 1][x].equals("¤ ")) &&
                        !(ArrayGrille[y + 1][x].equals("K ")) && !(ArrayGrille[y + 1][x].equals("£ ")) &&
                        !(ArrayGrille[y + 1][x].equals("P ")) && !(ArrayGrille[y + 1][x].equals("! "))
                        || (x - 1 == fin.getX() && y == fin.getY())){
                    Position tempo = new Position(x, y + 1);
                    if (voisin(fin, queue, visited, s, tempo)) break;
                }
            }
        }

        // LinkedList to store path
        Position crawl = fin;
        path.add(crawl);
        boolean verif = false;

        while (!verif) {
            if (crawl.getParent() == null) {
                verif = true;
                break;
            }
            path.add(crawl.getParent());
            crawl = crawl.getParent();
        }


        fin.setParent(null);
        if (path.size() == 1) {
            essais.add(depart);
            return essais;
        }


        if (ArrayGrille[(int)path.get(path.size() - 2).getY()][(int)path.get(path.size() - 2).getX()].
        equals("@ ") || ArrayGrille[(int)path.get(path.size() - 2).getY()][(int)path.get(path.size() - 2).getX()].
        equals("R ") || ArrayGrille[(int)path.get(path.size() - 2).getY()][(int)path.get(path.size() - 2).getX()].
        equals("G ") || ArrayGrille[(int)path.get(path.size() - 2).getY()][(int)path.get(path.size() - 2).getX()].
        equals("O ")){

            essais.add(depart);
            return essais;

        }
        return path;
    }

    private static boolean voisin(Position fin, Queue<Position> queue, ArrayList<Position> visited, Position s, Position tempo) {
        boolean ajout;
        if (tempo.getY() == fin.getY() && tempo.getX() == fin.getX()) {
            fin.setParent(s);
            return true;
        }
        ajout = true;
        for(Position i : visited){
            if (i.getX() == tempo.getX() && i.getY() == tempo.getY()) {
                ajout = false;
                break;
            }
        }
        if(ajout){
            tempo.setParent(s);
            queue.add(tempo);
            visited.add(tempo);

        }
        return false;
    }
}*/
    
