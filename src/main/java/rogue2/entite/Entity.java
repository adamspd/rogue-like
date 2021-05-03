package rogue2.entite;

import rogue0.utils.Pos;

public interface Entity {
    Pos getPostion();
    void setPosition(Pos position);
    int getLifePoint();
    void setLifePoint(int PV);
    double getMovement();
    int getDamage();
}
