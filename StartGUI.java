package Tanks;

import Tanks.ActionField;
import Tanks.interfaces.BattleField;
import Tanks.tankobjects.AbstractTank;
import Tanks.tankobjects.BT7;
import Tanks.tankobjects.Tiger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 777 on 04.06.2016.
 */
public class StartGUI extends JPanel{
    public AbstractTank at = new BT7(new BattleField());
    public boolean gameStart = false;

    public StartGUI(){


        this.setBackground(new Color(0,204,102));
        this.setSize(576 + 16,576 + 39);
        this.setLayout(null);
        JLabel labelB = new JLabel("BATTLEFIELD");
        labelB.setFont(new Font("Garamond", Font.BOLD, 60));
        labelB.setSize(500,200);
        labelB.setLocation(100,20);
        JLabel label = new JLabel("Select agressor type:");
        label.setFont(new Font("Garamond", Font.BOLD, 20));
        label.setSize(250,50);
        label.setLocation(200,300);
        JRadioButton rb1 = new JRadioButton("BT7");
        rb1.setFont(new Font("Garamond", Font.BOLD, 15));
        JRadioButton rb2 = new JRadioButton("Tiger");
        rb1.setSelected(true);
        rb2.setFont(new Font("Garamond", Font.BOLD, 15));
        ButtonGroup bg = new ButtonGroup();
        rb1.setBackground(new Color(0,204,102));
        rb2.setBackground(new Color(0,204,102));
        rb1.setSize(100,50);rb2.setSize(100,50);
        rb1.setLocation(270,350);
        rb2.setLocation(270,400);
        bg.add(rb1);
        bg.add(rb2);
        JButton b1 = new JButton("Start the game");
        b1.setFont(new Font("Garamond", Font.BOLD, 20));
        b1.setSize(200,50);
        b1.setLocation(200,450);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rb2.isSelected()){
                    at = new Tiger( new BattleField());
                }
//                frame.dispose();
//                try {
//                    f();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
                gameStart = true;
            }
        });
        this.add(labelB);
        this.add(label);
        this.add(rb1);
        this.add(rb2);
        this.add(b1);

    }
}
