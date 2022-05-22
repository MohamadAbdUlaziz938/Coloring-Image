package Utils;

import java.awt.*;
import java.util.HashMap;

public class Hex {
    public  static String coloToHex(Color color) {
        String red = Integer.toHexString(color.getRed());
        String green = Integer.toHexString(color.getGreen());
        String blue = Integer.toHexString(color.getBlue());

        if (red.length() == 1) {
            red = "0" + red;
        }
        if (green.length() == 1) {
            green = "0" + green;
        }
        if (blue.length() == 1) {
            blue = "0" + blue;
        }

        String hexColor = "#" + red + green + blue;
        return hexColor;
    }
    public  static  HashMap<String, Color>  getColors(){
        final HashMap<String, Color> color_name = new HashMap<String, Color>();
        color_name.put("red", Color.red);
        color_name.put("green", Color.green);
        color_name.put("blue", Color.BLUE);
        color_name.put("black", Color.BLACK);
        color_name.put("cyan", Color.cyan);
        color_name.put("yellow", Color.yellow);
        color_name.put("magenta", Color.magenta);
        color_name.put("white", Color.WHITE);
        return  color_name;
    }

}







