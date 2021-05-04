package rogue1.map.map;

import rogue0.utils.Utils;
import rogue2.entite.monstre.Monster;
import rogue2.entite.player.Player;
import rogue3.artefact.Portal;
import rogue3.artefact.Potion;

import java.util.ArrayList;

public class Information {
    public static int NOMBRE_MONSTRES_CONNU;
    public static ArrayList<String> liste_infos;  //Ajouté à un stade de développement assez avancé.

    public static void afficher_liste_info(){
        System.out.println();
        for (String info : liste_infos){
            System.out.println(info);
        }
        System.out.println();
        liste_infos.clear();
    }

    public static void Game_Over(){
        for (int i=0; i <4; i++) { System.out.print("\n"); }
        for (int i=0; i <10; i++) { System.out.print("\t"); }
        System.out.print("GAME OVER");
        for (int i=0; i <4; i++) { System.out.print("\n"); }
        System.exit(0);
    }

    public static void You_Win(){
        for (int i=0; i <4; i++) { System.out.print("\n"); }
        for (int i=0; i <5; i++) { System.out.print("\t"); }
        for (int i=0; i <12; i++) { System.out.print("#"); }
        System.out.print("    VOUS AVEZ GAGNE !!!    ");
        for (int i=0; i <12; i++) { System.out.print("#"); }
        for (int i=0; i <4; i++) { System.out.print("\n"); }
        System.exit(0);
    }


    public static void isMonsterDead(Grille grille){
        int nouveau_nombre_monstres = grille.getListMonster().size();
        if (nouveau_nombre_monstres < NOMBRE_MONSTRES_CONNU){
            if(nouveau_nombre_monstres > 0) {
                System.out.println("#### COUP FATALE !! ####");
                System.out.println("#### UN MONSTRE EST MORT ####" + "\n");
            }
            NOMBRE_MONSTRES_CONNU= nouveau_nombre_monstres;
        }
    }

    private static void isEnoughfar(
            Grille grille, ArrayList<Monster> monstres, Player player, int distance){

        /*if (Niveau.checkIfJoueurPresent(grille)) {
            System.out.println("#### DANGER #### LE COMBAT EST ENGAGE ##########");
        }*/
        for (Monster monstre : monstres) {
            boolean estEnCombat = !Utils.estAssezLoinDuJoueur(
                    monstre.getPosition(),
                    distance,grille,player);
            if (estEnCombat) {
                System.out.println("#### DANGER #### LE COMBAT EST ENGAGE ##########");
            }
        }
    }
    /*private static void SeeObject(Grille grille, ArrayList<Potion> potions, Player player) {
        for (Potion potion : potions) {
            boolean seeIt = !Utils.estAssezLoinDuJoueur(
                    potion.getPosition(),
                    1, grille, joueur);
            if (seeIt) {
                System.out.println("$$$$ Potion En vue $$$$");
            }
        }
    }

    private static void SeePortal(Grille grille, ArrayList<Portal> portals, Player joueur){
        for(Portal portal : portals){
            boolean SeeIt = !Utils.estAssezLoinDuJoueur(
                    portal.getPosition(),
                    1, grille, joueur);
            if(SeeIt){
                System.out.println("#### Un portail ! ####");
            }
        }
    }*/

    public static void Affichage(Grille grille){
        ArrayList<Monster> lesMonstres = grille.getListMonster();
        /*ArrayList<Potion> lesPotions = grille.getListPotion();
        ArrayList<Portal> lesPortails = grille.getListPortal();*/

        Player joueur = grille.getListePlayer().get(0);
        int lifePoints = joueur.getHitPoints();
        int nbreMonstres = lesMonstres.size();
        isEnoughfar(grille,lesMonstres,joueur, 1);
        /*SeeObject(grille,lesPotions,joueur);
        SeePortal(grille,lesPortails,joueur);*/
        System.out.println();
        /*if (joueur.getPotionReserve() > 1){*/
            System.out.println("Le nombre de Monstres : " + nbreMonstres + "\t \t Points de Vie restants: "+ lifePoints /*+
                    "\t \t Potions en reserve: " + joueur.getPotionReserve()*/);
       /* } else {
            System.out.println("Le nombre de Monstres : " + nbreMonstres + "\t \t Points de Vie restants: "+ lifePoints +
                    "\t \t Potion en reserve: " + joueur.getPotionReserve());
        }*/
    }
}
