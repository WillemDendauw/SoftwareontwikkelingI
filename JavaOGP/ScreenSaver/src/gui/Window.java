
package gui;

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

/**
 *
 * @author wim.vandenbreen@ugent.be
 */
public class Window extends JFrame implements ActionListener {

    private ArrayList<Shape> shapes;
    private Timer timer;
    private static final String[] types = {"Circle", "Rectangle", "Hexagon"};
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
        timer = new Timer(1, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random r = new Random();
        
        String klasseNaam = types[r.nextInt(types.length)];
        
        int width = r.nextInt(MAX_WIDTH - MIN_WIDTH + 1) + MIN_WIDTH;
        int height = width;
        if (klasseNaam.equals("Rectangle")){
            height = r.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT;
        }
        
        int left = r.nextInt(getContentPane().getWidth()-width);
        int top = r.nextInt(getContentPane().getHeight()-height);
        
        //if (klasseNaam.equals(klasseNaam)){
        //    shapes.add(new Rectangle(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)), left, top, width, height));
        //}
        //else {
        try {
            Shape shp; 
            try {
                shp = (Shape) Class
                        .forName(klasseNaam).getConstructor(Integer.class, Integer.class, Integer.class,Integer.class,Color.class)
                        .newInstance(left,top,width,height,new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
                shapes.add(shp);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
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
