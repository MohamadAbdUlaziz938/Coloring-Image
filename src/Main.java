
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.*;

class Main {
    private static void createAndShowUI() {
        JFrame frame = new JFrame("Coloring image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        BaseGui test = new BaseGui();
        frame.add(test);
        frame.pack();
        frame.setLocationByPlatform(true);

        frame.setJMenuBar(new CustomMenuBar(test.imagesView).menuBar);
        frame.setBackground(Color.red);

        frame.setResizable(false);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}


