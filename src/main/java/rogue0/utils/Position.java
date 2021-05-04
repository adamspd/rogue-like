package rogue0.utils;

public class Position {
    private double X;
    private double Y;

    public Position(int posX, int posY){
        X = posX;
        Y = posY;
    }

    public Position(double x, double y) {
        this.X = x;
        this.Y = y;
    }

    /* S'appoche (ou s'éloigne si d < 0) de la position pos jusqu'à une distance minimal de 1. */
    public Position moveToward(Position pos, double distance) {
        double dx = X - pos.X;
        double dy = Y - pos.Y;
        double d = getDistance(pos);
        double moveDistance = (d < 1) ? 0 : Math.min(distance, d - 1);
        return new Position(dx / d * moveDistance, dy / d * moveDistance);
    }

    /* Retourne la distance entre le point courant et celui passé en paramètre. */
    public double getDistance(Position pos) {
        double dx = X - pos.X;
        double dy = Y - pos.Y;
        return Math.hypot(dx, dy);
    }

    public double getX() {
        return X;
    }

    public void setX(int posX) {
        X = posX;
    }

    public double getY() {
        return Y;
    }

    public void setY(int posY) {
        Y = posY;
    }

    public void setPos(int posX, int posY){
        X = posX;
        Y = posY;
    }

    public void setPos(double posX, double posY){
        X = posX;
        Y = posY;
    }

    public void setPos(Position pos) {
        X = pos.X;
        Y = pos.Y;
    }
}
