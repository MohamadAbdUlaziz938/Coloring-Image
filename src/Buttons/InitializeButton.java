package Buttons;

import Model.Click;
import Model.Control;
import views.ImagesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializeButton implements ActionListener {
    public JButton initializeButton;
    ImagesView imagesView;

    public InitializeButton(ImagesView imagesView) {
        this.imagesView = imagesView;
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
        System.out.println("ini");
        final Click temp = Control.States.get(0);
        Control.States.set(1, ChooseImage.copyClick(temp));
        Control.States.set(2, ChooseImage.copyClick(temp));
        Control.States.set(3, ChooseImage.copyClick(temp));
        Control.currentState = temp;
        this.imagesView.greyImagePanel.setIcon(new ImageIcon(temp.grayBuffer));

        this.imagesView.coloredImagePanel.setIcon(new ImageIcon(temp.coloredBuffer));

    }
}
