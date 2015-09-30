import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JOptionPane;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Point;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import java.net.URL;

import java.io.File;
import java.io.IOException;

/**
 * This is the GUITemplate class. This includes the JFrame, listeners, buttons, and the GUITemplateComponent which includes all the objects. The buttons and the components are all added to a panel, which is added to the frame.
 * The main method starts the comp and sets everything up. 
 *
 * @author (Thanatcha Panpairoj)
 * @version (7/25/15)
 */

public class Renderer extends JFrame
{
    private double mouseX, mouseY, numberOfDirectionsMoving;
    private boolean left, right, forward, backward;
    private static final double diagonalMoveSpeed = 50 / Math.sqrt(2);

    public static void main(String[] args) throws Exception {
        Renderer r = new Renderer();
    }

    public Renderer() throws Exception {
        super();

        setCursor(getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));

        left = false;
        right = false;
        forward = false;
        backward = false;

        numberOfDirectionsMoving = 0;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)dim.getWidth(), (int)dim.getHeight());
        this.setTitle("Display");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        final int width = this.getWidth();
        final int height = this.getHeight();

        Robot robot = new Robot();
        robot.mouseMove(width / 2 + 3, height / 2 + 25);
        //System.out.println("" + width + ", " + height);

        //         frame.setUndecorated(true);
        //         frame.setShape(new Ellipse2D.Double(0,0, 800, 800));//circle frame?

        JPanel panel = new JPanel();
        panel.setDoubleBuffered(true);

        RendererComponent comp = new RendererComponent(width, height);

        class TimeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                mouseX = MouseInfo.getPointerInfo().getLocation().getX() - getLocation().getX() - 3;
                mouseY = MouseInfo.getPointerInfo().getLocation().getY() - getLocation().getY() - 25;
                comp.updateMouse(mouseX, mouseY);

                double xSpinAngle = (height / 2 - mouseY) / 1000;
                comp.transform(new double[] {1,                     0,                    0, 0, 
                                             0,  Math.cos(xSpinAngle), Math.sin(xSpinAngle), 0, 
                                             0, -Math.sin(xSpinAngle), Math.cos(xSpinAngle), 0, 
                                             0,                     0,                    0, 1});

                double ySpinAngle = (width / 2 - mouseX) / 1000;
                comp.transform(new double[] {Math.cos(ySpinAngle), 0, Math.sin(ySpinAngle), 0,
                                                                0, 1,                    0, 0, 
                                            -Math.sin(ySpinAngle), 0, Math.cos(ySpinAngle), 0, 
                                                                0, 0,                    0, 1});
                        
                robot.mouseMove(width / 2 + 3, height / 2 + 25);

                double speed = 50;
                if(numberOfDirectionsMoving > 1) {
                    speed = diagonalMoveSpeed;
                }

                if(left && !right) {
                    comp.transform(new double[] {1, 0, 0, speed, 
                            0, 1, 0,     0, 
                            0, 0, 1,     0, 
                            0, 0, 0,     1});
                } else if(right && !left) {
                    comp.transform(new double[] {1, 0, 0, -speed, 
                            0, 1, 0,      0, 
                            0, 0, 1,      0, 
                            0, 0, 0,      1});
                }

                if(forward && !backward) {
                    comp.transform(new double[] {1, 0, 0,      0, 
                            0, 1, 0,      0, 
                            0, 0, 1, -speed, 
                            0, 0, 0,      1});
                } else if(backward && !forward) {
                    comp.transform(new double[] {1, 0, 0,     0, 
                            0, 1, 0,     0, 
                            0, 0, 1, speed, 
                            0, 0, 0,     1});
                } 

                comp.repaint();
            }
        }

        class KeyboardListener implements KeyListener {
            /**
             * Updates which keys are currently pressed.
             * 
             * @param  e  key pressed on the keyboard
             * @return    void
             */
            public void keyPressed(KeyEvent e)
            {
                int k = e.getKeyCode();
                if(k ==  KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else if(k == KeyEvent.VK_A) {
                    left = true;
                    numberOfDirectionsMoving++;
                } else if (k == KeyEvent.VK_D) {
                    right = true;
                    numberOfDirectionsMoving++;
                } else if (k == KeyEvent.VK_W) {
                    forward = true;
                    numberOfDirectionsMoving++;
                } else if (k == KeyEvent.VK_S) {
                    backward = true;
                    numberOfDirectionsMoving++;
                } 
            }

            /**
             * Updates when a key is released.
             * 
             * @param  e  key released from the keyboard
             * @return    void
             */
            public void keyReleased(KeyEvent e) {
                int k = e.getKeyCode();
                if(k == KeyEvent.VK_A) {
                    left = false;
                    numberOfDirectionsMoving--;
                } else if (k == KeyEvent.VK_D) {
                    right = false;
                    numberOfDirectionsMoving--;
                } else if (k == KeyEvent.VK_W) {
                    forward = false;
                    numberOfDirectionsMoving--;
                } else if (k == KeyEvent.VK_S) {
                    backward = false;
                    numberOfDirectionsMoving--;
                } 
            }

            /**
             * Updates when a key is typed.
             * 
             * @param  e  key typed on the keyboard
             * @return    void
             */
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
            }
        }

        class MousePressListener implements MouseListener
        {
            /**
             * Updates when the mouse button is pressed.
             * 
             * @param  event  mouse button press
             * @return        void
             */
            public void mousePressed(MouseEvent event)
            {

            }

            /**
             * Updates when the mouse button is released.
             * 
             * @param  event  mouse button is released
             * @return        void
             */
            public void mouseReleased(MouseEvent event) {
                comp.click();
            }

            public void mouseClicked(MouseEvent event) {}

            public void mouseEntered(MouseEvent event) {}

            public void mouseExited(MouseEvent event) {}
        }

        class ScrollListener implements MouseWheelListener
        {
            public void mouseWheelMoved(MouseWheelEvent e) {

            }
        }
        comp.setPreferredSize(new Dimension(width, height));
        comp.addKeyListener(new KeyboardListener());
        comp.addMouseListener(new MousePressListener());
        comp.addMouseWheelListener(new ScrollListener());
        comp.setBounds(0, 0, width, height);
        comp.setFocusable(true);
        comp.setVisible(true);

        final int DELAY = 1000 / 60;//60 frames per second
        Timer t = new Timer(DELAY, new TimeListener());
        t.start();

        panel.setLayout(null);

        panel.add(comp);
        this.add(panel);

        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);

        setResizable(false);
        comp.requestFocus();
    }
}
