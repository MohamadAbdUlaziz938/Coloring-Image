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

        Click temp = new Click(-1, -1, Color.BLACK);
        temp.currentColorBuffer = Control.thisChoosImage;
        temp.currentGrayBuffer = this.imagesView.greyImagePanel.getIcon();
        Control.States.add(1,Control.States.get(2));
        Control.States.add(2,temp);
        this.imagesView.greyImagePanel.setIcon(Control.States.get(2).currentGrayBuffer);
        ImageIcon image = new ImageIcon(Control.States.get(2).currentColorBuffer);
        this.imagesView.coloredImagePanel.setIcon(image);

    }
}
