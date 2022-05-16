
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m.abdulaziz
 */
public class ResizeImage {

    static public ImageIcon resize(String imgPath, int width, int height) {


        ImageIcon path = new ImageIcon(imgPath);

        Image img = path.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

}
