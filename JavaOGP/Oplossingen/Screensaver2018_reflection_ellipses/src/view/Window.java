package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import model.*;

/**
 *
 * @author tiwi
 */
public class Window extends JFrame implements ActionListener {

    private ArrayList<Shape> shapes;
    private Timer timer;
    //private static final int NUMBER_OF_SHAPES = 3; //+/
    private static final String[] types = {"Circle", "Rectangle", "Hexagon"}; //+/
    private static final int MIN_WIDTH = 50;
    private static final int MIN_HEIGHT = 50;
    private static final int MAX_WIDTH = 120;
    private static final int MAX_HEIGHT = 120;

    public Window() {
        super("Screensaver");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setResizable(false);
        this.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape shape : shapes) {
                    shape.draw((Graphics2D) g);
                }
            }
        });
        shapes = new ArrayList<>();
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random r = new Random();

        String klasseNaam = "model." + types[r.nextInt(types.length)];

        int width = r.nextInt(MAX_WIDTH - MIN_WIDTH + 1) + MIN_WIDTH;
        int height = width;
        if (klasseNaam.equals("Rectangle")) {
            height = r.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT;
        }

        int left = r.nextInt(getContentPane().getWidth() - width);
        int top = r.nextInt(getContentPane().getHeight() - height);

        //if (klasseNaam.equals("Rectangle")) {
        //    shapes.add(new Rectangle(new Color(r.nextInt(256), 0, r.nextInt(256)), left, top, width, height));
        //} else {
            try {
                Shape shape;
                try {
                    shape = (Shape) Class
                            .forName(klasseNaam).getConstructor(Color.class, Integer[].class)
                            .newInstance(new Color(r.nextInt(256), 0, r.nextInt(256)), 
                                         new Integer[]{left, top, width, height});
                    shapes.add(shape);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Opmerkingen voor reflection:
            
            // (1) De klassenaam bevat ook de naam van de package, dus 
            //     "model.Rectangle" in plaats van "Rectangle".
            // (2) Parameters meegeven aan de methode getConstructor kan.
            //     Voor primitieve types (int,double,...) gebruik je TYPE
            //     van de wrapperklasse (Integer.TYPE, Double.TYPE,...)
            // (3) Heb je een parameterlijst van variabele lengte, dan kan je
            //     dit allicht met ellipses opvangen: 
            //     de opgeroepen methode gebruikt als laatste parameter ellipses;
            //     het type van die parameter komt overeen met een array.
            //     Als de klassenaam van een bepaald object 'Ding' is, dan is 
            //     de klassenaam van een array van 'Ding'-en gelijk aan
            //     'Ding[]'.
            // (4) Wil je (2) en (3) combineren, nl. een variabel aantal parameters
            //     van primitief type, dan raak je allicht niet verder.
            //     Je moet dan toch expliciet overstappen op parameters van de wrapperklasse
            //     (de constructoren van Rectangle,Circle,... moeten dus aangepast worden).
        //}
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window w = new Window();

            }
        });

    }
}
