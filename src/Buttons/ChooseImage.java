package Buttons;


import Model.Control;
import Utils.ResizeImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import  views.ImagesView;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
            System.out.print(this.imagesView.greyImagePanel.getWidth());
            System.out.print(this.imagesView.greyImagePanel.getHeight());
            this.imagesView.greyImagePanel.setIcon(ResizeImage.resize(j.getSelectedFile().getAbsolutePath(), this.imagesView.greyImagePanel.getWidth(), this.imagesView.greyImagePanel.getHeight()));
            Control.thisChoosImage = writeImageOut(j.getSelectedFile().getAbsolutePath(), this.imagesView.greyImagePanel.getWidth(), this.imagesView.greyImagePanel.getHeight());
            Control.thisChoosImageVisit = new boolean[this.imagesView.greyImagePanel.getWidth()][this.imagesView.greyImagePanel.getHeight()];
        }
    }
    public BufferedImage writeImageOut(String path, int W, int H) {
        // reads the input image
        File f = new File(path);
        BufferedImage inputImage = null;
        try {
            inputImage = ImageIO.read(f);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        // creates the output image
        BufferedImage img = new BufferedImage(W, H, inputImage.getType());

        // balance the input image to the output image
        Graphics2D g = img.createGraphics();
        g.drawImage(inputImage, 0, 0, W, H, null);
        g.dispose();

        return img;
    }
}
