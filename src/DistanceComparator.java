import java.util.Comparator;

/**
 * Write a description of class DistanceComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceComparator implements Comparator<Shape>
{
    public int compare(Shape s1, Shape s2) {
        return (int)Math.sqrt(Math.pow(s2.getX(), 2) + Math.pow(s2.getY(), 2) + Math.pow(s2.getZ() + 10, 2))
        - (int)Math.sqrt(Math.pow(s1.getX(), 2) + Math.pow(s1.getY(), 2) + Math.pow(s1.getZ() + 10, 2));
    }
}
