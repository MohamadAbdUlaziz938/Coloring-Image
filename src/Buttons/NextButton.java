package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton implements ActionListener {
    public JButton nextButton;

    public NextButton() {
        createNextButton();
    }

    void createNextButton() {
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.blue);
        nextButton.setFont(new Font(nextButton.getFont().getName(), Font.BOLD, 20));
        nextButton.setForeground(Color.white);
        nextButton.addActionListener(this);
        nextButton.setPreferredSize(new Dimension(150, 60));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
