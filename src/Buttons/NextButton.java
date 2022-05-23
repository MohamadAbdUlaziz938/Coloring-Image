package Buttons;

import Model.Click;
import Model.Control;
import views.ImagesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton implements ActionListener {
    public JButton nextButton;
    ImagesView imagesView;
    public NextButton(ImagesView imagesView) {
        this.imagesView=imagesView;
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
        System.out.println("next");
        Click temp = Control.States.get(2);
//        Click prevClick = new Click(temp.x, temp.y, temp.color);
//        prevClick.coloredBuffer =ChooseImage.deepCopy(temp.coloredBuffer);
//        prevClick.grayBuffer = ChooseImage.deepCopy(temp.grayBuffer);
        Control.States.set(3, ChooseImage.copyClick(temp));
        Control.currentState=temp;
        this.imagesView.greyImagePanel.setIcon(new ImageIcon(temp.grayBuffer));
        this.imagesView.coloredImagePanel.setIcon(new ImageIcon(temp.coloredBuffer));
    }
}
