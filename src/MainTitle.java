
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m.abdulaziz
 */
public class MainTitle {

    JLabel title;
    JPanel panel;

    public MainTitle() {
        title = new JLabel("Coloring Image");
        panel = new JPanel();
        createNorthPanel();
    }

    private void createNorthPanel() {

        panel.setBackground(Color.white);

        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        titleStyle();
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        panel.add(title);

    }

}
