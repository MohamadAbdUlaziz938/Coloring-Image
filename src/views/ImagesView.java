package views;

import Utils.ResizeImage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagesView extends JPanel {

    public  JPanel imagesView;
    String defUrl;
    public  JLabel greyImagePanel = new JLabel();
    public JLabel coloredImagePanel = new JLabel();

    public ImagesView(String defUrl) {

        this.defUrl=defUrl;
        this.imagesView = new JPanel(new GridLayout(1, 2, 100, 10));
        greyImagePanel.setBounds(10, 10, 365, 290);
        coloredImagePanel.setBounds(10, 10, 365, 290);
        initImagesView();
        initImagePanel();
        addToImagesView(greyImagePanel);
        addToImagesView(coloredImagePanel);

    }

    private void initImagesView() {
        imagesView.setBackground(Color.black);
        imagesView.setPreferredSize(new Dimension(900, 400));

    }

    public void addToGrayImage(Component com) {
        greyImagePanel.add(com);
    }

    public void addToImagesView(Component com) {
        imagesView.add(com);

    }

    public JPanel getImagesView() {
        return imagesView;
    }

    public JLabel getGreyImagePanel() {
        return greyImagePanel;
    }

    public JLabel getColoredImagePanel() {
        return coloredImagePanel;
    }

    public void setImagesView(JPanel imagesView) {
        this.imagesView = imagesView;
    }

    public void setGreyImagePanel(JLabel greyImagePanel) {
        this.greyImagePanel = greyImagePanel;
    }

    public void setColoredImagePanel(JLabel coloredImagePanel) {
        this.coloredImagePanel = coloredImagePanel;
    }

    private void initImagePanel() {


        coloredImagePanel.setPreferredSize(new Dimension(100, 100));
        coloredImagePanel.setMaximumSize(greyImagePanel.getPreferredSize());
        coloredImagePanel.setBackground(Color.WHITE);
        coloredImagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        coloredImagePanel.setIcon(ResizeImage.resize(defUrl, coloredImagePanel.getWidth(), coloredImagePanel.getHeight()));

        greyImagePanel.setPreferredSize(new Dimension(100, 100));
        greyImagePanel.setBackground(Color.WHITE);
        greyImagePanel.setMaximumSize(greyImagePanel.getPreferredSize());
        greyImagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        greyImagePanel.setIcon(ResizeImage.resize(defUrl, greyImagePanel.getWidth(), greyImagePanel.getHeight()));
        //greyImagePanel.add(new ImageLoad(null));

    }

}
