package Car;

public class DegreePlatform{
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
        double newAngle = Math.min(getPlatformPosition() + amount, maxAngle);
        setPlatformPosition(newAngle);
    }
    public void platformDown(double amount) {
        double newAngle = Math.max(getPlatformPosition() - Math.abs(amount), minAngle);
        setPlatformPosition(newAngle);
    }

}
