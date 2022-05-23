import Buttons.ChooseImage;
import Utils.Hex;
import views.ImagesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AppBar {

    JComboBox<String> combo;

    JPanel panel;
    ChooseImage chooseImage;


    public AppBar(ImagesView imagesView) {

        chooseImage = new ChooseImage(imagesView);
        panel = new JPanel(new GridLayout(1, 2, 10, 10));
        combo = new JComboBox<>();

        createAppBar();
    }

    void createAppBar() {
        panel.add(chooseImage.chooseImage);


        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.black);

        panel.setPreferredSize(new Dimension(900, 90));

    }


}
