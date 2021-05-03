package rogue1.map.map;

import rogue0.utils.Pos;
import rogue0.utils.Utils;
import rogue2.entite.Joueur;

import java.util.ArrayList;

public class Map {
    public Map(){}

    public Grille generateSalle(){
        Grille grille = new Grille();
        grille.initialiseSalle(grille);
        grille.relierSalle(grille);
        ajouterJoueur(grille);
        return grille;
    }

    private void ajouterJoueur(Grille grille)
    {
        Salle salleJoueur = getSalleDepart(grille.getListOfSalle());
        int salleJoueurX = salleJoueur.getPos().getX();
        int salleJoueurY = salleJoueur.getPos().getY();
        grille.addEntite(new Joueur(new Pos(salleJoueurX,salleJoueurY)));
    }

    private Salle getSalleDepart(ArrayList<Salle>listSalle)
    {
        int x = listSalle.get(0).getPos().getX();
        int y = listSalle.get(0).getPos().getY();
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
                        x = salleDepart.getPos().getX();
                        y = salleDepart.getPos().getY();
                    }

                }
                else
                {
                    salleDepart = salle;
                    x = salleDepart.getPos().getX();
                    y = salleDepart.getPos().getY();

                }

            }
        }
        return salleDepart;
    }
}
