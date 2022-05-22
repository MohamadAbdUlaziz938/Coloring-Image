package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Initialize implements ActionListener {
    public JButton initButton;

    public Initialize() {
        initButton = new JButton("Initialize");
        initButton.setBackground(Color.BLACK);
        initButton.setFont(new Font(initButton.getFont().getName(), Font.BOLD, 20));
        initButton.setForeground(Color.white);
        initButton.addActionListener(this);
    }

    ;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
