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
        shapes.add(new Shape(new Point[] {new Point(200, 200, 200, 1),
                                          new Point(200, -200, 200, 1),
                                          new Point(-200, -200, 200, 1),
                                          new Point(-200, 200, 200, 1),
                                          new Point(200, 200, 600, 1),
                                          new Point(200, -200, 600, 1),
                                          new Point(-200, -200, 600, 1),
                                          new Point(-200, 200, 600, 1)}));
                                          
        grid = new ArrayList<Line>();

        for(int w = -10000; w <= 10000; w += 200) {
            grid.add(new Line(new Point(w, height, 0, 1), new Point(w, height, 10000, 1)));
            if(w >= 0) {
                grid.add(new Line(new Point(-10000, height, w, 1), new Point(10000, height, w, 1)));
            }
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.translate(width / 2, height / 2);
        g2.setColor(Color.BLACK);

        for(Line l : grid) {
            l.draw(g2);
        }


        for(Shape s : shapes) {
            s.draw(g2);
            s.transform(new double[] {Math.cos(0.006), Math.sin(0.006), 0, 0, 
                                     -Math.sin(0.006), Math.cos(0.006), 0, 0, 
                                                    0,             0, 1, 0,
                                                    0,             0, 0, 1});
                                                    
            s.transform(new double[] {1, 0, 0,    0, 
                                      0, 1, 0,    0, 
                                      0, 0, 1, -400, 
                                      0, 0, 0,    1});
                                      
            s.transform(new double[] {Math.cos(0.004), 0, Math.sin(0.004), 0,
                                                   0, 1,              0, 0, 
                                     -Math.sin(0.004), 0, Math.cos(0.004), 0, 
                                                   0, 0,              0, 1});
                                                    
            s.transform(new double[] {1,               0,              0, 0, 
                                      0,  Math.cos(0.003), Math.sin(0.003), 0, 
                                      0, -Math.sin(0.003), Math.cos(0.003), 0, 
                                      0,               0,              0, 1});
                                      
            s.transform(new double[] {1, 0, 0,   0,
                                      0, 1, 0,   0, 
                                      0, 0, 1, 400, 
                                      0, 0, 0,   1});
        }
    }

    public void updateMouse(int mouseX, int mouseY) {
        //
    }

    public void click() {
        //
    }
}
