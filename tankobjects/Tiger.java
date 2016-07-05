package Tanks.tankobjects;

import Tanks.ActionField;
import Tanks.bfobjects.Water;
import Tanks.enums.Direction;
import Tanks.interfaces.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by 777 on 04.03.2016.
 */
public class Tiger extends AbstractTank {
    private String[] Image_Name = new String[]{"Tiger_UP.gif", "Tiger_DOWN.gif", "Tiger_LEFT.gif", "Tiger_RIGHT.gif"};
    private Image iTiger;
    private int armor = 1;

    public Tiger(BattleField bf, int x, int y, Direction direction, String tankName, File file){
        super(bf, x, y, direction, tankName, file);
//        this.setPath();
    }

    public Tiger(BattleField bf, String tankName, File file){
        super(bf, tankName, file);
    }


    public int getArmor() {
        return armor;
    }

    public void updateArmor(int i){
        armor+=i;
        if(armor<0){
            armor = 0;
        }
    }

    @Override
    public void destroy() {
        if(armor>0){
            updateArmor(-1);
        }
        else {
            super.destroy();
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (this.getDirection().getDirection() == 1) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iTiger = ImageIO.read(new File(Image_Name[0]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }
        }
        if (this.getDirection().getDirection() == 2) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iTiger = ImageIO.read(new File(Image_Name[1]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }
        }
        if (this.getDirection().getDirection() == 3) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iTiger = ImageIO.read(new File(Image_Name[2]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }
        }
        if (this.getDirection().getDirection() == 4) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iTiger = ImageIO.read(new File(Image_Name[3]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }
        }
        g.drawImage(iTiger, this.getX(), this.getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
        g2.setComposite(normal);
    }
}
