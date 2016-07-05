package Tanks;

import Tanks.bfobjects.BFObject;
import Tanks.bfobjects.Brick;
import Tanks.bfobjects.Eagle;
import Tanks.bfobjects.Rock;
import Tanks.enums.*;
import Tanks.enums.Action;
import Tanks.interfaces.BattleField;
import Tanks.tankobjects.AbstractTank;
import Tanks.tankobjects.BT7;
import Tanks.tankobjects.T34;
import Tanks.tankobjects.Tiger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.security.cert.Extension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by 777 on 15.02.2016.
 */
public class ActionField extends JPanel {
    private final boolean COLORDED_MODE = false;
    private BattleField battleField;
    private AbstractTank defender;
    private AbstractTank agressor;
    private Bullet bullet;
    private final String[] MOVE = {"Illegal move", "Move UP", "Move DOWN", "Move LEFT", "Move RIGHT"};
    private int step = 1;
    private boolean gameOver = false;
    private File file;
    private int tankNumber = 0;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public boolean isCOLORDED_MODE() {
        return COLORDED_MODE;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public AbstractTank getDefender() {
        return defender;
    }

    public void setDefender(AbstractTank defender) {
        this.defender = defender;
    }

    public AbstractTank getAgressor() {
        return agressor;
    }

    public void setAgressor(AbstractTank agressor) {
        this.agressor = agressor;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public ActionField(int at) throws Exception {
        File[] roots = File.listRoots();
        String separator = File.separator;
        SimpleDateFormat formatter = new SimpleDateFormat("EEE_MMM_d_hh_mm_ss");
        Date currentTime_1 = new Date();
        String dateString = formatter.format(currentTime_1);
        file = new File(roots[0].getPath() + separator + "Tanks");
        if (Files.isDirectory(file.toPath())) {
            Files.createDirectory(new File(file.getAbsolutePath() + separator + dateString).toPath());
            file = new File(file.getAbsolutePath() + separator + dateString);
        } else {
            Files.createDirectory(file.toPath());
            Files.createDirectory(new File(file.getAbsolutePath() + separator + dateString).toPath());
            file = new File(file.getAbsolutePath() + separator + dateString);
        }


        battleField = new BattleField(this);
        defender = new T34(battleField, "Tank" + (++tankNumber), new File(file.getAbsolutePath() + separator + "Tank" + tankNumber));
//        agressor = new Tiger(battleField, AbstractTank.POSITION[(int)(Math.random()*3)],0, Direction.DOWN);
        bullet = new Bullet(-100, -100, Direction.UP, this.defender);
        if (at > 0) {
            agressor = new BT7(battleField, AbstractTank.POSITION[(int) (Math.random() * 3)], 0, Direction.DOWN,
                    "Tank" + (++tankNumber), new File(file.getAbsolutePath() + separator + "Tank" + tankNumber));
//            agressor = new BT7(battleField, 128,512, Direction.DOWN);
        }


        if (at < 0) {
            agressor = new Tiger(battleField, AbstractTank.POSITION[(int) (Math.random() * 3)], 0, Direction.DOWN,
                    "Tank" + (++tankNumber), new File(file.getAbsolutePath() + separator + "Tank" + tankNumber));
        }
        this.setGameOver(false);
        this.setSize(576 + 16, 576 + 39);
        this.setLayout(null);
        this.setLocation(0, 0);
//        JFrame frame = new JFrame("BATTLE FIELD");
//        frame.setLocation(400, 50);


//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Menu");
//        menuBar.add(menu);
//        frame.setJMenuBar(menuBar);
//        JMenu menuItem = new JMenu("Set agressor");
//        JMenuItem menuItem1 = new JRadioButtonMenuItem("BT7");
//        JMenuItem menuItem2 = new JRadioButtonMenuItem("Tiger");
//        JMenuItem menuItem3 = new JMenuItem("Run new game");
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(menuItem1);
//        bg.add(menuItem2);
//        menuItem1.setSelected(true);
//        menuItem.add(menuItem1);
//        menuItem.add(menuItem2);
//        menu.add(menuItem);
//        menu.add(menuItem3);
//        menuItem1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agressor = new BT7(battleField, AbstractTank.POSITION[(int)(Math.random()*3)],0, Direction.DOWN);
//                repaint();
//            }
//        });
//        menuItem2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                agressor = new Tiger(battleField, AbstractTank.POSITION[(int)(Math.random()*3)],0, Direction.DOWN);
//                repaint();
//            }
//        });
//        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH() + 16, battleField.getBF_HEIGHT() + 39));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.getContentPane().add(this);
//        frame.pack();
//        frame.setVisible(true);
//        runTheGame();
//        this.removeAll();
//        JButton button1 = new JButton("Play again");
//        button1.setSize(100,30);
//        button1.setLocation(230,300);
//        JButton button2 = new JButton("Exit");
//        button2.setSize(100,30);
//        button2.setLocation(230,340);
//        button1.setBackground(Color.GREEN);
//        button2.setBackground(Color.GREEN);
//        this.setLayout(null);
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//
//                    frame.dispose();
//                    frame.getContentPane().add(new ActionField(getAgressor()));
//                    frame.pack();
//                    frame.setVisible(true);
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//        this.add(button1);
//        this.add(button2);
//        this.revalidate();
//        this.updateUI();
    }

    public void runTheGame() throws Exception {
        Thread.sleep(1000);
        if (agressor instanceof Tiger) {
            runTheGameTiger();
        } else {
            runTheGameBT7();

        }
    }

    public void runTheGameTiger() throws Exception {
        Thread.sleep(1000);
        while (true) {
            if (this.getBattleField().getBattleField()[8][4] instanceof Eagle && defender.isDestroyed() == false) {
                agressor.setPath(agressor.defenderDestroyAlgoritm(defender.getX() / 64, defender.getY() / 64));
                Iterator<Action> b = agressor.getPath().iterator();
                while (b.hasNext()) {
                    if (defender.isDestroyed() == true) {
                        break;
                    }
                    agressor.setAction(b.next());
                    tankAction(agressor);
                    if (defender.isDestroyed() == true) {
                        break;
                    }
                    defender.setAction(AbstractTank.randomAction());
                    tankAction(defender);
                }
            } else {
                break;
            }
        }
    }

    public void runTheGameBT7() throws Exception {
        Thread.sleep(1000);
        int i = 0;
        while (i == 0) {
            if (this.getBattleField().getBattleField()[8][4] instanceof Eagle && defender.isDestroyed() == false) {
                agressor.setPath(agressor.eagleDestroyAlgoritm1());
                Iterator<Action> b = agressor.getPath().iterator();
                while (b.hasNext()) {
                    if (!(this.getBattleField().getBattleField()[8][4] instanceof Eagle)) {
                        i = 1;
                    }
                    agressor.setAction(b.next());
                    tankAction(agressor);
                    defender.setAction(AbstractTank.randomAction());
                    tankAction(defender);
                }
            } else {
                i = 1;
            }
        }
    }


    private boolean processInterception() {
        if ((bullet.getX() >= 10 && bullet.getX() <= 566) && (bullet.getY() >= 10 && bullet.getY() <= 566)) {
            if (getQuadrant(bullet.getAbstractTank().getX(), bullet.getAbstractTank().getY()).equals
                    (getQuadrant(bullet.getX(), bullet.getY()))) {
                return false;
            } else if (battleField.scanBattleField(bulletQuadrant(0), bulletQuadrant(2)) instanceof Brick) {
                ((Brick) battleField.scanBattleField(bulletQuadrant(0), bulletQuadrant(2))).destroy();
                this.battleField.updateQuadrant(bulletQuadrant(0), bulletQuadrant(2),
                        new BFObject(this, bulletQuadrant(0) + 1, bulletQuadrant(2) + 1));
                return true;
            } else if ((battleField.scanBattleField(bulletQuadrant(0), bulletQuadrant(2)) instanceof Rock) &&
                    ((battleField.scanBattleField(bulletQuadrant(0), bulletQuadrant(2)).getX() > 0))) {
////                ((Rock) battleField.scanBattleField(bulletQuadrant(0),bulletQuadrant(2))).destroy();
                return true;
            } else if ((battleField.scanBattleField(bulletQuadrant(0), bulletQuadrant(2)) instanceof Eagle) &&
                    ((battleField.scanBattleField(bulletQuadrant(0), bulletQuadrant(2)).getX() > 0))) {
                ((Eagle) battleField.scanBattleField(bulletQuadrant(0), bulletQuadrant(2))).destroy();
                this.battleField.updateQuadrant(bulletQuadrant(0), bulletQuadrant(2),
                        new BFObject(this, bulletQuadrant(0) + 1, bulletQuadrant(2) + 1));
                return true;

            } else if (getQuadrant(agressor.getX(), agressor.getY()).equals(getQuadrant(bullet.getX(), bullet.getY()))) {
                agressor.destroy();
                return true;
            } else if (getQuadrant(defender.getX(), defender.getY()).equals(getQuadrant(bullet.getX(), bullet.getY()))) {
                defender.destroy();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private int bulletQuadrant(int coordinate) {
        return Integer.parseInt((getQuadrant(bullet.getX(), bullet.getY()) + "0").substring(coordinate, coordinate + 1));
    }

    public String getQuadrant(int x, int y) {

        return y / 64 + "_" + x / 64;
    }

    public String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        if(this.isGameOver()==false) {

//            int i = 0;
//            Color cc;
//            for (int v = 0; v < 9; v++) {
//                for (int h = 0; h < 9; h++) {
//                    if (COLORDED_MODE) {
//                        if (i % 2 == 0) {
//                            cc = new Color(252, 241, 177);
//                        } else {
//                            cc = new Color(233, 243, 255);
//                        }
//                    } else {
//                        cc = new Color(180, 180, 180);
//                    }
//                    i++;
//                    g.setColor(cc);
//                    g.fillRect(h * 64, v * 64, 64, 64);
//                }
//            }

        for (int j = 0; j < battleField.getDimensionY(); j++) {
            for (int k = 0; k < battleField.getDimensionY(); k++) {
                battleField.scanBattleField(j, k).draw(g);
            }
        }

        agressor.draw(g);
        defender.draw(g);
        bullet.draw(g);
//        }
//        else{
//            g.setColor(Color.BLACK);
//            g.fillRect(0,0,800,600);
//            g.setColor(Color.RED);
//            g.setFont(new Font("Garamond", Font.BOLD, 60));
//            g.drawString("GAME OVER", 100, 200);
//
//        }
    }

    public void processTurn(AbstractTank tank, Direction direction) throws Exception {
        tank.setDirection(direction);
        writeActionToFile(tank, "Turn"+direction.toString());
        System.out.println("Turn " + direction);
        repaint();
    }

    public void processMove(AbstractTank tank) throws Exception {
        if (movePossibility(tank, tank.getDirection().getDirection()) == 0) {
            System.out.println("TankX=" + tank.getX() + "; TankY=" + tank.getY() + "." + MOVE[0]);
            return;
        } else {
            int covered = 0;
            while (covered < 64) {
                tank.updateX(vertOrHor(tank.getDirection().getDirection()) * positivOrNegativ(tank.getDirection().getDirection()) * step);
                tank.updateY((1 - vertOrHor(tank.getDirection().getDirection())) * positivOrNegativ(tank.getDirection().getDirection()) * step);
                System.out.println("TankX=" + tank.getX() + "; TankY=" + tank.getY() + "." + MOVE[tank.getDirection().getDirection()]);
                covered += step;
                repaint();
                Thread.sleep(tank.getSpeed());
            }
            writeActionToFile(tank, MOVE[tank.getDirection().getDirection()]);
        }

    }

    private int movePossibility(AbstractTank tank, int direction) {
        if ((direction < 1 || direction > 4) || (direction == 1 && tank.getY() == 0) || (direction == 2 && tank.getY() == 512)
                || (direction == 3 && tank.getX() == 0) || (direction == 4 && tank.getX() == 512) ||
                (direction == 1 && !(battleField.scanBattleField((tank.getY() - 1) / 64, (tank.getX()) / 64).isCrossable())) ||
                (direction == 2 && !(battleField.scanBattleField((tank.getY() + 64) / 64, tank.getX() / 64).isCrossable())) ||
                (direction == 3 && !(battleField.scanBattleField((tank.getY()) / 64, (tank.getX() - 1) / 64).isCrossable())) ||
                (direction == 4 && !(battleField.scanBattleField(tank.getY() / 64, (tank.getX() + 64) / 64).isCrossable()))) {
            return 0;
        } else {
            return 1;
        }
    }

    public void processFire(AbstractTank tank) throws Exception {
        this.bullet = new Bullet(tank.getX() + 25, tank.getY() + 25, tank.getDirection(), tank);
        while (bullet.getY() >= 0 && bullet.getY() <= 576 && bullet.getX() >= 0 && bullet.getX() <= 576) {
            bullet.updateX(vertOrHor(tank.getDirection().getDirection()) * positivOrNegativ(tank.getDirection().getDirection()) * bullet.getSpeed());
            bullet.updateY((1 - vertOrHor(tank.getDirection().getDirection())) * positivOrNegativ(tank.getDirection().getDirection()) * bullet.getSpeed());
            if (processInterception() == true) {
                break;
            }
            repaint();
            Thread.sleep(tank.getSpeed());
        }
        writeActionToFile(tank, "FIRE");
        bullet.destroy();
        repaint();
    }

    private int vertOrHor(int direction) {
        if (direction < 3) {
            return 0;
        } else {
            return 1;
        }
    }

    private int positivOrNegativ(int direction) {
        if (direction == 2 || direction == 4) {
            return 1;
        } else {
            return -1;
        }
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void tankAction(AbstractTank tank) throws Exception {
        if (tank.setUp().equals(Action.MOVE_UP)) {
            this.processTurn(tank, Direction.UP);
            this.processMove(tank);
        } else if (tank.setUp().equals(Action.MOVE_DOWN)) {
            this.processTurn(tank, Direction.DOWN);
            this.processMove(tank);
        } else if (tank.setUp().equals(Action.MOVE_LEFT)) {
            this.processTurn(tank, Direction.LEFT);
            this.processMove(tank);
        } else if (tank.setUp().equals(Action.MOVE_RIGHT)) {
            this.processTurn(tank, Direction.RIGHT);
            this.processMove(tank);
        } else if (tank.setUp().equals(Action.TURN_UP)) {
            this.processTurn(tank, Direction.UP);
        } else if (tank.setUp().equals(Action.TURN_DOWN)) {
            this.processTurn(tank, Direction.DOWN);
        } else if (tank.setUp().equals(Action.TURN_LEFT)) {
            this.processTurn(tank, Direction.LEFT);
        } else if (tank.setUp().equals(Action.TURN_RIGHT)) {
            this.processTurn(tank, Direction.RIGHT);
        } else if (tank.setUp().equals(Action.FIRE)) {
            this.processFire(tank);
        } else {
        }

    }

    public static void writeActionToFile(AbstractTank tank, String data) {
        try (FileWriter fr = new FileWriter(tank.getFile(), true)) {
            fr.write("||" + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
