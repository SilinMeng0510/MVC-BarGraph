import org.codehaus.groovy.control.messages.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame {
    BlockingQueue<Message> queue;
    JTextField redText;
    JTextField greenText;
    JTextField blueText;
    JButton updateButton;
    JButton resetButton;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;

    JLabel redBar;
    JLabel greenBar;
    JLabel blueBar;

    public View(BlockingQueue<Message> queue, Rectangle2D red, Rectangle2D green, Rectangle2D blue){
        this.queue = queue;

        this.redText = new JTextField(0);
        this.greenText = new JTextField(0);
        this.blueText = new JTextField(0);
        this.updateButton = new JButton("update");
        this.resetButton = new JButton("reset");

        this.redLabel = new JLabel("Red:");
        this.greenLabel = new JLabel("Green:");
        this.blueLabel = new JLabel("Blue:");

        this.add(redText);
        this.add(greenText);
        this.add(blueText);

        this.add(updateButton);
        this.add(resetButton);

        this.add(redBar);
        this.add(greenBar);
        this.add(blueBar);

        this.add(redLabel);
        this.add(greenLabel);
        this.add(blueLabel);

        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
