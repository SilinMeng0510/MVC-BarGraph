package view;

import controller.ResetMessage;
import controller.UpdateMessage;
import controller.Message;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
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

    // BarGraph bars;
    JLabel allBars;

    public View(BlockingQueue<Message> queue, int[] bars){
        this.queue = queue;

        // this.bars = new BarGraph();
        this.allBars = new JLabel(Arrays.toString(bars));

        this.redText = new JTextField(5);
        redText.setText("0");
        this.greenText = new JTextField(5);
        greenText.setText("0");
        this.blueText = new JTextField(5);
        blueText.setText("0");

        this.updateButton = new JButton("update");
        updateButton.addActionListener(e -> {
            int[] value = new int[3];
            value[0] = Integer.parseInt(redText.getText());
            value[1] = Integer.parseInt(greenText.getText());
            value[2] = Integer.parseInt(blueText.getText());
            try {
                Message msg = new UpdateMessage(value);
                queue.put(msg);
            } catch (InterruptedException exception) {
            }
        });

        this.resetButton = new JButton("reset");
        resetButton.addActionListener(e -> {
            try {
                Message msg = new ResetMessage();
                queue.put(msg);
            } catch (InterruptedException exception) {
            }
        });

        this.redLabel = new JLabel("Red:");
        this.greenLabel = new JLabel("Green:");
        this.blueLabel = new JLabel("Blue:");

        JPanel insert = new JPanel();
        insert.setLayout(new BoxLayout(insert, BoxLayout.Y_AXIS));
        insert.add(redLabel);
        insert.add(redText);
        insert.add(greenLabel);
        insert.add(greenText);
        insert.add(blueLabel);
        insert.add(blueText);
        insert.add(updateButton);
        insert.add(resetButton);

        this.setSize(500, 300);

        this.add(insert, BorderLayout.WEST);
        // this.add(bars, BorderLayout.EAST);
        this.add(allBars, BorderLayout.CENTER);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateBarGraph(int[] heights){
        // BarGraph update process
        this.allBars.setText(Arrays.toString(heights));
    }
}
