package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializeButton implements ActionListener {
    public JButton initializeButton;

    public InitializeButton() {
        createInitializeButton();
    }

    void createInitializeButton() {
        initializeButton = new JButton("Initialize");
        initializeButton.setBackground(Color.blue);
        initializeButton.setFont(new Font(initializeButton.getFont().getName(), Font.BOLD, 20));
        initializeButton.setForeground(Color.white);
        initializeButton.addActionListener(this);
        initializeButton.setPreferredSize(new Dimension(150, 60));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
