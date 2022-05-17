package Buttons;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SaveButton implements ActionListener {


    public JButton saveButton;

    public SaveButton() {


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
        if (ae.equals("Save")) {

            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int r = j.showSaveDialog(null);


            if (r == JFileChooser.APPROVE_OPTION) {


            } else {

            }
        }

    }

}
