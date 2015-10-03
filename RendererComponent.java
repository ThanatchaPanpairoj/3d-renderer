import java.lang.Double;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.BasicStroke;
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
    private Shape firstCube;
    private ArrayList<Line> grid;

    public RendererComponent(int width, int height) {
        this.width = width;
        this.height = height;

        shapes = new ArrayList<Shape>();
        shapes.add(firstCube = new Cube(200, 0, 0, 800));

        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 + 185,  1800));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 + 185,  2200));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 + 185,  2600));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 + 185,  3000));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 + 185,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -3800, height  / 2 + 185,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -4200, height  / 2 + 185,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -4600, height  / 2 + 185,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 + 185,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 + 185,  3000));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 + 185, 2600));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 + 185, 2200));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 + 185, 1800));

        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 215,  1800));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 215,  2200));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 215,  2600));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 215,  3000));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 215,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -3800, height  / 2 - 215,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -4200, height  / 2 - 215,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -4600, height  / 2 - 215,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 215,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 215,  3000));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 215, 2600));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 215, 2200));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 215, 1800));

        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 615,  1800));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 615,  2200));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 615,  2600));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 615,  3000));
        shapes.add(new Cube(Color.WHITE, 200, -3400, height  / 2 - 615,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -3800, height  / 2 - 615,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -4200, height  / 2 - 615,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -4600, height  / 2 - 615,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 615,  3400));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 615,  3000));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 615, 2600));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 615, 2200));
        shapes.add(new Cube(Color.WHITE, 200, -5000, height  / 2 - 615, 1800));

        grid = new ArrayList<Line>();
        for(int w = -100000; w <= 100000; w += 400) {
            grid.add(new Line(new Point(w, height, -100000, 1), new Point(w, height, 100000, 1)));
            grid.add(new Line(new Point(-100000, height, w, 1), new Point(100000, height, w, 1)));
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.translate(width / 2, height / 2);
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(1));

        g2.drawString("WASD to move", -width / 2 + 5, - height / 2 + 17);
        g2.drawString("Mouse to turn", -width / 2 + 5, - height / 2 + 34);
        g2.drawString("ESC to exit", -width / 2 + 5, - height / 2 + 51);

        for(Line l : grid) {
            l.draw(g2);
        }

        shapes.sort(new DistanceComparator());

        for(Shape s : shapes) {
            s.draw(g2);
            double xShift = s.getX();
            double yShift = s.getY();
            double zShift = s.getZ();

            if(s == firstCube) { 
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
       
    public Shape getClosestShape() {
        return shapes.get(shapes.size() - 1);
    }
}
