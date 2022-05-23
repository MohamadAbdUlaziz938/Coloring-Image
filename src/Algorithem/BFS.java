package Algorithem;

import Model.Click;
import Model.Control;

import java.util.*;

public class BFS {
    private Click click;
    private int colorClicked;

    public BFS(Click clicked) {
        this.click = clicked;
        this.colorClicked = Control.currentState.grayBuffer.getRGB(click.x, click.y);
        BFS(click.x, click.y);
    }


    void BFS(int x, int y) {
        Queue<Integer> queX = new LinkedList<Integer>();
        Queue<Integer> queY = new LinkedList<Integer>();
        Control.thisChoosImageVisit[x][y] = true;
        queX.add(x);
        queY.add(y);
        while (queX.size() != 0) {
            x = queX.poll();
            y = queY.poll();        /* remove the top element of the queue */
            Control.currentState.coloredBuffer.setRGB(x, y, click.color.getRGB());


            int x2 = x + 1;
            int y2 = y;
            if (x2 < Control.thisChoosImage.getWidth()) {
                if (!Control.thisChoosImageVisit[x2][y2]) {

                    if (Control.thisChoosImage.getRGB(x2, y2) == colorClicked) {
                        Control.thisChoosImageVisit[x2][y2] = true;
                        queX.add(x2);
                        queY.add(y2);
                    }
                }
            }

            x2 = x - 1;
            y2 = y;
            if (x2 >= 0) {
                if (!Control.thisChoosImageVisit[x2][y2]) {
                    if (Control.thisChoosImage.getRGB(x2, y2) == colorClicked) {
                        Control.thisChoosImageVisit[x2][y2] = true;
                        queX.add(x2);
                        queY.add(y2);
                    }
                }
            }


            x2 = x;
            y2 = y - 1;
            if (y2 >= 0) {
                if (!Control.thisChoosImageVisit[x2][y2]) {
                    if (Control.thisChoosImage.getRGB(x2, y2) == colorClicked) {
                        Control.thisChoosImageVisit[x2][y2] = true;
                        queX.add(x2);
                        queY.add(y2);
                    }
                }
            }


            x2 = x;
            y2 = y + 1;
            if (y2 < Control.thisChoosImage.getHeight()) {
                if (!Control.thisChoosImageVisit[x2][y2]) {
                    if (Control.thisChoosImage.getRGB(x2, y2) == colorClicked) {
                        Control.thisChoosImageVisit[x2][y2] = true;
                        queX.add(x2);
                        queY.add(y2);
                    }
                }
            }


        }
    }


}
