package Buttons;

import Model.Click;
import Model.Control;
import views.ImagesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButton implements ActionListener {
    public JButton previousButton;
    ImagesView imagesView;

    public PreviousButton(ImagesView imagesView) {
        this.imagesView = imagesView;
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
        System.out.println("prev");
        Click temp = Control.States.get(1);
        Click prevClick = new Click(temp.x, temp.y, temp.color);
        prevClick.coloredBuffer =ChooseImage.deepCopy(temp.coloredBuffer);
        prevClick.grayBuffer = ChooseImage.deepCopy(temp.grayBuffer);
        Control.States.set(3, prevClick);
        Control.currentState=prevClick;
        this.imagesView.greyImagePanel.setIcon(new ImageIcon(temp.grayBuffer));
        this.imagesView.coloredImagePanel.setIcon(new ImageIcon(temp.coloredBuffer));
    }
}
