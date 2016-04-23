import java.util.Comparator;

/**
 * Write a description of class FaceDistanceComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaceDistanceComparator implements Comparator<Face>
{
    public int compare(Face f1, Face f2) {
        return f2.getDistance() - f1.getDistance();
    }
}
