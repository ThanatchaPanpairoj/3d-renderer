import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.BasicStroke;

/**
 * Write a description of class Shape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube extends Shape
{
    private Color c;
    private Line[] lines;
    private Point[] points;
    private Polygon p1, p2, p3, p4, p5, p6;
    private double radius, x, y, z;

    public Cube(double radius, double x, double y, double z) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
        this.points = new Point[] {
            new Point(x + radius, y + radius, z - radius, 1),
            new Point(x + radius, y - radius, z - radius, 1),
            new Point(x - radius, y - radius, z - radius, 1),
            new Point(x - radius, y + radius, z - radius, 1),
            new Point(x + radius, y + radius, z + radius, 1),
            new Point(x + radius, y - radius, z + radius, 1),
            new Point(x - radius, y - radius, z + radius, 1),
            new Point(x - radius, y + radius, z + radius, 1)};

        lines = new Line[12];
        lines[0] = new Line(points[0], points[1]); 
        lines[1] = new Line(points[1], points[2]); 
        lines[2] = new Line(points[2], points[3]); 
        lines[3] = new Line(points[3], points[0]); 
        lines[4] = new Line(points[4], points[5]); 
        lines[5] = new Line(points[5], points[6]); 
        lines[6] = new Line(points[6], points[7]); 
        lines[7] = new Line(points[7], points[4]); 
        lines[8] = new Line(points[0], points[4]); 
        lines[9] = new Line(points[1], points[5]); 
        lines[10] = new Line(points[2], points[6]); 
        lines[11] = new Line(points[3], points[7]);
    }

    public Cube(Color c, double radius, double x, double y, double z) {
        this(radius, x, y, z);
        this.c = c;
    }

    public void draw(Graphics2D g2) {
        boolean draw = false;
        for(Point p : points) {
            if(p.getZ() > 0) {
                draw = true;
                break;
            }
        }

        if(draw) {
            for(Line l : lines) {
                l.draw(g2);
            }

            p1 = new Polygon(new int[] {(int)lines[0].getPointOne().get2Dx(), 
                    (int)lines[0].getPointTwo().get2Dx(), 
                    (int)lines[1].getPointOne().get2Dx(), 
                    (int)lines[1].getPointTwo().get2Dx(), 
                    (int)lines[2].getPointOne().get2Dx(), 
                    (int)lines[2].getPointTwo().get2Dx(), 
                    (int)lines[3].getPointOne().get2Dx(), 
                    (int)lines[3].getPointTwo().get2Dx(),},
                new int[] {(int)lines[0].getPointOne().get2Dy(), 
                    (int)lines[0].getPointTwo().get2Dy(), 
                    (int)lines[1].getPointOne().get2Dy(), 
                    (int)lines[1].getPointTwo().get2Dy(), 
                    (int)lines[2].getPointOne().get2Dy(), 
                    (int)lines[2].getPointTwo().get2Dy(), 
                    (int)lines[3].getPointOne().get2Dy(), 
                    (int)lines[3].getPointTwo().get2Dy(),},
                8);

            p2 = new Polygon(new int[] {(int)lines[0].getPointOne().get2Dx(), 
                    (int)lines[0].getPointTwo().get2Dx(), 
                    (int)lines[9].getPointOne().get2Dx(), 
                    (int)lines[9].getPointTwo().get2Dx(), 
                    (int)lines[4].getPointTwo().get2Dx(), 
                    (int)lines[4].getPointOne().get2Dx(), 
                    (int)lines[8].getPointTwo().get2Dx(), 
                    (int)lines[8].getPointOne().get2Dx(),},
                new int[] {(int)lines[0].getPointOne().get2Dy(), 
                    (int)lines[0].getPointTwo().get2Dy(), 
                    (int)lines[9].getPointOne().get2Dy(), 
                    (int)lines[9].getPointTwo().get2Dy(), 
                    (int)lines[4].getPointTwo().get2Dy(), 
                    (int)lines[4].getPointOne().get2Dy(), 
                    (int)lines[8].getPointTwo().get2Dy(), 
                    (int)lines[8].getPointOne().get2Dy(),},
                8);

            p3 = new Polygon(new int[] {(int)lines[1].getPointOne().get2Dx(), 
                    (int)lines[1].getPointTwo().get2Dx(), 
                    (int)lines[10].getPointOne().get2Dx(), 
                    (int)lines[10].getPointTwo().get2Dx(), 
                    (int)lines[5].getPointTwo().get2Dx(), 
                    (int)lines[5].getPointOne().get2Dx(), 
                    (int)lines[9].getPointTwo().get2Dx(), 
                    (int)lines[9].getPointOne().get2Dx(),},
                new int[] {(int)lines[1].getPointOne().get2Dy(), 
                    (int)lines[1].getPointTwo().get2Dy(), 
                    (int)lines[10].getPointOne().get2Dy(), 
                    (int)lines[10].getPointTwo().get2Dy(), 
                    (int)lines[5].getPointTwo().get2Dy(), 
                    (int)lines[5].getPointOne().get2Dy(), 
                    (int)lines[9].getPointTwo().get2Dy(), 
                    (int)lines[9].getPointOne().get2Dy(),},
                8);

            p4 = new Polygon(new int[] {(int)lines[2].getPointOne().get2Dx(), 
                    (int)lines[2].getPointTwo().get2Dx(), 
                    (int)lines[11].getPointOne().get2Dx(), 
                    (int)lines[11].getPointTwo().get2Dx(), 
                    (int)lines[6].getPointTwo().get2Dx(), 
                    (int)lines[6].getPointOne().get2Dx(), 
                    (int)lines[10].getPointTwo().get2Dx(), 
                    (int)lines[10].getPointOne().get2Dx(),},
                new int[] {(int)lines[2].getPointOne().get2Dy(), 
                    (int)lines[2].getPointTwo().get2Dy(), 
                    (int)lines[11].getPointOne().get2Dy(), 
                    (int)lines[11].getPointTwo().get2Dy(), 
                    (int)lines[6].getPointTwo().get2Dy(), 
                    (int)lines[6].getPointOne().get2Dy(), 
                    (int)lines[10].getPointTwo().get2Dy(), 
                    (int)lines[10].getPointOne().get2Dy(),},
                8);

            p5 = new Polygon(new int[] {(int)lines[3].getPointOne().get2Dx(), 
                    (int)lines[3].getPointTwo().get2Dx(), 
                    (int)lines[8].getPointOne().get2Dx(), 
                    (int)lines[8].getPointTwo().get2Dx(), 
                    (int)lines[7].getPointTwo().get2Dx(), 
                    (int)lines[7].getPointOne().get2Dx(), 
                    (int)lines[11].getPointTwo().get2Dx(), 
                    (int)lines[11].getPointOne().get2Dx(),},
                new int[] {(int)lines[3].getPointOne().get2Dy(), 
                    (int)lines[3].getPointTwo().get2Dy(), 
                    (int)lines[8].getPointOne().get2Dy(), 
                    (int)lines[8].getPointTwo().get2Dy(), 
                    (int)lines[7].getPointTwo().get2Dy(), 
                    (int)lines[7].getPointOne().get2Dy(), 
                    (int)lines[11].getPointTwo().get2Dy(), 
                    (int)lines[11].getPointOne().get2Dy(),},
                8);

            p6 = new Polygon(new int[] {(int)lines[4].getPointOne().get2Dx(), 
                    (int)lines[4].getPointTwo().get2Dx(), 
                    (int)lines[5].getPointOne().get2Dx(), 
                    (int)lines[5].getPointTwo().get2Dx(), 
                    (int)lines[6].getPointOne().get2Dx(), 
                    (int)lines[6].getPointTwo().get2Dx(), 
                    (int)lines[7].getPointOne().get2Dx(), 
                    (int)lines[7].getPointTwo().get2Dx(),},
                new int[] {(int)lines[4].getPointOne().get2Dy(), 
                    (int)lines[4].getPointTwo().get2Dy(), 
                    (int)lines[5].getPointOne().get2Dy(), 
                    (int)lines[5].getPointTwo().get2Dy(), 
                    (int)lines[6].getPointOne().get2Dy(), 
                    (int)lines[6].getPointTwo().get2Dy(), 
                    (int)lines[7].getPointOne().get2Dy(), 
                    (int)lines[7].getPointTwo().get2Dy(),},
                8);

            double[] closestPoints = new double[6];
            closestPoints[0] = Math.min(Math.min(points[0].getZ(), points[1].getZ()), Math.min(points[2].getZ(), points[3].getZ()));
            closestPoints[1] = Math.min(Math.min(points[0].getZ(), points[1].getZ()), Math.min(points[5].getZ(), points[4].getZ()));
            closestPoints[2] = Math.min(Math.min(points[1].getZ(), points[2].getZ()), Math.min(points[6].getZ(), points[5].getZ()));
            closestPoints[3] = Math.min(Math.min(points[2].getZ(), points[3].getZ()), Math.min(points[7].getZ(), points[6].getZ()));
            closestPoints[4] = Math.min(Math.min(points[3].getZ(), points[0].getZ()), Math.min(points[4].getZ(), points[7].getZ()));
            closestPoints[5] = Math.min(Math.min(points[4].getZ(), points[5].getZ()), Math.min(points[6].getZ(), points[7].getZ()));

            double[] furtherestPoints = new double[6];
            furtherestPoints[0] = Math.max(Math.max(points[0].getZ(), points[1].getZ()), Math.max(points[2].getZ(), points[3].getZ()));
            furtherestPoints[1] = Math.max(Math.max(points[0].getZ(), points[1].getZ()), Math.max(points[5].getZ(), points[4].getZ()));
            furtherestPoints[2] = Math.max(Math.max(points[1].getZ(), points[2].getZ()), Math.max(points[6].getZ(), points[5].getZ()));
            furtherestPoints[3] = Math.max(Math.max(points[2].getZ(), points[3].getZ()), Math.max(points[7].getZ(), points[6].getZ()));
            furtherestPoints[4] = Math.max(Math.max(points[3].getZ(), points[0].getZ()), Math.max(points[4].getZ(), points[7].getZ()));
            furtherestPoints[5] = Math.max(Math.max(points[4].getZ(), points[5].getZ()), Math.max(points[6].getZ(), points[7].getZ()));

            int closestPointIndex = 0;
            int[] sortedClosestPointIndexes = new int[6];
            for(int i = 0, closestLineIndex = 0; i < 6; i++) {
                for(int j = 0; j < 6; j++) {
                    if(closestPoints[j] < closestPoints[closestPointIndex] - 0.01 || (closestPoints[j] - 0.01 < closestPoints[closestPointIndex] && furtherestPoints[j] < furtherestPoints[closestPointIndex])) {
                        closestPointIndex = j;
                    }
                }
                sortedClosestPointIndexes[i] = closestPointIndex;
                closestPoints[closestPointIndex] = 100000000;
                closestPointIndex = 0;
            }

            for(int i = 5; i > -1; i--) {
                fillSide(g2, sortedClosestPointIndexes[i]);
            }
        }
    }

    public void fillSide(Graphics2D g2, int side) {
        if(side == 0) {
            g2.setColor(c != null ? c : Color.BLUE);
            g2.fillPolygon(p1);
            g2.setColor(Color.BLACK);
            lines[0].draw(g2);
            lines[1].draw(g2);
            lines[2].draw(g2);
            lines[3].draw(g2);
        } else if(side == 1) {
            g2.setColor(c != null ? c : Color.GREEN);
            g2.fillPolygon(p2);
            g2.setColor(Color.BLACK);
            lines[0].draw(g2);
            lines[9].draw(g2);
            lines[4].draw(g2);
            lines[8].draw(g2);
        } else if(side == 2) {
            g2.setColor(c != null ? c : Color.RED);
            g2.fillPolygon(p3);
            g2.setColor(Color.BLACK);
            lines[1].draw(g2);
            lines[10].draw(g2);
            lines[5].draw(g2);
            lines[9].draw(g2);
        } else if(side == 3) {
            g2.setColor(c != null ? c : Color.YELLOW);
            g2.fillPolygon(p4);
            g2.setColor(Color.BLACK);
            lines[2].draw(g2);
            lines[11].draw(g2);
            lines[6].draw(g2);
            lines[10].draw(g2);
        } else if(side == 4) {
            g2.setColor(c != null ? c : Color.CYAN);
            g2.fillPolygon(p5);
            g2.setColor(Color.BLACK);
            lines[3].draw(g2);
            lines[8].draw(g2);
            lines[7].draw(g2);
            lines[11].draw(g2);
        } else {
            g2.setColor(c != null ? c : Color.ORANGE);
            g2.fillPolygon(p6);
            g2.setColor(Color.BLACK);
            lines[4].draw(g2);
            lines[5].draw(g2);
            lines[6].draw(g2);
            lines[7].draw(g2);
        }
    } 

    public void transform(double[] transformationMatrix) {
        for(Point p : points) {
            p.transform(transformationMatrix);
        } 

        double newX = x * transformationMatrix[0] + y * transformationMatrix[1] + z * transformationMatrix[2] + transformationMatrix[3];
        double newY = x * transformationMatrix[4] + y * transformationMatrix[5] + z * transformationMatrix[6] + transformationMatrix[7];
        double newZ = x * transformationMatrix[8] + y * transformationMatrix[9] + z * transformationMatrix[10] + transformationMatrix[11];
        x = newX;
        y = newY;
        z = newZ;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    
    public double getR() {
        return radius;
    }
}
