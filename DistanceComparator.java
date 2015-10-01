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
        return (int)s2.getZ() - (int)s1.getZ();
    }
}
