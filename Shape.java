import java.awt.Graphics2D;

/**
 * Write a description of class Shape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shape
{
    private Line[] lines;
    
    public Shape(Line[] lines) {
        this.lines = lines;
    }
    
    public void draw(Graphics2D g2) {
        for(Line l : lines)
            l.draw(g2);
    }
    
    public void transform(double[] transformationMatrix) {
        for(Line l : lines) {
            l.transform(transformationMatrix);
        }
    }
}
