import java.awt.Toolkit;

/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point
{
    private double x, y, z, s, depthScale;
    private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    public Point(double x, double y, double z, double s) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s = s;
        depthScale = 20 / (20 + z);
    }

    public void transform(double[] transformationMatrix) {
        double newX = x * transformationMatrix[0] + y * transformationMatrix[1] + z * transformationMatrix[2] + s * transformationMatrix[3];
        double newY = x * transformationMatrix[4] + y * transformationMatrix[5] + z * transformationMatrix[6] + s * transformationMatrix[7];
        double newZ = x * transformationMatrix[8] + y * transformationMatrix[9] + z * transformationMatrix[10] + s * transformationMatrix[11];
        double newS = x * transformationMatrix[12] + y * transformationMatrix[13] + z * transformationMatrix[14] + s * transformationMatrix[15];
        x = newX;
        y = newY;
        z = newZ;
        s = newS;
        depthScale = 20 / (20 + z);
    }

    public double get2Dx() {
        return depthScale * WIDTH / 40 * s * x;
    }

    public double get2Dy() {
        return depthScale * WIDTH / 40 * s * y;
    }

    public double getX() {
        return s * x;
    }

    public double getY() {
        return s * y;
    }

    public double getZ() {
        return s * z;
    }
}
