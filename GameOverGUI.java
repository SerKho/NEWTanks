package Tanks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 777 on 05.06.2016.
 */
public class GameOverGUI extends JPanel {

    private boolean playAgain = false;

    public boolean isPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
    }



    public GameOverGUI(){

        this.setSize(576 + 16,576 + 39);
        this.setLayout(null);
        JButton button1 = new JButton("Play again");
        button1.setSize(100,30);
        button1.setLocation(230,300);
        JButton button2 = new JButton("Exit");
        button2.setSize(100,30);
        button2.setLocation(230,340);
        button1.setBackground(Color.GREEN);
        button2.setBackground(Color.GREEN);

        this.add(button1);
        this.add(button2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayAgain(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,600);
        g.setColor(Color.RED);
        g.setFont(new Font("Garamond", Font.BOLD, 60));
        g.drawString("GAME OVER", 100, 200);
    }
}
