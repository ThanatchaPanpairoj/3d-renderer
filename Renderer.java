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
    private int mouseX, mouseY;
    private boolean left, right;

    public static void main(String[] args) {
        Renderer r = new Renderer();
    }

    public Renderer() {
        super();

        left = false;
        right = false;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)dim.getWidth(), (int)dim.getHeight());
        this.setTitle("Display");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        final int width = this.getWidth();
        final int height = this.getHeight();
        //System.out.println("" + width + ", " + height);

        //         frame.setUndecorated(true);
        //         frame.setShape(new Ellipse2D.Double(0,0, 800, 800));//circle frame?

        JPanel panel = new JPanel();
        panel.setDoubleBuffered(true);

        RendererComponent comp = new RendererComponent(width, height);

        class TimeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                mouseX = (int)(MouseInfo.getPointerInfo().getLocation().getX() - getLocation().getX() - 3);
                mouseY = (int)(MouseInfo.getPointerInfo().getLocation().getY() - getLocation().getY() - 25);
                comp.updateMouse(mouseX, mouseY);

                if(left) {
                    comp.transform(new double[] {1, 0, 0, 5, 
                                                 0, 1, 0, 0, 
                                                 0, 0, 1, 0, 
                                                 0, 0, 0, 1});
                } else if(right) {
                    comp.transform(new double[] {1, 0, 0, -5, 
                                                 0, 1, 0, 0, 
                                                 0, 0, 1, 0, 
                                                 0, 0, 0, 1});
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
                char c = e.getKeyChar();
                if(c == 'a' || c == 'A') {
                    left = true;
                    right = false;
                } else if (c == 'd' || c == 'D') {
                    right = true;
                    left = false;
                } 
            }

            /**
             * Updates when a key is released.
             * 
             * @param  e  key released from the keyboard
             * @return    void
             */
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                if(c == 'a' || c == 'A') {
                    left = false;
                } else if (c == 'd' || c == 'D') {
                    right = false;
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
