package rogue0.utils;

import rogue1.map.map.Grille;
import rogue2.entite.monstre.Monster;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public LinkedList<Position> BFS(Grille grille, Position depart, Position fin, ArrayList<Monster> m) {
        LinkedList<Position> path = new LinkedList<Position>(); //Chemin de départ à fin
        LinkedList<Position> essais = new LinkedList<Position>();
        Queue<Position> queue = new LinkedList<Position>();
        ArrayList<Position> visited = new ArrayList<Position>();
        queue.add(depart);


        visited.add(depart);
        while (!queue.isEmpty()) {
            Position s = queue.remove();
            int x = s.getCoordonneeX();
            int y = s.getCoordonneeY();
            boolean ajout = true;

            //PARCOURS AUTOUR DE LUI
            if ((x - 1 >= 0 && x - 1 < grille.getTailleX())) {
                if (!(grille.grilleGrille[y][x - 1].equals(Pattern.Mur)) && !(grille.grilleGrille[y][x - 1].equals(Pattern.Coffre)) && !(grille.grilleGrille[y][x - 1].equals(Pattern.Vendeur)) && !(grille.grilleGrille[y][x - 1].equals(Pattern.Escalier)) || (x - 1 == fin.getCoordonneeX() && y == fin.getCoordonneeY())) {
                    Position tempo = new Position(x - 1, y);

                    if (voisin(fin, queue, visited, s, tempo)) break;
                }
            }
            if ((y - 1 >= 0 && y - 1 < grille.getTailleY())) {
                if (!(grille.grilleGrille[y - 1][x].equals(Pattern.Mur)) && !(grille.grilleGrille[y - 1][x].equals(Pattern.Coffre)) && !(grille.grilleGrille[y-1][x].equals(Pattern.Escalier)) && !(grille.grilleGrille[y-1][x].equals(Pattern.Vendeur)) || x == fin.getCoordonneeX() && y - 1 == fin.getCoordonneeY()) {
                    Position tempo = new Position(x, y - 1);
                    if (voisin(fin, queue, visited, s, tempo)) break;
                }
            }
            if ((x + 1 > 0 && x + 1 < grille.getTailleX())) {
                if (!(grille.grilleGrille[y][x + 1].equals(Pattern.Mur)) && !(grille.grilleGrille[y][x + 1].equals(Pattern.Coffre)) && !(grille.grilleGrille[y][x + 1].equals(Pattern.Escalier)) && !(grille.grilleGrille[y][x + 1].equals(Pattern.Vendeur)) || x + 1 == fin.getCoordonneeX() && y == fin.getCoordonneeY()) {
                    Position tempo = new Position(x + 1, y);
                    if (voisin(fin, queue, visited, s, tempo)) break;
                }
            }
            if ((y + 1 > 0 && y + 1 < grille.getTailleY())) {
                if (!(grille.grilleGrille[y + 1][x].equals(Pattern.Mur)) && !(grille.grilleGrille[y + 1][x].equals(Pattern.Coffre)) && !(grille.grilleGrille[y+1][x].equals(Pattern.Escalier)) && !(grille.grilleGrille[y+1][x].equals(Pattern.Vendeur)) || x == fin.getCoordonneeX() && y + 1 == fin.getCoordonneeY()) {
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
        if (path.size() == 1){
            essais.add(depart);
            return  essais;
        }

        /* TODO Refactor le mutant dans la classe Zombie */
        if (grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()].equals(Pattern.Zombie) && grille.grilleGrille[path.get(path.size()-1).getCoordonneeY()][path.get(path.size()-1).getCoordonneeX()].equals(Pattern.Zombie)){
            grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()] = Pattern.Mutant;

            for (int i = 0;i<m.size();i++) {


                if (m.get(i).getPos().getCoordonneeX() == path.get(path.size() - 1).getCoordonneeX() && m.get(i).getPos().getCoordonneeY() == path.get(path.size() - 1).getCoordonneeY()){

                    grille.grilleGrille[path.get(path.size()-1).getCoordonneeY()][path.get(path.size()-1).getCoordonneeX()] = Pattern.Simple;

                    m.get(i).setType("dead");

                }
            }


        }

        if (grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()].equals(Pattern.Joueur) || grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()].equals(Pattern.Zombie) || grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()].equals(Pattern.Squelette) || grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()].equals(Pattern.Araignee) || grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()].equals(Pattern.Squelette_Geant) || grille.grilleGrille[path.get(path.size()-2).getCoordonneeY()][path.get(path.size()-2).getCoordonneeX()].equals(Pattern.Mutant)){

            essais.add(depart);
            return  essais;

        }
        return path;
    }
    
