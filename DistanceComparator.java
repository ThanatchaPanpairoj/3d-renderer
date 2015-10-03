import java.util.Comparator;
import java.awt.Toolkit;

/**
 * Write a description of class DistanceComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceComparator implements Comparator<Shape>
{
    private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    
    public int compare(Shape s1, Shape s2) {
        return (int)s2.getDistance() - (int)s1.getDistance();
    }
}
