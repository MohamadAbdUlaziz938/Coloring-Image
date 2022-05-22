package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Click {
    public int x;
    public int y;
    public Color color;
    public Icon currentGrayBuffer;
    public BufferedImage currentColorBuffer;
    public  boolean isActive =false;

    public Click(int x, int y, Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }
}
