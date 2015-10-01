import java.awt.Graphics2D;

/**
 * Abstract class Shape - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Shape
{
    public abstract void draw(Graphics2D g2);

    public abstract void fillSide(Graphics2D g2, int side); 

    public abstract void transform(double[] transformationMatrix);

    public abstract double getX();

    public abstract double getY();

    public abstract double getZ();
}
