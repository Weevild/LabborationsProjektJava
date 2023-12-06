package Car;

public class FixedPlatform extends Car{
    public FixedPlatform(int nr, int power, double x, double y, boolean stored, String model) {
        super(nr, power, x, y, stored, model);
    }

    private boolean FixedPlatformRetractedPosition; // For vehicles with a platform with only up/down positions, checks if platform is "down".
    public boolean getFixedPlatformPosition(){ return FixedPlatformRetractedPosition; } // Getter for platform position
    public void setFixedPlatformPosition(boolean position){ this.FixedPlatformRetractedPosition = position; } // Setter for platform position

    public boolean cannotMove() {
        return getFixedPlatformPosition();
    }

    // When called moves the vehicle if canMoveCheck conditions are met
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
