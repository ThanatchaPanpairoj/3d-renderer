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
        poly = new Polygon(new int[] {l1.getPointOne().get2Dx(), 
                l1.getPointTwo().get2Dx(), 
                l2.getPointOne().get2Dx(), 
                l2.getPointTwo().get2Dx(), 
                l3.getPointOne().get2Dx(), 
                l3.getPointTwo().get2Dx(), 
                l4.getPointTwo().get2Dx(), 
                l4.getPointOne().get2Dx(),},
            new int[] {l1.getPointOne().get2Dy(), 
                l1.getPointTwo().get2Dy(), 
                l2.getPointOne().get2Dy(), 
                l2.getPointTwo().get2Dy(), 
                l3.getPointOne().get2Dy(), 
                l3.getPointTwo().get2Dy(), 
                l4.getPointTwo().get2Dy(), 
                l4.getPointOne().get2Dy(),},
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
//     
//     public getIntersection() {
//         Point p1 = l1.getPointOne();
//         Point p2 = l2.getPointOne();
//         Point p3 = l3.getPointOne();
//         Point p4 = l4.getPointTwo();
//         
//         double closestDistance = p1.getDistance();
//         Point closestPoint = p1;
//         for(int i = 2; i < 5; i++) {
//             if(
//         }
//     }
}
