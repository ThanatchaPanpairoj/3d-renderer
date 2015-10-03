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
    private Line[] lines;
    private Point[] points;
    private ArrayList<Face> faces;
    private double radius, x, y, z;

    public Cube(double radius, double x, double y, double z) {
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

        lines = new Line[12];
        lines[0] = new Line(points[0], points[1]); 
        lines[1] = new Line(points[1], points[2]); 
        lines[2] = new Line(points[2], points[3]); 
        lines[3] = new Line(points[0], points[3]); 
        lines[4] = new Line(points[5], points[4]); 
        lines[5] = new Line(points[6], points[5]); 
        lines[6] = new Line(points[7], points[6]); 
        lines[7] = new Line(points[7], points[4]); 
        lines[8] = new Line(points[1], points[5]); 
        lines[9] = new Line(points[2], points[6]); 
        lines[10] = new Line(points[3], points[7]); 
        lines[11] = new Line(points[0], points[4]);

        faces = new ArrayList<Face>();
        faces.add(new Face(new Point(x, y, z - radius, 1), Color.BLUE, lines[0], lines[1], lines[2], lines[3]));

        faces.add(new Face(new Point(x + radius, y, z, 1), Color.GREEN, lines[0], lines[8], lines[4], lines[11]));

        faces.add(new Face(new Point(x, y - radius, z, 1), Color.RED, lines[1], lines[9], lines[5], lines[8]));

        faces.add(new Face(new Point(x - radius, y, z, 1), Color.YELLOW, lines[2], lines[10], lines[6], lines[9]));

        faces.add(new Face(new Point(x, y + radius, z, 1), Color.CYAN, lines[3], lines[10], lines[7], lines[11]));

        faces.add(new Face(new Point(x, y, z + radius, 1), Color.ORANGE, lines[6], lines[5], lines[4], lines[7]));

    }

    public Cube(Color c, double radius, double x, double y, double z) {
        this(radius, x, y, z);
        for(Face f : faces) {
            f.setColor(c);
        }
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
            for(int i = 0; i < 6; i++) {
                faces.get(i).draw(g2);
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
            f.getCenter().transform(transformationMatrix);
        }

        double newX = x * transformationMatrix[0] + y * transformationMatrix[1] + z * transformationMatrix[2] + transformationMatrix[3];
        double newY = x * transformationMatrix[4] + y * transformationMatrix[5] + z * transformationMatrix[6] + transformationMatrix[7];
        double newZ = x * transformationMatrix[8] + y * transformationMatrix[9] + z * transformationMatrix[10] + transformationMatrix[11];
        x = newX;
        y = newY;
        z = newZ;
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
