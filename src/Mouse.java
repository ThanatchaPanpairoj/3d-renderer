
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Shape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Shape
{
    private ArrayList<Shape> shapes;
    private Shape body, leftEar, rightEar, innerLeftEar, innerRightEar, nose1, nose2, nose3, nose4, leftEye1, rightEye1, leftEye2, rightEye2;
    private double radius, x, y, z;

    public Mouse(double radius, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        shapes = new ArrayList<Shape>();

        shapes.add(body = new Cube(Color.BLACK, 0.6 * radius, x, y + 0.4 * radius, z + 0.4 * radius));
        shapes.add(leftEar = new Cube(Color.WHITE, 0.3 * radius, x - 0.7 * radius, y - 0.3 * radius, z + 0.1 * radius));
        shapes.add(rightEar = new Cube(Color.WHITE, 0.3 * radius, x + 0.7 * radius, y - 0.3 * radius, z + 0.1 * radius));
        shapes.add(innerLeftEar = new Cube(Color.BLACK, 0.15 * radius, x - 0.7 * radius, y - 0.3 * radius, z - 0.05 * radius - 1));
        shapes.add(innerRightEar = new Cube(Color.BLACK, 0.15 * radius, x + 0.7 * radius, y - 0.3 * radius, z - 0.05 * radius - 1));
        shapes.add(nose1 = new Cube(Color.GRAY, 0.2 * radius, x, y + 0.6 * radius, z - 0.2 * radius));
        shapes.add(nose2 = new Cube(Color.GRAY, 0.1 * radius, x, y + 0.6 * radius, z - 0.4 * radius));
        shapes.add(nose3 = new Cube(Color.GRAY, 0.05 * radius, x, y + 0.6 * radius, z - 0.5 * radius));
        shapes.add(nose4 = new Cube(Color.BLACK, 0.025 * radius, x, y + 0.6 * radius, z - 0.55 * radius));
        shapes.add(leftEye1 = new Cube(Color.BLUE, 0.1 * radius, x - 0.3 * radius, y + 0.1 * radius, z - 0.1 * radius - 1));
        shapes.add(rightEye1 = new Cube(Color.BLUE, 0.1 * radius, x + 0.3 * radius, y + 0.1 * radius, z - 0.1 * radius - 1));
        shapes.add(leftEye2 = new Cube(Color.BLACK, 0.05 * radius, x - 0.25 * radius, y + 0.15 * radius, z - 0.15 * radius - 2));
        shapes.add(rightEye2 = new Cube(Color.BLACK, 0.05 * radius, x + 0.25 * radius, y + 0.15 * radius, z - 0.15 * radius - 2));
        shapes.add(new Cube(Color.WHITE, 0.05 * radius, x - 0.25 * radius, y + 0.95 * radius, z - 0.25 * radius));
        shapes.add(new Cube(Color.WHITE, 0.05 * radius, x - 0.4 * radius, y + 0.95 * radius, z - 0.25 * radius));
        shapes.add(new Cube(Color.WHITE, 0.05 * radius, x - 0.55 * radius, y + 0.95 * radius, z - 0.25 * radius));
        shapes.add(new Cube(Color.WHITE, 0.05 * radius, x + 0.25 * radius, y + 0.95 * radius, z - 0.25 * radius));
        shapes.add(new Cube(Color.WHITE, 0.05 * radius, x + 0.4 * radius, y + 0.95 * radius, z - 0.25 * radius));
        shapes.add(new Cube(Color.WHITE, 0.05 * radius, x + 0.55 * radius, y + 0.95 * radius, z - 0.25 * radius));
    }

    public void draw(Graphics2D g2) {
        boolean draw = false;
        for(Shape s : shapes) {
            if(s.getZ() > 0) {
                draw = true;
                break;
            }
        }

        if(draw) {   
            shapes.sort(new DistanceComparator());
            for(int i = 0; i < shapes.size(); i++) {
                shapes.get(i).draw(g2);
            }
        }
    }

    public void transform(double[] transformationMatrix) {

        for(Shape s : shapes) {
            s.transform(transformationMatrix);
        }

        double newX = x * transformationMatrix[0] + y * transformationMatrix[1] + z * transformationMatrix[2] + transformationMatrix[3];
        double newY = x * transformationMatrix[4] + y * transformationMatrix[5] + z * transformationMatrix[6] + transformationMatrix[7];
        double newZ = x * transformationMatrix[8] + y * transformationMatrix[9] + z * transformationMatrix[10] + transformationMatrix[11];
        x = newX;
        y = newY;
        z = newZ;
    }

    public void setColor(Color c) {

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
        //         Face f = faces.get(5);
        //         
        //         return
    }
}
