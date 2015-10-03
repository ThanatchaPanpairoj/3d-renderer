import java.util.Comparator;
import java.awt.Toolkit;

/**
 * Write a description of class FaceDistanceComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaceDistanceComparator implements Comparator<Face>
{
    private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    
    public int compare(Face f1, Face f2) {
        Point p1 = f1.getCenter();
        Point p2 = f2.getCenter();
        return (int)Math.sqrt(Math.pow(p2.getX(), 2) + Math.pow(p2.getY(), 2) + Math.pow(p2.getZ(), 2))
        - (int)Math.sqrt(Math.pow(p1.getX(), 2) + Math.pow(p1.getY(), 2) + Math.pow(p1.getZ(), 2));
    }
}
