package Tanks;

//import com.sun.java.util.jar.pack.Package;


import javax.swing.*;
import java.awt.*;

/**
 * Created by 777 on 17.02.2016.
 */
public class Launcher {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("BATTLE FIELD");
        frame.setLocation(400, 50);
        frame.setMinimumSize(new Dimension(576 + 16, 576 + 39));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setSize(576,576);
        panel.setLocation(400,50);
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        while (true) {
            StartGUI s = new StartGUI();
            panel.removeAll();
            panel.add(s);
            panel.revalidate();
            panel.updateUI();
            boolean b = false;
            while (b == false) {
                Thread.sleep(50);
                b = s.gameStart;
            }
            ActionField af = new ActionField(s.at);
//            frame.dispose();
            panel.removeAll();
            panel.add(af);
            panel.revalidate();
            panel.updateUI();
            af.runTheGame();
            Thread.sleep(2000);
            GameOverGUI go = new GameOverGUI();
            panel.removeAll();
            panel.add(go);
            panel.revalidate();
            panel.updateUI();
            boolean b1 = false;
            System.out.println("1");

            while (b1==false){
                Thread.sleep(50);
                b1 = go.isPlayAgain();
            }
            System.out.println("2");
        }
    }
}

