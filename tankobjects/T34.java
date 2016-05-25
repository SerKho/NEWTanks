package Tanks.tankobjects;

import Tanks.ActionField;
import Tanks.enums.Direction;
import Tanks.interfaces.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by 777 on 15.03.2016.
 */
public class T34 extends AbstractTank {
    private String[] Image_Name = new String[]{"T34_UP.gif", "T34_DOWN.gif", "T34_LEFT.gif", "T34_RIGHT.gif"};
    private Image iT34;
   public T34(BattleField bf){
        super(bf);
    }
   public T34(BattleField bf, int x, int y, Direction direction){
        super(bf, x, y, direction);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (this.getDirection().getDirection() == 1) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iT34 = ImageIO.read(new File(Image_Name[0]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }
        }
        if (this.getDirection().getDirection() == 2) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iT34 = ImageIO.read(new File(Image_Name[1]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }
        }
        if (this.getDirection().getDirection() == 3) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iT34 = ImageIO.read(new File(Image_Name[2]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }
        }
        if (this.getDirection().getDirection() == 4) {
            try{
                g2.setComposite(this.setTransperancy(this.getBf(), this.getX(), this.getY()));
                iT34 = ImageIO.read(new File(Image_Name[3]));
            }
            catch (IOException e){
                System.err.println("Can't find file: " + Image_Name);
            }

        }
        g.drawImage(iT34, this.getX(), this.getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
        g2.setComposite(normal);
    }
}
