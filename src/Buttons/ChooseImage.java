package Buttons;


import Utils.ResizeImage;

import javax.swing.*;
import  views.ImagesView;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseImage extends  JButton implements ActionListener {
    public JButton chooseImage;
    ImagesView imagesView;
    public  ChooseImage(ImagesView imagesView ){
        this.imagesView = imagesView;
        createButton();
    }
    void createButton(){
        chooseImage= new JButton("Choose Image");
        chooseImage.setBackground(Color.blue);
        chooseImage.setFont(new Font(chooseImage.getFont().getName(), Font.BOLD, 20));
        chooseImage.setForeground(Color.white);
        chooseImage.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
        j.addChoosableFileFilter(filter);
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            this.imagesView.greyImagePanel.setIcon(ResizeImage.resize(j.getSelectedFile().getAbsolutePath(), this.imagesView.greyImagePanel.getWidth(), this.imagesView.greyImagePanel.getHeight()));

        }
    }
}
