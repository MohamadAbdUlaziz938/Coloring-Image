
import java.awt.*;

import javax.swing.*;

class Main {
    private static void createAndShowUI() {
        JFrame frame = new JFrame("Coloring image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.WHITE);
        BaseGui test = new BaseGui();
        frame.add(test.borderLayout);
        frame.pack();
        frame.setLocationByPlatform(true);

        //frame.setJMenuBar(new CustomMenuBar(test.imagesView).menuBar);


        frame.setResizable(false);

        frame.setPreferredSize(new Dimension(400, 500));
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


