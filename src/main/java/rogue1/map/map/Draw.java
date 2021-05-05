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
        //ArrayList<Artefact> listeArtefact = grille.getListArtefact();
        //for (Artefact artefact : listeArtefact) {


            for (String[] tab : ArrayGrille) {
                for (String s : tab) {
                    if (s == symbol_grille) {
                        System.out.print(Couleur.ROUGE + s + Couleur.RESET);
                        continue;
                    }
                    else if (s == symbol_salle) {
                        System.out.print(Couleur.BLANC + s + Couleur.RESET);
                        continue;
                    }else if (s.equals("K ") || (s.equals("£ ")) || (s.equals("! ")) || (s.equals("¤ "))){
                        System.out.print(Couleur.VERT + s + Couleur.RESET);
                    }
                    else if (s.equals("P ")){
                        System.out.print(Couleur.JAUNE + s + Couleur.RESET);
                    }
                    else if (s.equals("@ ")){
                        System.out.print(Couleur.CYAN + s + Couleur.RESET);
                    }
                    else if (s.equals("# ")){
                        System.out.print(Couleur.MARRON + s + Couleur.RESET);
                    }
                    else if (s.equals("R ") || s.equals("G ") || s.equals("O ")){
                        System.out.print(Couleur.ROUGE + s + Couleur.RESET);
                    }
                    else {
                        System.out.print(s);
                    }
                }
                System.out.println("");
            }

            Information.Affichage(grille);
    }
}
