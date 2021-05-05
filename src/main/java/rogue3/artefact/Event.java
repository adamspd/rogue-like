package rogue3.artefact;

import rogue0.utils.Position;
import rogue1.map.map.Grille;
import rogue1.map.map.Information;
import rogue1.map.map.Map;
import rogue1.map.map.Salle;
import rogue2.entite.player.Player;

import java.lang.String;
import java.util.ArrayList;

public class Event  {
    public static String stairs_symbole= "= ";
    public static int posX_stairs, posY_stairs; //Initialisés dans niveau.genererateSalles(); Haut de l'escalier.
    public static boolean isCalled_ifMonstersAreAllDead_ThenUpperLevelEntryOpen;
    public static boolean gagne;

    private static boolean freeSpace(Grille grille, Salle salle_aleatoire, int posX) {
        if(grille.getSymbolAtCoord(new Position(posX, salle_aleatoire.getPos().getY()))==Coffre.getSymbole() ||
                grille.getSymbolAtCoord(new Position(posX, salle_aleatoire.getPos().getY()))==Portal.getSymbole()){return false;}
        for (int j = -4; j < 0; j++) {
            for (int i = -1; i < 2; i++) { //Un espace à gauche et à droite
                try {
                    if (grille.getSymbolAtCoord(new Position(posX + i, salle_aleatoire.getPos().getY() + j)) != grille.getSymbolSalle()) { return false; }
                }
                catch (IndexOutOfBoundsException e) {return false;}
            }
        }
        return true;
    }


        public static void genererateStairs(Grille grille) {    //Escalier présent, mais caché et inaccessible
        /*On choisit une salle.
        On choisit une position, en bordure de salle.
        Et on crée l'escalier à partir de cette position. */
            boolean freeSpace = false;
            ArrayList<Salle> listeSalles = grille.getListOfSalle();
            Salle salle_aleatoire;
            int posX;

            //Recherche d' un espace libre
            do {
                //On prend une salle aléatoire
                salle_aleatoire = listeSalles.get((int) (Math.random() * listeSalles.size()));
                //Enregistrement des positions de la salle (posX_Salle)
                ArrayList<Integer> posX_Salle = new ArrayList<Integer>();
                for (int i = (int)salle_aleatoire.getPos().getX() + 1; i < salle_aleatoire.getPos().getX() + salle_aleatoire.getSalleWidth() - 2; i++) {
                    posX_Salle.add(i);
                }

                do {
                    //On prend une position aléatoire
                    posX = posX_Salle.get((int) (Math.random() * posX_Salle.size()));
                    freeSpace = freeSpace(grille, salle_aleatoire, posX);
                    if (freeSpace) { break; }
                    posX_Salle.remove(Integer.valueOf(posX));
                }
                while (!posX_Salle.isEmpty());
                listeSalles.remove(salle_aleatoire);
            }
            while (!freeSpace);
            posX_stairs= posX;
            posY_stairs= (int) salle_aleatoire.getPos().getY()-3;
        }



        public static void ifMonstersAreAllDead_ThenUpperLevelEntryOpen(Grille grille, Map niveau){     //Rend l'escalier visible
            if(grille.getListMonster().isEmpty() && !isCalled_ifMonstersAreAllDead_ThenUpperLevelEntryOpen){
                if(niveau.NIVEAU < niveau.NOMBRE_DE_NIVEAUX) {
                    for (int posY = posY_stairs; posY < posY_stairs + 3; posY++) {
                        grille.addElement(new Position(posX_stairs, posY) , stairs_symbole);
                    }
                    isCalled_ifMonstersAreAllDead_ThenUpperLevelEntryOpen = true;
                    System.out.println("#### UN ESCALIER A ETE OUVERT !! ####\n");
                }
                else {gagne= true;}
            }
        }

        public static void ifPlayerHasGoneThroughTheUpperLevelEntry_ThenGenerateNewMap(Grille grille, Player joueur, Map niveau){
            if(grille.getSymbolAtCoord(new Position(posX_stairs,posY_stairs))==joueur.getSymbol()){
                grille.reset(niveau, joueur);
                isCalled_ifMonstersAreAllDead_ThenUpperLevelEntryOpen= false;
                Information.NOMBRE_MONSTRES_CONNU= grille.getListMonster().size();
                niveau.NIVEAU++;
            }
        }


}
