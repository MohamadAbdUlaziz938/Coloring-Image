package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Click {
    public int x;
    public int y;
    public Color color;
    public BufferedImage currentBuffer;
    public  boolean isActive =false;

    public Click(int x, int y, Color color, BufferedImage currentBuffer){
        this.x=x;
        this.y=y;
        this.color=color;
        this.currentBuffer=currentBuffer;
    }
}
