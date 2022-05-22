package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButton implements ActionListener {
    public JButton previousButton;

    public PreviousButton() {
        createPreviousButton();
    }

    void createPreviousButton() {
        previousButton = new JButton("Previous");
        previousButton.setBackground(Color.blue);
        previousButton.setFont(new Font(previousButton.getFont().getName(), Font.BOLD, 20));
        previousButton.setForeground(Color.white);
        previousButton.addActionListener(this);
        previousButton.setPreferredSize(new Dimension(150, 60));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
