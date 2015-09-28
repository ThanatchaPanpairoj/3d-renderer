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
public class Shape
{
    private Line[] lines;
    private Point[] points;
    private Polygon p1, p2, p3, p4, p5, p6;

    public Shape(Point[] points) {
        this.points = points;

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

    public void draw(Graphics2D g2) {
        for(Line l : lines) {
            l.draw(g2);
        }

        p1 = new Polygon(new int[] {(int)points[0].get2Dx(), (int)points[1].get2Dx(), (int)points[2].get2Dx(), (int)points[3].get2Dx()},
            new int[] {(int)points[0].get2Dy(), (int)points[1].get2Dy(), (int)points[2].get2Dy(), (int)points[3].get2Dy()},
            4);
        double closestPointOne = Math.min(Math.min(points[0].getZ(), points[1].getZ()), Math.min(points[2].getZ(), points[3].getZ()));
        double furtherestPointOne = Math.max(Math.max(points[0].getZ(), points[1].getZ()), Math.max(points[2].getZ(), points[3].getZ()));

        p2 = new Polygon(new int[] {(int)points[0].get2Dx(), (int)points[1].get2Dx(), (int)points[5].get2Dx(), (int)points[4].get2Dx()},
            new int[] {(int)points[0].get2Dy(), (int)points[1].get2Dy(), (int)points[5].get2Dy(), (int)points[4].get2Dy()},
            4);
        double closestPointTwo = Math.min(Math.min(points[0].getZ(), points[1].getZ()), Math.min(points[5].getZ(), points[4].getZ()));
        double furtherestPointTwo = Math.max(Math.max(points[0].getZ(), points[1].getZ()), Math.max(points[5].getZ(), points[4].getZ()));

        p3 = new Polygon(new int[] {(int)points[1].get2Dx(), (int)points[2].get2Dx(), (int)points[6].get2Dx(), (int)points[5].get2Dx()},
            new int[] {(int)points[1].get2Dy(), (int)points[2].get2Dy(), (int)points[6].get2Dy(), (int)points[5].get2Dy()},
            4);
        double closestPointThree = Math.min(Math.min(points[1].getZ(), points[2].getZ()), Math.min(points[6].getZ(), points[5].getZ()));
        double furtherestPointThree = Math.max(Math.max(points[1].getZ(), points[2].getZ()), Math.max(points[6].getZ(), points[5].getZ()));

        p4 = new Polygon(new int[] {(int)points[2].get2Dx(), (int)points[3].get2Dx(), (int)points[7].get2Dx(), (int)points[6].get2Dx()},
            new int[] {(int)points[2].get2Dy(), (int)points[3].get2Dy(), (int)points[7].get2Dy(), (int)points[6].get2Dy()},
            4);
        double closestPointFour = Math.min(Math.min(points[2].getZ(), points[3].getZ()), Math.min(points[7].getZ(), points[6].getZ()));
        double furtherestPointFour = Math.max(Math.max(points[2].getZ(), points[3].getZ()), Math.max(points[7].getZ(), points[6].getZ()));

        p5 = new Polygon(new int[] {(int)points[3].get2Dx(), (int)points[0].get2Dx(), (int)points[4].get2Dx(), (int)points[7].get2Dx()},
            new int[] {(int)points[3].get2Dy(), (int)points[0].get2Dy(), (int)points[4].get2Dy(), (int)points[7].get2Dy()},
            4);
        double closestPointFive = Math.min(Math.min(points[3].getZ(), points[0].getZ()), Math.min(points[4].getZ(), points[7].getZ()));
        double furtherestPointFive = Math.max(Math.max(points[3].getZ(), points[0].getZ()), Math.max(points[4].getZ(), points[7].getZ()));

        p6 = new Polygon(new int[] {(int)points[4].get2Dx(), (int)points[5].get2Dx(), (int)points[6].get2Dx(), (int)points[7].get2Dx()},
            new int[] {(int)points[4].get2Dy(), (int)points[5].get2Dy(), (int)points[6].get2Dy(), (int)points[7].get2Dy()},
            4);
        double closestPointSix = Math.min(Math.min(points[4].getZ(), points[5].getZ()), Math.min(points[6].getZ(), points[7].getZ()));
        double furtherestPointSix = Math.max(Math.max(points[4].getZ(), points[5].getZ()), Math.max(points[6].getZ(), points[7].getZ()));

        double[] closestPoints = new double[6];
        closestPoints[0] = closestPointOne;
        closestPoints[1] = closestPointTwo;
        closestPoints[2] = closestPointThree;
        closestPoints[3] = closestPointFour;
        closestPoints[4] = closestPointFive;
        closestPoints[5] = closestPointSix;

        double[] furtherestPoints = new double[6];
        furtherestPoints[0] = furtherestPointOne;
        furtherestPoints[1] = furtherestPointTwo;
        furtherestPoints[2] = furtherestPointThree;
        furtherestPoints[3] = furtherestPointFour;
        furtherestPoints[4] = furtherestPointFive;
        furtherestPoints[5] = furtherestPointSix;

        int closestPointIndex = 0;
        int[] sortedClosestPointIndexes = new int[6];
        Line[] closestLines = new Line[3];
        for(int i = 0, closestLineIndex = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(closestPoints[j] < closestPoints[closestPointIndex] - 0.01 || (closestPoints[j] - 0.01 < closestPoints[closestPointIndex] && furtherestPoints[j] < furtherestPoints[closestPointIndex])) {
                    closestPointIndex = j;
                }
            }
            if(i == 0) {
                for(Line l : lines) {
                    if(l.getPointOne().getZ() - closestPoints[closestPointIndex] < 0.1 || l.getPointTwo().getZ() - closestPoints[closestPointIndex] < 0.01) {
                        closestLines[closestLineIndex] = l;
                    }
                }
            }
            sortedClosestPointIndexes[i] = closestPointIndex;
            closestPoints[closestPointIndex] = 100000000;
            closestPointIndex = 0;
        }

        for(int i = 5; i > -1; i--) {
            fillSide(g2, sortedClosestPointIndexes[i]);
        }
        
        g2.setColor(Color.BLACK);
        for(Line l : closestLines)
            if(l != null)
                l.draw(g2);
    }

    public void fillSide(Graphics2D g2, int side) {
        if(side == 0) {
            g2.setColor(Color.BLUE);
            g2.fillPolygon(p1);
        } else if(side == 1) {
            g2.setColor(Color.GREEN);
            g2.fillPolygon(p2);
        } else if(side == 2) {
            g2.setColor(Color.RED);
            g2.fillPolygon(p3);
        } else if(side == 3) {
            g2.setColor(Color.YELLOW);
            g2.fillPolygon(p4);
        } else if(side == 4) {
            g2.setColor(Color.CYAN);
            g2.fillPolygon(p5);
        } else {
            g2.setColor(Color.ORANGE);
            g2.fillPolygon(p6);
        }
    }

    public void transform(double[] transformationMatrix) {
        for(Point p : points) {
            p.transform(transformationMatrix);
        }
    }
}
