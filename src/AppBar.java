import Buttons.ChooseImage;
import Utils.Hex;
import Utils.ResizeImage;
import views.ImagesView;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class AppBar  {

    JComboBox<String> combo;

    JPanel panel;
    ChooseImage chooseImage;


    public AppBar(ImagesView imagesView) {

        chooseImage=new ChooseImage(imagesView);
        panel = new JPanel(new GridLayout(1, 2, 10, 10));
        combo = new JComboBox<>();
        initCombo();
        createFooter();
    }

    void createFooter() {
        final  JComboBox colorsGroup;
        colorsGroup = combo;
        JPanel colorsPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        final  JLabel title=new JLabel("Choose color:");
        title.setForeground(Color.white);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        colorsPanel.setBackground(Color.black);
        colorsPanel.setForeground(Color.white);
        colorsPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        colorsPanel.add(title);
        colorsPanel.add(colorsGroup);



        panel.add(colorsPanel);


        panel.add(chooseImage.chooseImage);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.black);

        panel.setPreferredSize(new Dimension(900, 90));

    }

    void initCombo() {

        Color[] colors = {Color.red, Color.green, Color.BLUE};
        ArrayList<String> model = new ArrayList<>();
        final HashMap<String, Color> map = new HashMap<String, Color>();

        combo.setFont(Font.decode("Dialog"));
        for (int i = 0; i < colors.length; i++) {
            model.add(Hex.coloToHex(colors[i]));
            map.put(model.get(i), colors[i]);
            combo.addItem(model.get(i));

        }

        combo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean hasFocus) {
                JLabel l = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, hasFocus);
                l.setBackground(map.get(value));
                l.setForeground(map.get(value));
                if (isSelected) {

                }
                return l;
            }
        });

    }

}
