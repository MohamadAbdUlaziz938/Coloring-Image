import Utils.Hex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ColorsList {

    JPanel colorsPanel;
    Color selectedColor;

    ColorsList() {
        JComboBox<String> combo = new JComboBox<>();
        initCombo(combo);
        colorsPanel = new JPanel();

        final JLabel title = new JLabel("Choose color:");
        title.setForeground(Color.white);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        colorsPanel.setBackground(Color.black);
        colorsPanel.setForeground(Color.white);
        colorsPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        colorsPanel.add(title);
        colorsPanel.add(combo);
    }

    void initCombo(JComboBox<String> combo) {
        final HashMap<String, Color> color_name = Hex.getColors();

        combo.setFont(new Font(combo.getFont().getName(), Font.BOLD, 20));
        String[] model = color_name.keySet().toArray(new String[0]);
        for (int i = 0; i < model.length; i++) {
            combo.addItem(model[i]);

        }
        selectedColor = color_name.get("red");
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Value: " + cb.getSelectedItem().toString());
                selectedColor = color_name.get(combo.getSelectedItem().toString());
            }
        });


    }

}
