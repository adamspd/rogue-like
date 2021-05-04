package rogue1.map.map;

import rogue0.utils.Couleur;

public class Draw {
    private Grille grille;
    public Draw(){}

    public void draw(Grille grille){
        this.grille = grille;
        String symbol_grille = grille.getSymbolGrille();
        String symbol_salle = grille.getSymbolSalle();
        String[][] ArrayGrille = grille.getGrille();
        for (String[] tab : ArrayGrille) {
            for (String s : tab){
                if (s == symbol_grille) {
                    System.out.print(Couleur.ROUGE + s + Couleur.RESET);
                    continue;
                }
                else if (s == symbol_salle) {
                    System.out.print(Couleur.VIOLET + s + Couleur.RESET);
                    continue;
                } else {
                    System.out.print(s);
                }
            }
            System.out.println("");
        }
        Information.Affichage(grille);
    }
}
