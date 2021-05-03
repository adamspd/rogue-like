package rogue1.map.map;
import rogue0.utils.Pos;
import rogue0.utils.Union;
import rogue0.utils.Utils;
import rogue2.entite.EntiteAbstrait;
import rogue2.entite.Joueur;

import java.util.ArrayList;

public class Grille {
    private final int Length = 30;
    private final int width = 60;
    private String EMPTYSTRING = ". ";
    private String[][] grille = new String[Length][width];
    private final int ESPACE_MINIMUM_ENTRE_SALLE = 4;
    private int nombreSalle = Utils.randInt(3, 5);
    private final int ESPACE_MINIMUM_SALLE_X = 4;
    private final int ESPACE_MINIMUM_SALLE_Y = 5;
    private final int ESPACE_MAXIMUM_SALLE_X = 10;
    private final int ESPACE_MAXIMUM_SALLE_Y = 12;
    private ArrayList<Salle> listOfSalle = new ArrayList<Salle>();
    private ArrayList <EntiteAbstrait> listeEntite = new ArrayList<EntiteAbstrait>();
    private ArrayList <Joueur> listeJoueur = new ArrayList<Joueur>();

    public Grille(){
        for (int i = 0 ; i < getLength(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                grille[i][j] = EMPTYSTRING;
            }
        }
    }

    public void addPoint(Pos pos){
        grille[pos.getY()][pos.getX()] = "* ";
    }

    public void addSalle(Salle salle){
        listOfSalle.add(salle);
        Pos pos = new Pos(0, 0);
        for (int i=0; i<salle.getSalleWidth(); i++){
            for (int j=0; j<salle.getSalleLenght(); j++){
                pos.setPos(salle.getPos().getX() + i, salle.getPos().getY() + j);
                addPoint(pos);
            }
        }
    }

    public void initialiseSalle(Grille grille) {
        int salleGenere = 0;
        while (salleGenere<nombreSalle){
            Salle salle = generateSalles(grille);
            if (grille.isEnoughFar(salle, salle.getPos())){
                grille.addSalle(salle);
                salleGenere++;
            }
        }
    }

    public Salle generateSalles(Grille grille) {
        int salleLenght =(int) (ESPACE_MINIMUM_SALLE_Y + Math.random() * (ESPACE_MAXIMUM_SALLE_Y - ESPACE_MINIMUM_SALLE_Y));
        int salleWidth = (int) (ESPACE_MINIMUM_SALLE_X + Math.random() * (ESPACE_MAXIMUM_SALLE_X - ESPACE_MINIMUM_SALLE_X));
        int randoms[] = new int[2];
        while (true){
            int y = (int) ((Math.random() * grille.getLength()) - salleWidth);
            int x = (int) ((Math.random() * grille.getWidth()) - salleWidth);
            if (x >= 0 && y >= 0){
                randoms[0] = x;
                randoms[1] = y;
                break;
            }
        }
        Salle salle = new Salle(salleLenght, salleWidth, new Pos(randoms[0], randoms[1]));
        /*System.out.println("longeur: " + salleLenght + "\tlargeur: " + salleWidth);
        System.out.println(randoms[0]);
        System.out.println(randoms[1]);*/
        return salle;
    }

    public boolean isEnoughFar(Salle salle, Pos pos) {
        try {
            for (int i = pos.getX()-ESPACE_MINIMUM_ENTRE_SALLE;
                 i < salle.getSalleWidth()+ESPACE_MINIMUM_ENTRE_SALLE+ pos.getX();
                 i++)
            {
                for (int j = pos.getY() -ESPACE_MINIMUM_ENTRE_SALLE;
                     j < salle.getSalleLenght()+ESPACE_MINIMUM_ENTRE_SALLE+ pos.getY();
                     j++)
                {
                    if(isInSalle(new Pos(i, j))) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String[][] getGrille() {
        return grille;
    }

    public ArrayList getListOfSalle() {
        return listOfSalle;
    }

    public String getSymbolAtCoord(Pos pos) {
        return grille[pos.getX()][pos.getY()];
    }

    public int getLength() {
        return Length;
    }

    public int getWidth() {
        return width;
    }

    public String getSymbolSalle(){
        return "* ";
    }

    public String getSymbolGrille() {
        return EMPTYSTRING;
    }
    public boolean isInSalle(Pos pos) { return grille[pos.getY()][pos.getX()].equals(getSymbolSalle()); }

    public void addJoueurList(Joueur joueur)
    {
        listeJoueur.add(joueur);
    }

    /*public void linkSalle(Grille grille){
        ArrayList<Salle> listofSalle = getListOfSalle();
        int size = listofSalle.size();
        Union union = new Union(size);
        while(union.components() > 1){
            int i = union.components() - 2;
            int j = union.components() - 1;
            if (union.find(i) == union.find(j)){
                return;
            } else {
                union.unify(i, j);
            }
        }
    } */

    public void addEntite(EntiteAbstrait entite) {
        grille[entite.getPos().getY()][entite.getPos().getX()] = entite.getSymbole();
        listeEntite.add(entite);
        entite.addSpecificEntiteList(this);
    }

    public void relierSalle(Grille grille) {
        ArrayList<Salle> listeSalle = getListOfSalle();
        Couloir[] tabCouloir = new Couloir[listeSalle.size()];
        int cpt = 0;
        for (Salle salle : listeSalle)
        {
            int salleAleatoire = (int) (Math.random() * listeSalle.size());
            Salle salle2 = listeSalle.get(salleAleatoire);
            while(salle2.equals(salle))
            {
                salleAleatoire = (int) (Math.random() * listeSalle.size());
                salle2 = listeSalle.get(salleAleatoire);
            }
            tabCouloir[cpt] = new Couloir(salle,salle2);
            cpt++;

        }
        for (Couloir couloir : tabCouloir)
        {
            ajoutCouloirGrille(couloir,grille);
        }
    }

    private void ajoutCouloirGrille(Couloir couloir,Grille grille) {
        String symboleCouloir = couloir.getSYMBOLE();
        int[] salle1Coord = couloir.getCoordDepart();
        int[] salle2Coord = couloir.getCoordArrive();

        int salle1X = salle1Coord[0];
        int salle1Y = salle1Coord[1];

        int salle2X = salle2Coord[0];
        int salle2Y = salle2Coord[1];

        // choix de relier vers le haut si 0, relier vers le côté si 1
        int choixDepart=(int) (Math.random() * 2);

        if(choixDepart==0) {
            if(salle1X<salle2X) {
                for(int i = salle1X; i < salle2X;i++) {
                    if(! grille.isInSalle(new Pos(i,salle1Y))) {
                        grille.getGrille()[salle1Y][i]= symboleCouloir;
                    }
                }
            }
            else if (salle1X> salle2X)
            {
                for(int i = salle1X; i > salle2X;i--)
                {
                    if(! grille.isInSalle(new Pos(i,salle1Y)))
                    {

                        grille.getGrille()[salle1Y][i]= symboleCouloir;
                    }
                }
            }

            if(salle1Y < salle2Y)
            {
                for(int i = salle1Y; i < salle2Y;i++)
                {
                    if(! grille.isInSalle(new Pos(salle2X,i)))
                    {

                        grille.getGrille()[i][salle2X]= symboleCouloir;
                    }
                    else
                    {

                    }

                }
            }
            else if(salle1Y > salle2Y)
            {
                for(int i = salle1Y; i > salle2Y;i--)
                {
                    if(! grille.isInSalle(new Pos(salle2X,i)))
                    {
                        grille.getGrille()[i][salle2X]= symboleCouloir;
                    }
                }
            }

        }
        else
        {
            if(salle1Y < salle2Y)
            {
                for(int i = salle1Y; i < salle2Y;i++)
                {
                    if(! grille.isInSalle(new Pos(salle1X,i)))
                    {
                        grille.getGrille()[i][salle1X]= symboleCouloir;
                    }
                }
            }
            else if(salle1Y > salle2Y)
            {
                for(int i = salle1Y; i > salle2Y;i--)
                {
                    if(! grille.isInSalle(new Pos(salle1X,i)))
                    {
                        grille.getGrille()[i][salle1X]= symboleCouloir;
                    }
                }
            }
            if(salle1X<salle2X)
            {
                for(int i = salle1X; i < salle2X;i++)
                {
                    if(! grille.isInSalle(new Pos(i,salle2Y)))
                    {
                        grille.getGrille()[salle2Y][i]= symboleCouloir;
                    }
                }
            }
            else if (salle1X> salle2X)
            {
                for(int i = salle1X; i > salle2X;i--)
                {
                    if(! grille.isInSalle(new Pos(i,salle2Y)))
                    {
                        grille.getGrille()[salle2Y][i]= symboleCouloir;
                    }
                }
            }
        }

    }
}
