import Buttons.*;
import views.ImagesView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
    JPanel colorList;
    ColoringButton coloringButton;
    ImagesView imagesView;

    public Footer(ImagesView imagesView, JPanel colorList) {
        panel = new JPanel(new GridLayout(2, 2, 10, 10));
        this.colorList = colorList;
        saveButton = new SaveButton();
        this.imagesView=imagesView;
        coloringButton = new ColoringButton(imagesView);
        createFooter();
    }

    void createFooter() {
        JComboBox colorsGroup;
        final InitializeButton initializeButton = new InitializeButton(this.imagesView);
        final NextButton nextButton = new NextButton();
        final PreviousButton previousButton = new PreviousButton();
        panel.add(colorList);
        panel.add(coloringButton.coloringButton);
        panel.add(saveButton.saveButton);
        panel.add(initializeButton.initializeButton);
        panel.add(previousButton.previousButton);
        panel.add(nextButton.nextButton);




        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.black);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
