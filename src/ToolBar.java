
import java.awt.Font;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;

import javax.swing.filechooser.*;

class ToolBar extends JFrame implements ActionListener {

    ArrayList<JMenuItem> items = new ArrayList();
    List<String> itemsName = new ArrayList<>();
    ImagesView imagesView;

    ToolBar(ImagesView imagesView) {

        itemsName = Arrays.asList("Upload Image", "Save", "Exit");
        this.imagesView = imagesView;

        initItems();

    }

    void initItems() {

        for (int i = 0; i < itemsName.size(); i++) {
            JMenuItem jMenuItem = new JMenuItem(itemsName.get(i));
            jMenuItem.setFont(new Font(jMenuItem.getFont().getName(), Font.PLAIN, 15));
            jMenuItem.addActionListener(this);
            items.add(jMenuItem);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        // if the user presses the save button show the save dialog
        String com = evt.getActionCommand();
        if (com.equals("Exit")) {
            System.exit(0);
        } else if (com.equals("Save")) {
            // create an object of JFileChooser class
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // invoke the showsSaveDialog function to show the save dialog
            int r = j.showSaveDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {

                // set the label to the path of the selected file
                //            l.setText(j.getSelectedFile().getAbsolutePath());
            } // if the user cancelled the operation
            else {
                //          l.setText("the user cancelled the operation");
            }
        } // if the user presses the open dialog show the open dialog
        else {
            // create an object of JFileChooser class
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
            j.addChoosableFileFilter(filter);
            // invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {

                this.imagesView.greyImagePanel.setIcon(ResizeImage.resize(j.getSelectedFile().getAbsolutePath(), this.imagesView.greyImagePanel.getWidth(), this.imagesView.greyImagePanel.getHeight()));

                // set the label to the path of the selected file
                //        l.setText(j.getSelectedFile().getAbsolutePath());
            } // if the user cancelled the operation
            else {
                //      l.setText("the user cancelled the operation");
            }
        }
    }

    private void JMenuItem(String upload_Image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

