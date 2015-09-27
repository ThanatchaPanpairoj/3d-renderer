
/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point
{
    private double x, y, z, zScaler;
    
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        zScaler = (600 - z * (600 / (1500 + z))) / 600;
    }
    
    public double get2Dx() {
        return x * zScaler;
    }
    
    public double get2Dy() {
        return y * zScaler;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getZ() {
        return z;
    }
}
