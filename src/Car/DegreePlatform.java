package Car;

public class DegreePlatform extends Car implements Movable{

    public DegreePlatform(int nr, int power, double x, double y, boolean stored, String model) {
        super(nr, power, x, y, stored, model);
    }

    private final int maxAngle = 70;
    private final int minAngle = 0;

    private double platformAngle; // For vehicles with adjustable platform
    public double getPlatformPosition() { // Getter for platform angle
        return platformAngle;
    }
    public void setPlatformPosition(double angle) { this.platformAngle = angle; }
    public boolean cannotMove(){
        return getPlatformPosition() < maxAngle;
    }
    public void platformUp(double amount) {
        if (getCurrentSpeed() == 0) {
            double newAngle = Math.min(getPlatformPosition() + amount, maxAngle);
            setPlatformPosition(newAngle);
        }
    }
    // Takes angle degrees and lowers the platform with said degrees
    public void platformDown(double amount) {
        if (getCurrentSpeed() == 0) {
            double newAngle = Math.max(getPlatformPosition() - Math.abs(amount), minAngle);
            setPlatformPosition(newAngle);
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
