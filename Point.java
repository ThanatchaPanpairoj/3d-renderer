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
    private static final int WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(), halfWidth = WIDTH / 2, halfHeight = HEIGHT / 2;

    public Point(double x, double y, double z, double s) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s = s;
        xDepthScale = (halfWidth - z * (halfWidth / (2 * WIDTH + z))) / halfWidth;
        yDepthScale = (halfHeight - z * (halfHeight / (2 * WIDTH + z))) / halfHeight;
    }

    public void transform(double[] transformationMatrix) {
        x = x * transformationMatrix[0] + y * transformationMatrix[1] + z * transformationMatrix[2] + s * transformationMatrix[3] + transformationMatrix[12];
        y = x * transformationMatrix[4] + y * transformationMatrix[5] + z * transformationMatrix[6] + s * transformationMatrix[7] + transformationMatrix[13];
        z = x * transformationMatrix[8] + y * transformationMatrix[9] + z * transformationMatrix[10] + s * transformationMatrix[11]  + transformationMatrix[14];
        //s = s * transformationMatrix[12] + y * transformationMatrix[13] + z * transformationMatrix[14] + s * transformationMatrix[15];
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
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
