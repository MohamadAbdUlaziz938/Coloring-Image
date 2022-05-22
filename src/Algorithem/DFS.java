package Algorithem;

import Model.Click;
import Model.Control;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DFS {
    private Click click;
    public  DFS(Click clicked){
        this.click=clicked;
        initDfsColoring();
    }

    public void initDfsColoring(){
        Control.thisChoosImageVisit[click.x][click.y]=true;


        initDfsColoring2();
        Control.thisChoosImage.setRGB(click.x,click.y, click.color.getRGB());
    }

    public void initDfsColoring2(){
        Control.thisChoosImageVisit[click.x][click.y]=true;

        int TRy = click.y;
        if(TRy >=0 && TRy<Control.thisChoosImage.getHeight()){
            while (TRy < Control.thisChoosImage.getHeight() ){
                DfsTRColoring(click.x+1,TRy);
                TRy ++;
            }
        }

        int TLy = click.y;
        if(TLy >=0 && TLy<Control.thisChoosImage.getHeight()){
            while (TLy < Control.thisChoosImage.getHeight() ){
                DfsTLColoring(click.x-1,TLy);
                TLy ++;
            }
        }



        int DRy = click.y;
        if(DRy >=0 && DRy<Control.thisChoosImage.getHeight()){
            while (DRy >= 0 ){
                DfsDRColoring(click.x+1,DRy);
                DRy --;
            }
        }

        int DLy = click.y;
        if(DLy >=0 && DLy<Control.thisChoosImage.getHeight()){
            while (DLy >=0 ){
                DfsDLColoring(click.x-1,DLy);
                DLy --;
            }
        }


        Control.thisChoosImage.setRGB(click.x,click.y, click.color.getRGB());
    }

    void DfsTRColoring(int x, int y){

        if(x <0  || x >= Control.thisChoosImage.getWidth()){
            return;
        }

        else if (Control.thisChoosImageVisit[x][y]) {
            return;

        }
        else if (Control.thisChoosImage.getRGB(x,y) !=Control.thisChoosImage.getRGB(click.x,click.y)) {
            return;
        } else {
            Control.thisChoosImageVisit[x][y]=true;
            Control.thisChoosImage.setRGB(x,y, click.color.getRGB());
            DfsTRColoring(x+1,y);

        }

    }

    void DfsTLColoring(int x, int y){

        if(x <0  || x >= Control.thisChoosImage.getWidth()){
            return;
        }

        else if (Control.thisChoosImageVisit[x][y]) {
            return;

        }
        else if (Control.thisChoosImage.getRGB(x,y) !=Control.thisChoosImage.getRGB(click.x,click.y)) {
            return;
        } else {
            Control.thisChoosImageVisit[x][y]=true;
            Control.thisChoosImage.setRGB(x,y, click.color.getRGB());
            DfsTLColoring(x-1,y);

        }

    }


    void DfsDRColoring(int x, int y){

        if(x <0  || x >= Control.thisChoosImage.getWidth()){
            return;
        }

        else if (Control.thisChoosImageVisit[x][y]) {
            return;

        }
        else if (Control.thisChoosImage.getRGB(x,y) !=Control.thisChoosImage.getRGB(click.x,click.y)) {
            return;
        } else {
            Control.thisChoosImageVisit[x][y]=true;
            Control.thisChoosImage.setRGB(x,y, click.color.getRGB());
            DfsDRColoring(x+1,y);

        }

    }

    void DfsDLColoring(int x, int y){

        if(x <0  || x >= Control.thisChoosImage.getWidth()){
            return;
        }

        else if (Control.thisChoosImageVisit[x][y]) {
            return;

        }
        else if (Control.thisChoosImage.getRGB(x,y) !=Control.thisChoosImage.getRGB(click.x,click.y)) {
            return;
        } else {
            Control.thisChoosImageVisit[x][y]=true;
            Control.thisChoosImage.setRGB(x,y, click.color.getRGB());
            DfsDLColoring(x-1,y);

        }

    }


}
