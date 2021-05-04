package rogue1.map.map;

import rogue0.utils.Position;
import rogue2.entite.Joueur;

import java.util.ArrayList;

public class Map {
    public Map(){}

    public Grille generateSalle(){
        Grille grille = new Grille();
        grille.initialiseSalle(grille);
        grille.relierSalle(grille);
        ajouterJoueur(grille);
        grille.initialiseMonstre(grille);
        return grille;
    }

    private void ajouterJoueur(Grille grille)
    {
        Salle salleJoueur = getSalleDepart(grille.getListOfSalle());
        int salleJoueurX = (int) salleJoueur.getPos().getX();
        int salleJoueurY = (int) salleJoueur.getPos().getY();
        grille.addEntite(new Joueur(new Position(salleJoueurX,salleJoueurY)));
    }

    private Salle getSalleDepart(ArrayList<Salle>listSalle)
    {
        int x = (int) listSalle.get(0).getPos().getX();
        int y = (int) listSalle.get(0).getPos().getY();
        Salle salleDepart;
        salleDepart = listSalle.get(0);
        for (Salle salle : listSalle)
        {
            if(salle.getPos().getY()<= y)
            {
                if(salle.getPos().getY() == y)
                {
                    if(salle.getPos().getX() < x)
                    {
                        salleDepart = salle;
                        x = (int) salleDepart.getPos().getX();
                        y = (int) salleDepart.getPos().getY();
                    }

                }
                else
                {
                    salleDepart = salle;
                    x = (int) salleDepart.getPos().getX();
                    y = (int) salleDepart.getPos().getY();

                }

            }
        }
        return salleDepart;
    }
}
