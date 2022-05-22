import Algorithem.DFS;
import Model.Click;
import Model.Control;
import views.ImagesView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class BaseGui extends JPanel {

    public ImagesView imagesView;
    Footer footer;
    JPanel borderLayout;

    public BaseGui() {

        imagesView = new ImagesView(getClass().getResource("default-image.jpg").getPath());
        AppBar appBar = new AppBar(imagesView);
        imagesView.getGreyImagePanel().addMouseListener(new MouseListener() {


            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse X :" + e.getX());
                System.out.println("mouse Y :" + e.getY());

                final Graphics g = imagesView.getGreyImagePanel().getGraphics();
                for (int c = 0; c < 5; c++) {
                    g.setColor(appBar.selectedColor);
                    g.drawLine(e.getX() + c, e.getY(), e.getX() + 7 + c, e.getY() + 7);
                }


                Click temp = new Click(e.getX() - 10, e.getY(), appBar.selectedColor, Control.thisChoosImage);
                Control.State.add(temp);

                /*int RGBA = Control.thisChoosImage.getRGB(307,223);
                System.out.println(RGBA);
                RGBA = Control.thisChoosImage.getRGB(308,223);
                System.out.println(RGBA);*/


                System.out.println("Play !!!");
                new DFS(temp);
                try {
                    ImageIO.write(Control.thisChoosImage, "jpg", new File("out.jpg"));
                    System.out.println("End !!!");

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }




                /*int RGBA = ChooseImage.thisChoosImage.getRGB(e.getX()-10,e.getY());
                int red = (RGBA >> 16) & 255;
                int green = (RGBA >> 8) & 255;
                int blue = RGBA & 255;
                System.out.println(red +"   "+ green +"   "+ blue);*/


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {


            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        footer = new Footer();


        borderLayout = new JPanel();
        borderLayout.setPreferredSize(new Dimension(900, 600));
        borderLayout.setBackground(Color.black);


        borderLayout.add(appBar.panel);
        borderLayout.add(imagesView.imagesView);

        borderLayout.add(footer.panel);
    }
}