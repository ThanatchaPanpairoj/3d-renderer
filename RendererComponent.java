import java.lang.Double;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * Basic GUI component GUITemplateComponent
 * 
 * @author Thanatcha Panpairoj
 * @version (a version number or a date)
 */
public class RendererComponent extends JComponent
{
    private int width, height;
    private ArrayList<Shape> shapes;
    private ArrayList<Line> grid;

    public RendererComponent(int width, int height) {
        this.width = width;
        this.height = height;

        shapes = new ArrayList<Shape>();
        shapes.add(new Shape(0, 0, 400, new Point[] {
                                          new Point(200, 200, 200, 1),
                                          new Point(200, -200, 200, 1),
                                          new Point(-200, -200, 200, 1),
                                          new Point(-200, 200, 200, 1),
                                          new Point(200, 200, 600, 1),
                                          new Point(200, -200, 600, 1),
                                          new Point(-200, -200, 600, 1),
                                          new Point(-200, 200, 600, 1)}));
                                          
        grid = new ArrayList<Line>();

        for(int w = -10000; w <= 10000; w += 200) {
            grid.add(new Line(new Point(w, height, -10000, 1), new Point(w, height, 10000, 1)));
            grid.add(new Line(new Point(-10000, height, w, 1), new Point(10000, height, w, 1)));
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.translate(width / 2, height / 2);
        g2.setColor(Color.BLACK);
        
        g2.drawString("ESC to exit", -width / 2 + 5, - height / 2 + 17);

        for(Line l : grid) {
            l.draw(g2);
        }


        for(Shape s : shapes) {
            s.draw(g2);
            double xShift = s.getX();
            double yShift = s.getY();
            double zShift = s.getZ();
            
            s.transform(new double[] {1, 0, 0, -xShift, 
                                      0, 1, 0, -yShift, 
                                      0, 0, 1, -zShift, 
                                      0, 0, 0,         1});
                                      
            double xSpinAngle = 0.016;
            s.transform(new double[] {1,                     0,                    0, 0, 
                                      0,  Math.cos(xSpinAngle), Math.sin(xSpinAngle), 0, 
                                      0, -Math.sin(xSpinAngle), Math.cos(xSpinAngle), 0, 
                                      0,                     0,                    0, 1});
                             
            double ySpinAngle = 0.008;
            s.transform(new double[] {Math.cos(ySpinAngle), 0, Math.sin(ySpinAngle), 0,
                                                         0, 1,                    0, 0, 
                                     -Math.sin(ySpinAngle), 0, Math.cos(ySpinAngle), 0, 
                                                         0, 0,                    0, 1});
                                                         
            double zSpinAngle = 0.02;
            s.transform(new double[] {Math.cos(zSpinAngle), Math.sin(zSpinAngle), 0, 0, 
                                     -Math.sin(zSpinAngle), Math.cos(zSpinAngle), 0, 0, 
                                                         0,                    0, 1, 0,
                                                         0,                    0, 0, 1});
                                      
            s.transform(new double[] {1, 0, 0, xShift,
                                      0, 1, 0, yShift, 
                                      0, 0, 1, zShift, 
                                      0, 0, 0,        1});                  
        }
    }
    
    public void transform(double[] transformationMatrix) {
        for(Line l : grid) {
            l.transform(transformationMatrix);
        }
        
        for(Shape s : shapes) {
            s.transform(transformationMatrix);
        }
    }

    public void updateMouse(double mouseX, double mouseY) {
        //
    }

    public void click() {
        //
    }
}
