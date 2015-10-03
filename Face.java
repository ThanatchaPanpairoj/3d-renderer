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
    private Polygon poly;
    private Point center;
    private Color color;
    private Line l1, l2, l3, l4;

    public Face(Point center, Color c, Line l1, Line l2, Line l3, Line l4) {
        this.center = center;
        this.color = c;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
    }

    public void draw(Graphics2D g2) {
        poly = new Polygon(new int[] {(int)l1.getPointOne().get2Dx(), 
                (int)l1.getPointTwo().get2Dx(), 
                (int)l2.getPointOne().get2Dx(), 
                (int)l2.getPointTwo().get2Dx(), 
                (int)l3.getPointOne().get2Dx(), 
                (int)l3.getPointTwo().get2Dx(), 
                (int)l4.getPointTwo().get2Dx(), 
                (int)l4.getPointOne().get2Dx(),},
            new int[] {(int)l1.getPointOne().get2Dy(), 
                (int)l1.getPointTwo().get2Dy(), 
                (int)l2.getPointOne().get2Dy(), 
                (int)l2.getPointTwo().get2Dy(), 
                (int)l3.getPointOne().get2Dy(), 
                (int)l3.getPointTwo().get2Dy(), 
                (int)l4.getPointTwo().get2Dy(), 
                (int)l4.getPointOne().get2Dy(),},
            8);

        g2.setColor(color);
        g2.fillPolygon(poly);
        g2.setColor(Color.BLACK);
        l1.draw(g2);
        l2.draw(g2);
        l3.draw(g2);
        l4.draw(g2);

        //g2.drawString((int)getCenter().getX() + "," + (int)getCenter().getY() + "," + (int)getCenter().getZ(), (int)getCenter().get2Dx(), (int)getCenter().get2Dy());
    }

    public void setColor(Color c) {
        color = c;
    }

    public Point getCenter() {
        return center;
    }

    public Polygon getPolygon() {
        return poly;
    }
}
