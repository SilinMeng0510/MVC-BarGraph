package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class BarGraph extends JComponent {
    private ArrayList<Rectangle2D> bars;
    private final int Y_INDEX = 200;
    private final int W_INDEX = 50;

    public BarGraph(){
        bars = new ArrayList<>();
        bars.add(new Rectangle2D.Double(20, Y_INDEX, W_INDEX, 0));
        bars.add(new Rectangle2D.Double(100, Y_INDEX, W_INDEX, 0));
        bars.add(new Rectangle2D.Double(180, Y_INDEX, W_INDEX, 0));
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        int i = 0;
        for (Rectangle2D s : bars)
        {
            g2.setPaint(colors[i++]);
            g2.draw(s);
            g2.fill(s);
        }
    }

    public void heightChange(int[] heights){
        int i = 0;
        for (Rectangle2D s : bars){
            int x = (int) s.getX();
            bars.set(i, new Rectangle2D.Double(x, Y_INDEX - heights[i], W_INDEX, heights[i]));
            i++;
        }
        repaint();
    }
}
