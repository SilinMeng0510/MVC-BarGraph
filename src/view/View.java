package view;

import org.codehaus.groovy.control.messages.Message;

import javax.swing.*;
import java.awt.*;
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

    BarGraph bars;

    public View(BlockingQueue<Message> queue){
        this.queue = queue;

        // this.bars = new BarGraph();

        this.redText = new JTextField(0);
        this.greenText = new JTextField(0);
        this.blueText = new JTextField(0);

        this.updateButton = new JButton("update");
        updateButton.addActionListener(e -> {

        });
        this.resetButton = new JButton("reset");
        resetButton.addActionListener(e -> {

        });

        this.redLabel = new JLabel("Red:");
        this.greenLabel = new JLabel("Green:");
        this.blueLabel = new JLabel("Blue:");

        JPanel insert = new JPanel();
        insert.add(redLabel);
        insert.add(redText);
        insert.add(greenLabel);
        insert.add(greenText);
        insert.add(blueLabel);
        insert.add(blueText);
        insert.add(updateButton);
        insert.add(resetButton);

        this.add(insert, BorderLayout.WEST);
        this.add(bars, BorderLayout.EAST);


        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
