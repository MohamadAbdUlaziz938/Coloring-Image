import views.ImagesView;

import javax.swing.*;
import java.awt.*;

public class BaseGui extends JPanel {

    public ImagesView imagesView;
    Footer footer;
    JPanel borderLayout;

    public BaseGui() {

        imagesView = new ImagesView(getClass().getResource("default-image.jpg").getPath());
        footer = new Footer();
        AppBar appBar = new AppBar(imagesView);

        borderLayout = new JPanel();
        borderLayout.setPreferredSize(new Dimension(900, 600));
        borderLayout.setBackground(Color.black);


        borderLayout.add(appBar.panel);
        borderLayout.add(imagesView.imagesView);

        borderLayout.add(footer.panel);
    }
}