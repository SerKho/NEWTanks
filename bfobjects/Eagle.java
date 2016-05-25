package Tanks.bfobjects;

import Tanks.ActionField;
import Tanks.interfaces.Destroyable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by 777 on 20.03.2016.
 */
public class Eagle extends BFObject implements Destroyable {
    private String Image_Name = "Eagle.jpg";
    private Image iEagle;

    public Eagle(ActionField af, int x, int y){
        super(af,x,y);
        this.setCrossable(false);
        try{
            iEagle = ImageIO.read(new File(Image_Name));
        }
        catch (IOException e){
            System.err.println("Can't find file: " + Image_Name);
        }
    }

    public void draw(Graphics g){
//        g.setColor(new Color(255, 215, 0));
//        g.fillRect(this.getY(), this.getX(), 64, 64);
        g.drawImage(iEagle, this.getY(), this.getX(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    public void destroy(){
        this.setX(-1000);
        this.setY(-1000);
        af.repaint();

    }
}

