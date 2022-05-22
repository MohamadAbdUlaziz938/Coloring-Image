import Utils.Hex;
import buttons.Coloring;
import buttons.Initialize;
import buttons.Next;
import buttons.Previous;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author m.abdulaziz
 */
public class Footer extends JPanel {

    JComboBox<String> combo;
    JPanel panel;
    Color selectedColor;

    public Footer() {
        panel = new JPanel(new GridLayout(2, 2, 10, 10));
        combo = new JComboBox<>();
        initCombo();
        createFooter();
    }

    void createFooter() {
        JComboBox colorsGroup;
        JPanel colorsPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        colorsPanel.setBorder(new TitledBorder("Colors group"));
        colorsPanel.setBackground(Color.white);
        colorsPanel.add(new JLabel("Choose color:"));

        colorsGroup = combo;
        colorsPanel.add(colorsGroup);


        final Coloring coloring = new Coloring();
        final Next next = new Next();
        final Previous previous = new Previous();
        final Initialize initialize = new Initialize();

        panel.add(next.nextButton);
        panel.add(previous.prevButton);
        panel.add(initialize.initButton);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.white);
        panel.add(colorsPanel);
//        panel.add(coloring.colorButton);

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
