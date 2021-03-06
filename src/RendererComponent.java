import java.lang.Double;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    private int width, height, fps;
    private Point light;
    private ArrayList<Shape> shapes;
    private Shape firstCube;
    private ArrayList<Line> grid;

    public RendererComponent(int width, int height) {
        this.width = width;
        this.height = height;

        light = new Point(0, -1, 0, 1);

        shapes = new ArrayList<Shape>();
        shapes.add(firstCube = new Cube(200, 0, 0, 1000, 200, 200, 200));

//         shapes.add(new Cube(200, -3400, 600,  1800, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 600,  2200, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 600,  2600, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 600,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -3800, 600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4200, 600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4600, 600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 600,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 600, 2600, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 600, 2200, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 600, 1800, 230, 230, 230));
// 
//         shapes.add(new Cube(200, -3400, 200,  1800, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 200,  2200, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 200,  2600, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 200,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, 200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -3800, 200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4200, 200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4600, 200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 200,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 200, 2600, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 200, 2200, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, 200, 1800, 230, 230, 230));
// 
//         shapes.add(new Cube(200, -3400, -200,  1800, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -200,  2200, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -200,  2600, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -200,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -3800, -200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4200, -200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4600, -200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -200,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -200,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -200, 2600, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -200, 2200, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -200, 1800, 230, 230, 230));
// 
//         shapes.add(new Cube(200, -3400, -600,  1800, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -600,  2200, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -600,  2600, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -600,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -3400, -600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -3800, -600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4200, -600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -4600, -600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -600,  3400, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -600,  3000, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -600, 2600, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -600, 2200, 230, 230, 230));
//         shapes.add(new Cube(200, -5000, -600, 1800, 230, 230, 230));

        grid = new ArrayList<Line>();
        for(int w = -100000; w <= 100000; w += 400) {
            grid.add(new Line(new Point(w, 800, -100000, 1), new Point(w, 800, 100000, 1)));
            grid.add(new Line(new Point(-100000, 800, w, 1), new Point(100000, 800, w, 1)));
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.translate(width / 2, height / 2);

        g2.setColor(Color.GRAY);
        for(Line l : grid) {
            l.draw(g2);
        }

        shapes.sort(new DistanceComparator());

        for(Shape s : shapes) {
            s.calculateNewlightingScale(light.getX(), light.getY(), light.getZ());
            s.draw(g2);
            double xShift = s.getX();
            double yShift = s.getY();
            double zShift = s.getZ();

            if(false && s == firstCube) { 
                s.transform(new double[] {1, 0, 0, -xShift, 
                        0, 1, 0, -yShift, 
                        0, 0, 1, -zShift, 
                        0, 0, 0,         1});

                double xSpinAngle = 0.0016;
                s.transform(new double[] {1,                     0,                    0, 0, 
                        0,  Math.cos(xSpinAngle), Math.sin(xSpinAngle), 0, 
                        0, -Math.sin(xSpinAngle), Math.cos(xSpinAngle), 0, 
                        0,                     0,                    0, 1});

                double ySpinAngle = 0.0008;
                s.transform(new double[] {Math.cos(ySpinAngle), 0, Math.sin(ySpinAngle), 0,
                        0, 1,                    0, 0, 
                        -Math.sin(ySpinAngle), 0, Math.cos(ySpinAngle), 0, 
                        0, 0,                    0, 1});

                double zSpinAngle = 0.002;
                s.transform(new double[] {Math.cos(zSpinAngle), Math.sin(zSpinAngle), 0, 0, 
                        -Math.sin(zSpinAngle), Math.cos(zSpinAngle), 0, 0, 
                        0,                    0, 1, 0,
                        0,                    0, 0, 1});

                s.transform(new double[] {1, 0, 0, xShift,
                        0, 1, 0, yShift, 
                        0, 0, 1, zShift, 
                        0, 0, 0,        1});         
            } //else 
            //s.setColor(Color.WHITE);
        }

        g2.setColor(Color.BLACK);

        g2.drawString("WASD to move", -width / 2 + 5, - height / 2 + 17);
        g2.drawString("Mouse to turn", -width / 2 + 5, - height / 2 + 34);
        g2.drawString("ESC to exit", -width / 2 + 5, - height / 2 + 51);
        g2.drawString("FPS: " + fps, width / 2 - 60, - height / 2 + 17);
    }

    public void rotate(double[] transformationMatrix) {
        for(Line l : grid) {
            l.transform(transformationMatrix);
        }
        light.transform(transformationMatrix);
        for(Shape s : shapes) {
            s.transform(transformationMatrix);
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

    public void click() {
        //
    }

    public Shape getClosestShape() {
        //shapes.get(shapes.size() - 1).setColor(Color.BLACK);
        return shapes.get(shapes.size() - 1);
    }

    public Shape getSecondClosestShape() {
        //shapes.get(shapes.size() - 2).setColor(Color.BLACK);
        return shapes.get(shapes.size() - 2);
    }

    public Shape getThirdClosestShape() {
        //shapes.get(shapes.size() - 3).setColor(Color.BLACK);
        return shapes.get(shapes.size() - 3);
    }

    public void updateFPS(int fps) {
        this.fps = fps;
    }
}
