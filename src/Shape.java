import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Abstract class Shape - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Shape
{
    public abstract void draw(Graphics2D g2); 

    public abstract void transform(double[] transformationMatrix);
    
    public abstract void setColor(Color c);

    public abstract double getX();

    public abstract double getY();

    public abstract double getZ();
    
    public abstract double getR();
}
