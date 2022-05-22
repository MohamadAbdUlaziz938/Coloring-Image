package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Previous implements ActionListener {
    public  JButton prevButton;
    public Previous(){
        prevButton = new JButton("Previous");
        prevButton.setBackground(Color.BLACK);
        prevButton.setFont(new Font(prevButton.getFont().getName(), Font.BOLD, 20));
        prevButton.setForeground(Color.white);
        prevButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
