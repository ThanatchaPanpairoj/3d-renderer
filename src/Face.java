import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Color;

/**
 * Write a description of class Face here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Face
{
    private int distance, lightingScale, red, green, blue;
    private double lightingScaleConstant;
    private Point p1, p2, p3, normal;

    public Face(Point p1, Point p2, Point p3, int red, int green, int blue) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.red = red;
        this.green = green;
        this.blue = blue;
        double a1 = p2.getX() - p1.getX();
        double a2 = p2.getY() - p1.getY();
        double a3 = p2.getZ() - p1.getZ();
        double b1 = p3.getX() - p2.getX();
        double b2 = p3.getY() - p2.getY();
        double b3 = p3.getZ() - p2.getZ();
        normal = new Point(a2*b3-a3*b2,a3*b1-a1*b3,a1*b2-a2*b1, 1);
        lightingScaleConstant = 25 / (double)(Math.sqrt(Math.pow(normal.getX(), 2) + Math.pow(normal.getY(), 2) + Math.pow(normal.getZ(), 2))); 
        distance = (int)(p1.getZ() + p2.getZ() + p3.getZ()); 
    }

    public void draw(Graphics2D g2) {
        if((p2.getX() * normal.getX() + p2.getY() * normal.getY() + p2.getZ() * normal.getZ()) < 0) {
            g2.setColor(new Color(red + lightingScale, green + lightingScale, blue + lightingScale));
            g2.fillPolygon(new Polygon(new int[] {p1.get2Dx(), p2.get2Dx(), p3.get2Dx()}, 
                    new int[] {p1.get2Dy(), p2.get2Dy(), p3.get2Dy()}, 3));
            distance = (int)(p1.getZ() + p2.getZ() + p3.getZ());
        } else {
            distance = 999; 
        }
    }

    public void transform(double[] transformationMatrix) {
        normal.transform(transformationMatrix);
    }

    public void calculateNewlightingScale(double lightX, double lightY, double lightZ) {
        lightingScale = (int)((lightX * normal.getX() + lightY * normal.getY() + lightZ * normal.getZ()) * lightingScaleConstant);
    }
    
    public int getDistance() {
        return distance;
    }
}
