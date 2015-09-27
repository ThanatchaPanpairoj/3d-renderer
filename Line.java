import java.awt.Graphics2D;
import java.awt.geom.Line2D.Double;

/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line
{
    private Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void draw(Graphics2D g2) {
        g2.draw(new Double(p1.get2Dx(), p1.get2Dy(), p2.get2Dx(), p2.get2Dy()));
        g2.drawString("" + (int)p1.getX() + "," + (int)p1.getY() + "," + (int)p1.getZ(), (int)p1.get2Dx(), (int)p1.get2Dy());
        g2.drawString("" + (int)p2.getX() + "," + (int)p2.getY() + "," + (int)p2.getZ(), (int)p2.get2Dx(), (int)p2.get2Dy());
    }

    public void transform(double[] transformationMatrix) {
        p1.transform(transformationMatrix);
        p2.transform(transformationMatrix);
    }

    public Point getPointOne() {
        return p1;
    }

    public Point getPointTwo() {
        return p2;
    }
}
