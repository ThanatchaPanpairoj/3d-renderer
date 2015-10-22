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
    private int twoDX, twoDY;
    private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;

    public Point(double x, double y, double z, double s) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s = s;
        depthScale = s * WIDTH / (20 + z);
        twoDX = (int)(depthScale * x);
        twoDY = (int)(depthScale * y);
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
        depthScale = s * WIDTH / (20 + z);
        twoDX = (int)(depthScale * x);
        twoDY = (int)(depthScale * y);
    }

    public int get2Dx() {
        return twoDX;
    }

    public int get2Dy() {
        return twoDY;
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
