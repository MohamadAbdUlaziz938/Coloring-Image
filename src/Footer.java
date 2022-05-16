
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
 *
 * @author m.abdulaziz
 */
public class Footer extends JPanel implements ActionListener{

    JComboBox<String> combo;
    JPanel panel;

    public Footer() {
        panel = new JPanel(new GridLayout(1, 0, 10, 10));
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

        panel.add(colorsPanel);

        JButton reset = new JButton("Coloring");
        reset.setBackground(Color.BLACK);
        reset.setFont(new Font(reset.getFont().getName(), Font.BOLD, 20));
        reset.setForeground(Color.white);
        reset.addActionListener(this);
        panel.add(reset);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.white);
    }

    void initCombo() {

        Color[] colors = {Color.red, Color.green, Color.BLUE};
        ArrayList<String> model = new ArrayList<>();
        final HashMap<String, Color> map = new HashMap<String, Color>();

        combo.setFont(Font.decode("Dialog"));
        for (int i = 0; i < colors.length; i++) {
            model.add(Utils.coloToHex(colors[i]));
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

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
