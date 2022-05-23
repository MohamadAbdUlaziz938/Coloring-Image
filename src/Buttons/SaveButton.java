package Buttons;

import Model.Control;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SaveButton implements ActionListener {


    public JButton saveButton;
    public BufferedImage imageToSave;

    public SaveButton() {
        //this.imageToSave = bufferedImage;

        createSaveButton();
    }

    void createSaveButton() {
        JComboBox colorsGroup;
        saveButton = new JButton("Save");
        saveButton.setBackground(Color.blue);
        saveButton.setFont(new Font(saveButton.getFont().getName(), Font.BOLD, 20));
        saveButton.setForeground(Color.white);
        saveButton.addActionListener(this);
        saveButton.setPreferredSize(new Dimension(150, 60));


    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg");
        j.addChoosableFileFilter(filter);
        int r = j.showSaveDialog(null);


        if (r == JFileChooser.APPROVE_OPTION) {
            File outputfile = new File(j.getSelectedFile().getAbsolutePath());
            try {
                ImageIO.write(Control.currentState.coloredBuffer, "jpg", outputfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {

        }
    }


}
