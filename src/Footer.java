import Buttons.ColoringButton;
import Buttons.SaveButton;
import views.ImagesView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author m.abdulaziz
 */
public class Footer extends JPanel implements ActionListener {

    JPanel panel;
    SaveButton saveButton;
    ColoringButton coloringButton;


    public Footer(ImagesView imagesView ) {
        panel = new JPanel(new GridLayout(1, 2, 300, 10));
        saveButton = new SaveButton();
        coloringButton = new ColoringButton(imagesView);


        createFooter();
    }

    void createFooter() {
        JComboBox colorsGroup;


        panel.add(coloringButton.coloringButton);
        panel.add(saveButton.saveButton);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.black);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
