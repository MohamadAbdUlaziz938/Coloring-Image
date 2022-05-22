package buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Next implements ActionListener {
    public  JButton nextButton;
    public Next(){
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setFont(new Font(nextButton.getFont().getName(), Font.BOLD, 20));
        nextButton.setForeground(Color.white);
        nextButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
