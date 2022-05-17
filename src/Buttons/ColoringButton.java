package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColoringButton implements ActionListener {
    public  JButton coloringButton;

    public ColoringButton() {
        createColoringButton();
    }

    void createColoringButton() {
        coloringButton = new JButton("Coloring");
        coloringButton.setBackground(Color.blue);
        coloringButton.setFont(new Font(coloringButton.getFont().getName(), Font.BOLD, 20));
        coloringButton.setForeground(Color.white);
        coloringButton.addActionListener(this);
        coloringButton.setPreferredSize(new Dimension(150, 60));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
