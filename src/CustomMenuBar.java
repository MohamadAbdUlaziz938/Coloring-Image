
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m.abdulaziz
 */
public class CustomMenuBar extends JMenuBar {

    JMenuBar menuBar = new JMenuBar();

    public CustomMenuBar(ImagesView imagesView) {

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(new Font(fileMenu.getFont().getName(), Font.CENTER_BASELINE, 15));

        final ToolBar toolBarsItems = new ToolBar(imagesView);
        for (int i = 0; i < toolBarsItems.items.size(); i++) {

            fileMenu.add(toolBarsItems.items.get(i));
            fileMenu.addSeparator();
        }

        menuBar.add(fileMenu);
    }

}
