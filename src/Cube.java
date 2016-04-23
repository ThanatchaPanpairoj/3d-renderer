import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Shape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube extends Shape
{
    private Point[] points;
    private ArrayList<Face> faces;
    private double radius, x, y, z;

    public Cube(double radius, double x, double y, double z, int red, int green, int blue) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;

        this.points = new Point[] {
            new Point(x + radius, y + radius, z - radius, 1),
            new Point(x + radius, y - radius, z - radius, 1),
            new Point(x - radius, y - radius, z - radius, 1),
            new Point(x - radius, y + radius, z - radius, 1),
            new Point(x + radius, y + radius, z + radius, 1),
            new Point(x + radius, y - radius, z + radius, 1),
            new Point(x - radius, y - radius, z + radius, 1),
            new Point(x - radius, y + radius, z + radius, 1)};

        faces = new ArrayList<Face>();
        faces.add(new Face(points[0], points[1], points[2], red, green, blue));
        faces.add(new Face(points[3], points[0], points[2], red, green, blue));
        faces.add(new Face(points[4], points[5], points[1], red, green, blue));
        faces.add(new Face(points[0], points[4], points[1], red, green, blue));
        faces.add(new Face(points[7], points[2], points[6], red, green, blue));
        faces.add(new Face(points[7], points[3], points[2], red, green, blue));
        faces.add(new Face(points[1], points[5], points[6], red, green, blue));
        faces.add(new Face(points[2], points[1], points[6], red, green, blue));
        faces.add(new Face(points[0], points[3], points[7], red, green, blue));
        faces.add(new Face(points[4], points[0], points[7], red, green, blue));
        faces.add(new Face(points[6], points[5], points[4], red, green, blue));
        faces.add(new Face(points[7], points[6], points[4], red, green, blue));
    }

    public void draw(Graphics2D g2) {
        boolean draw = false;
        for(Point p : points) {
            if(p.getZ() > 0) {
                draw = true;
                break;
            }
        }

        if(draw) {   
            faces.sort(new FaceDistanceComparator());
            for(Face f : faces) {
                f.draw(g2);
            }

            //             for(Point p : points) {
            //                 g2.drawString((int)p.getX() + "," + (int)p.getY() + "," + (int)p.getZ(), (int)p.get2Dx(), (int)p.get2Dy());
            //             }
            //             for(int i = 0; i < 8; i++) {
            //                 g2.drawString("" + i, (int)points[i].get2Dx(), (int)points[i].get2Dy());
            //             }
            //g2.drawString("" + Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)), (int)(new Point(x, y, z, 1).get2Dx()), (int)(new Point(x, y, z, 1).get2Dy()));
        }
    }

    public void transform(double[] transformationMatrix) {
        for(Point p : points) {
            p.transform(transformationMatrix);
        }

        for(Face f : faces) {
            f.transform(transformationMatrix);
        }

        double newX = x * transformationMatrix[0] + y * transformationMatrix[1] + z * transformationMatrix[2] + transformationMatrix[3];
        double newY = x * transformationMatrix[4] + y * transformationMatrix[5] + z * transformationMatrix[6] + transformationMatrix[7];
        double newZ = x * transformationMatrix[8] + y * transformationMatrix[9] + z * transformationMatrix[10] + transformationMatrix[11];
        x = newX;
        y = newY;
        z = newZ;
    }

    public void calculateNewlightingScale(double lightX, double lightY, double lightZ) {
        for(Face f : faces)
            f.calculateNewlightingScale(lightX, lightY, lightZ);
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

    public double getR() {
        return radius;
    }
}
