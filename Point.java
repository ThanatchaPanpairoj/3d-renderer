import java.awt.Toolkit;
/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point
{
    private double x, y, z, s, xDepthScale, yDepthScale;
    private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth(), HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight(), halfWidth = WIDTH / 2, halfHeight = HEIGHT / 2;

    public Point(double x, double y, double z, double s) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s = s;
        xDepthScale = (halfWidth - z * (halfWidth / (2 * WIDTH + z))) / halfWidth;
        yDepthScale = (halfHeight - z * (halfHeight / (2 * WIDTH + z))) / halfHeight;
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
        xDepthScale = (halfWidth - z * (halfWidth / (2 * WIDTH + z))) / halfWidth;
        yDepthScale = (halfHeight - z * (halfHeight / (2 * WIDTH + z))) / halfHeight;
    }

    public double get2Dx() {
        return s * x * xDepthScale;
    }

    public double get2Dy() {
        return s * y * yDepthScale;
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
