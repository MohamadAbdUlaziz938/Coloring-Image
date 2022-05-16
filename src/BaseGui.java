import javax.swing.*;
import java.awt.*;

public class BaseGui extends JPanel {

    ImagesView imagesView;
    Footer footer;

    public BaseGui() {
        imagesView = new ImagesView();
        footer = new Footer();
        BorderLayout borderLayout = new BorderLayout(1, 1);

        setLayout(borderLayout);

        add(new MainTitle().panel, BorderLayout.NORTH);
        add(imagesView.imagesView, BorderLayout.CENTER);

        add(footer.panel, BorderLayout.SOUTH);
    }
}