package Car;

import java.awt.*;

public class Scania extends Vehicle implements isHauler {
    private DegreePlatform degreePlatform;
    public Scania(double x, double y){
        super(2,300,x,y,false,"Scania");
        degreePlatform = new DegreePlatform();
        color = Color.white;
        stopEngine();
        degreePlatform.setPlatformPosition(70);
    }
    public boolean cannotMove() { return degreePlatform.cannotMove(); }
    public double getPlatformPosition(){
        return degreePlatform.getPlatformPosition();
    }
    public void setPlatformPosition(double delta){
        degreePlatform.setPlatformPosition(delta);
    }
    public void platformUp(double delta){
        if (getCurrentSpeed() == 0) {
            degreePlatform.platformUp(delta);
        }
    }
    public void platformDown(double delta){
        if (getCurrentSpeed() == 0) {
            degreePlatform.platformDown(delta);
        }
    }
    @Override
    public void move(){
        if (!cannotMove()){
            super.move();
        }
    }
    @Override
    public void turnLeft(){
        if (!cannotMove()) super.turnLeft();
    }
    @Override
    public void turnRight(){
        if (!cannotMove()) super.turnRight();
    }
}
