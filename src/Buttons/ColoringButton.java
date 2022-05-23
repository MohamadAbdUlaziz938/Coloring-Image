package Buttons;

import Model.Click;
import Model.Control;
import Utils.ResizeImage;
import views.ImagesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColoringButton implements ActionListener {
    public JButton coloringButton;
    ImagesView imagesView;

    public ColoringButton(ImagesView imagesView) {
        createColoringButton();
        this.imagesView = imagesView;
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
        System.out.println(Control.States.size());
        Click temp = Control.States.get(2);
//        Click prevClick = new Click(temp.x, temp.y, temp.color);
//        prevClick.coloredBuffer = ChooseImage.deepCopy(temp.coloredBuffer);
//        prevClick.grayBuffer = ChooseImage.deepCopy(temp.grayBuffer);
        Control.States.set(1, ChooseImage.copyClick(temp));
        Click temp2 = Control.States.get(3);
//        Click prevClick2 = new Click(temp2.x, temp2.y, temp2.color);
//        prevClick2.coloredBuffer = ChooseImage.deepCopy(temp2.coloredBuffer);
//        prevClick2.grayBuffer = ChooseImage.deepCopy(temp2.grayBuffer);
        //Control.States.set(2, prevClick2);
        Control.States.set(2, ChooseImage.copyClick(temp2));


        this.imagesView.coloredImagePanel.setIcon(new ImageIcon(temp2.coloredBuffer));

    }
}
