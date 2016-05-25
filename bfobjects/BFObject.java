package Tanks.bfobjects;

import Tanks.ActionField;
import Tanks.interfaces.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by 777 on 20.03.2016.
 */
public class BFObject implements Drawable{
    int x;
    int y;
    boolean crossable;
    ActionField af;
    private String Image_Name1 = "BFObject.jpg";
    private Image iBFObject;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCrossable() {
        return crossable;
    }

    public void setCrossable(boolean crossable) {
        this.crossable = crossable;
    }

    public ActionField getAf() {
        return af;
    }

    public BFObject(ActionField af, int x, int y){
        this.af = af;
        this.x = (x-1)*64;
        this.y = (y-1)*64;
        this.setCrossable(true);
        try{
            iBFObject = ImageIO.read(new File(Image_Name1));
        }
        catch (IOException e){
            System.err.println("Can't find file: " + Image_Name1);
        }
    }


    public void draw(Graphics g){
        g.drawImage(iBFObject, this.getY(), this.getX(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
