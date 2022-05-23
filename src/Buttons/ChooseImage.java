package Buttons;


import Model.Click;
import Model.Control;
import Utils.ResizeImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import views.ImagesView;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseImage extends JButton implements ActionListener {
    public JButton chooseImage;
    ImagesView imagesView;

    public ChooseImage(ImagesView imagesView) {
        this.imagesView = imagesView;
        createButton();
    }

    void createButton() {
        chooseImage = new JButton("Choose Image");
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
            Control.States = new ArrayList<>();

            Control.thisChoosImage = writeImageOut(j.getSelectedFile().getAbsolutePath(), this.imagesView.greyImagePanel.getWidth(), this.imagesView.greyImagePanel.getHeight());


            Control.thisChoosImageVisit = new boolean[this.imagesView.greyImagePanel.getWidth()][this.imagesView.greyImagePanel.getHeight()];

            final ImageIcon grayImageIcon = new ImageIcon(Control.thisChoosImage);
            final ImageIcon colorImageIcon = new ImageIcon(Control.thisChoosImage);
            this.imagesView.greyImagePanel.setIcon(grayImageIcon);
            this.imagesView.coloredImagePanel.setIcon(colorImageIcon);

            //////////////////
            Click initClick1 = new Click(-1, -1, Color.BLACK);

            initClick1.grayBuffer = deepCopy(Control.thisChoosImage);
            initClick1.coloredBuffer = deepCopy(Control.thisChoosImage);
            Control.States.add(initClick1);
            Click initClick2 = new Click(-1, -1, Color.BLACK);
            initClick2.grayBuffer = deepCopy(Control.thisChoosImage);
            initClick2.coloredBuffer = deepCopy(Control.thisChoosImage);
            Control.States.add(initClick2);
            Click initClick3 = new Click(-1, -1, Color.BLACK);
            initClick3.grayBuffer = deepCopy(Control.thisChoosImage);
            initClick3.coloredBuffer = deepCopy(Control.thisChoosImage);
            Control.States.add(initClick3);
            Click initClick4 = new Click(-1, -1, Color.BLACK);
            initClick4.grayBuffer = deepCopy(Control.thisChoosImage);
            initClick4.coloredBuffer = deepCopy(Control.thisChoosImage);
            initClick4.graphics = initClick4.grayBuffer.getGraphics();
            Control.States.add(initClick4);
            Control.currentState=initClick1;

        }
    }

    static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
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
    public  static Click copyClick(Click click){
        final Click initClick = new Click(-1, -1, click.color);
        initClick.grayBuffer = ChooseImage.deepCopy(click.grayBuffer);
        initClick.coloredBuffer = ChooseImage.deepCopy(click.coloredBuffer);
        return  initClick;
    }
}
