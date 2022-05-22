package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coloring implements ActionListener {
    public JButton colorButton;
    public Coloring(){
        colorButton = new JButton("Coloring");
        colorButton.setBackground(Color.BLACK);
        colorButton.setFont(new Font(colorButton.getFont().getName(), Font.BOLD, 20));
        colorButton.setForeground(Color.white);
        colorButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
