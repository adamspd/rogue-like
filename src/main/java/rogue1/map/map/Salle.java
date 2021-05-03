package rogue1.map.map;
import rogue0.utils.Pos;

public class Salle {
    private final String roomText = "* ";
    private final int salleLenght;
    private final int salleWidth;
    private Pos pos;

    public Salle(int roomLenght, int roomWitdth, Pos pos){
        this.salleWidth = roomWitdth;
        this.salleLenght = roomLenght;
        this.pos = pos;

    }

    public String getSalleText(){
        return roomText;
    }

    public int getSalleLenght(){
        return salleLenght;
    }

    public int getSalleWidth() {
        return salleWidth;
    }

    public Pos getPos() {
        return pos;
    }

    /**
     *
     * @return un tableau contenant les coordonnées du milieu de la salle
     */
    public int[] getMiddleSalle() {
        int tabPosMiddle[] = new int[2];
        tabPosMiddle[0] = (salleWidth / 2) + pos.getX();
        tabPosMiddle[1] = (salleLenght / 2) + pos.getY();
        return tabPosMiddle;
    }

}
