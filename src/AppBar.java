import Buttons.ChooseImage;
import Utils.Hex;
import views.ImagesView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AppBar {
    Color selectedColor;
    JComboBox<String> combo;

    JPanel panel;
    ChooseImage chooseImage;


    public AppBar(ImagesView imagesView) {

        chooseImage = new ChooseImage(imagesView);
        panel = new JPanel(new GridLayout(1, 2, 10, 10));
        combo = new JComboBox<>();
        initCombo();
        createAppBar();
    }

    void createAppBar() {
        final JComboBox colorsGroup;
        colorsGroup = combo;
        JPanel colorsPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        final JLabel title = new JLabel("Choose color:");
        title.setForeground(Color.white);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        colorsPanel.setBackground(Color.black);
        colorsPanel.setForeground(Color.white);
        colorsPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        colorsPanel.add(title);
        colorsPanel.add(colorsGroup);

        panel.add(chooseImage.chooseImage);
        panel.add(colorsPanel);



        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.black);

        panel.setPreferredSize(new Dimension(900, 90));

    }

    void initCombo() {
        final HashMap<String, Color> color_name = Hex.getColors();

        combo.setFont(new Font(combo.getFont().getName(), Font.BOLD, 20));
        String[] model = color_name.keySet().toArray(new String[0]);
        for (int i = 0; i < model.length; i++) {
            combo.addItem(model[i]);

        }
        selectedColor = color_name.get("red");
        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean hasFocus) {
                JLabel l = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, hasFocus);
                l.setBackground(color_name.get(value));
                l.setForeground(color_name.get(value));
                if (isSelected) {
                    selectedColor = color_name.get(value);

                }
                return l;
            }
        });

    }

}
