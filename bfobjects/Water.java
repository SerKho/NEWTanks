package Tanks.bfobjects;

import Tanks.ActionField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by 777 on 20.03.2016.
 */
public class Water extends BFObject {

    private String Image_Name = "Water.jpg";
    private Image iWater;

    public Water(ActionField af, int x, int y){
        super(af, x, y);
        this.setCrossable(true);
        try{
            iWater = ImageIO.read(new File(Image_Name));
        }
        catch (IOException e){
            System.err.println("Can't find file: " + Image_Name);
        }
    }

    public void draw(Graphics g){

        g.drawImage(iWater, this.getY(), this.getX(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

    }
}
