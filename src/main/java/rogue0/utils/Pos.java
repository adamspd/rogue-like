package rogue0.utils;

public class Pos {
    private int X;
    private int Y;

    public Pos(int posX, int posY){
        X = posX;
        Y = posY;
    }

    public int getX() {
        return X;
    }

    public void setX(int posX) {
        X = posX;
    }

    public int getY() {
        return Y;
    }

    public void setY(int posY) {
        Y = posY;
    }

    public void setPos(int posX, int posY){
        X = posX;
        Y = posY;
    }
}
