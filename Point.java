
/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point
{
    private double x, y, z, s, zScaler;

    public Point(double x, double y, double z, double s) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.s = s;
        zScaler = (600 - z * (600 / (2000 + z))) / 600;
    }

    public void transform(double[] transformationMatrix) {
        x = x * transformationMatrix[0] + y * transformationMatrix[1] + z * transformationMatrix[2] + s * transformationMatrix[3] + transformationMatrix[12];
        y = x * transformationMatrix[4] + y * transformationMatrix[5] + z * transformationMatrix[6] + s * transformationMatrix[7] + transformationMatrix[13];
        z = x * transformationMatrix[8] + y * transformationMatrix[9] + z * transformationMatrix[10] + s * transformationMatrix[11]  + transformationMatrix[14];
        //s = s * transformationMatrix[12] + y * transformationMatrix[13] + z * transformationMatrix[14] + s * transformationMatrix[15];
        zScaler = (600 - z * (600 / (2000 + z))) / 600;
    }

    public double get2Dx() {
        return s * x * zScaler;
    }

    public double get2Dy() {
        return s * y * zScaler;
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
