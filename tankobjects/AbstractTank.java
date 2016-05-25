package Tanks.tankobjects;

import Tanks.ActionField;
import Tanks.Bullet;
import Tanks.bfobjects.Brick;
import Tanks.bfobjects.Eagle;
import Tanks.bfobjects.Rock;
import Tanks.bfobjects.Water;
import Tanks.enums.Action;
import Tanks.enums.Direction;
import Tanks.interfaces.BattleField;
import Tanks.interfaces.Destroyable;
import Tanks.interfaces.Drawable;

import java.awt.*;
import java.util.*;

/**
 * Created by 777 on 16.02.2016.
 */
public abstract class AbstractTank implements Drawable, Destroyable {
    Composite normal = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
    Composite transp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
    public final static int[] POSITION = {0, 256, 512};
    private int speed = 10;
    private int x;
    private int y;
    private LinkedList<Action> path;
    private Action previousAction = Action.MOVE_DOWN;
    private Direction direction;
    private boolean isDestroyed;
    public final static Action[] MOVES = {Action.MOVE_UP, Action.MOVE_DOWN, Action.MOVE_LEFT, Action.MOVE_RIGHT};

    private BattleField bf;
    private Action action;

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public LinkedList<Action> getPath() {
        return path;
    }

    public void setPath(LinkedList<Action> a) {
        this.path = a;
    }

    public Action getPreviousAction() {
        return previousAction;
    }

    public void setPreviousAction(Action previousAction) {
        this.previousAction = previousAction;
    }

   public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void updateX(int x){
        this.x+=x;
    }

    public void updateY(int y){
        this.y+=y;
    }


    AbstractTank(BattleField bf){
        this(bf,384,512, Direction.UP);
    }

    AbstractTank(BattleField bf, int x, int y, Direction direction) {
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.setDestroyed(false);
//        this.setPath();
    }

    public Action setUp(){
        return getAction();
    }

    public BattleField getBf() {
        return bf;
    }



    public void destroy(){
        updateX(-1000);
        updateY(-1000);
        this.setDestroyed(true);
    }

    public void draw(Graphics g){
        g.setColor(new Color(255, 0, 0));
        g.fillRect(this.getX(), this.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (this.getDirection().getDirection() == 1) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection().getDirection() == 2) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection().getDirection() == 3) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
    }

//- Algoritm 1 Start -
//    public Action eagleDestroyAlgoritm(){
//        if(readyToDestroyEagle(this)==true){
//            if (readyToShoot(this)==true) {
//                if(isAimed()==true){
//                    return Action.FIRE;
//                }
//                else{
//                    return aimAtEagle();
//                }
//            }
//            else {
//                if(movePossibility(getPreviousAction())==true){
//                    return getPreviousAction();
//                }
//                else{
//                    if(nextIsBrick(getPreviousAction())==true){
//                        return Action.FIRE;
//                    }
//                    else {
//                        return randomMove();
//                    }
//                }
//            }
//        }
//        else {
//            if (movePossibility(getPreviousAction()) == true) {
//                return getPreviousAction();
//            } else {
//                if (nextIsBrick(getPreviousAction()) == true) {
//                    return Action.FIRE;
//                } else {
//                    return randomMove();
//                }
//            }
//        }
//    }
//
//    private boolean readyToDestroyEagle(AbstractTank tank){
//        if(tank.getX()==256 || tank.getY()==512){
//            return true;
//        }
//        else{
//            return  false;
//        }
//    }
//
//    private boolean readyToShoot(AbstractTank tank){
//        if(tank.getX()==256){
//            for (int i = tank.getY()/64; i<9; i++){
//                if (tank.getBf().getBattleField()[i][4] instanceof Rock){
//                    return false;
//                }
//            }
//            return true;
//        }
//        if(tank.getY()==512){
//            if (tank.getX()>256){
//                for(int i = tank.getX()/64; i>4; i-- ) {
//                    if(tank.getBf().getBattleField()[8][i] instanceof Rock){
//                        return false;
//                    }
//                }
//                return true;
//            }
//            else{
//                for(int i = tank.getX()/64; i<5; i++ ) {
//                    if(tank.getBf().getBattleField()[8][i] instanceof Rock){
//                        return false;
//                    }
//                }
//                return true;
//
//            }
//        }
//        return false;
//    }
//
//    private Action randomMove(){
//        setPreviousAction(MOVES[(int)(Math.random() * 4)]);
//        return Action.NONE;
//    }
//
//    private boolean movePossibility(Action a){
//        if(a.equals(Action.MOVE_UP)){
//            if (this.getY()==0 || this.getBf().getBattleField()[(this.getY()/64)-1][this.getX()/64] instanceof Brick ||
//                    this.getBf().getBattleField()[(this.getY()/64)-1][this.getX()/64] instanceof Water ||
//                    this.getBf().getBattleField()[(this.getY()/64)-1][this.getX()/64] instanceof Rock) {
//                return false;
//            }
//            else { return true;}
//        }
//        else if(a.equals(Action.MOVE_DOWN)){
//            if (this.getY()==512 || this.getBf().getBattleField()[(this.getY()/64)+1][this.getX()/64] instanceof Brick ||
//                    this.getBf().getBattleField()[(this.getY()/64)+1][this.getX()/64] instanceof Water ||
//                    this.getBf().getBattleField()[(this.getY()/64)+1][this.getX()/64] instanceof Rock) {
//                return false;
//            }
//            else { return true;}
//        }
//        else if(a.equals(Action.MOVE_LEFT)){
//            if (this.getX()==0 || this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)-1] instanceof Brick ||
//                    this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)-1] instanceof Water ||
//                    this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)-1] instanceof Rock) {
//                return false;
//            }
//            else { return true;}
//        }
//        else if(a.equals(Action.MOVE_RIGHT)){
//            if (this.getX()==512 || this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)+1] instanceof Brick ||
//                    this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)+1] instanceof Water ||
//                    this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)+1] instanceof Rock) {
//                return false;
//            }
//            else { return true;}
//        }
//        else{
//            return false;
//        }
//    }
//
//    private boolean nextIsBrick(Action a){
//        if(a.equals(Action.MOVE_UP) && this.getY()>0 &&
//                this.getBf().getBattleField()[(this.getY()/64)-1][this.getX()/64] instanceof Brick){
//            return true;}
//        else if(a.equals(Action.MOVE_DOWN) && this.getY()<512 &&
//                this.getBf().getBattleField()[(this.getY()/64)+1][this.getX()/64] instanceof Brick){
//            return true;
//        }
//        else if(a.equals(Action.MOVE_LEFT) && this.getX()>0 &&
//                this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)-1] instanceof Brick) {
//            return true;
//        }
//        else if(a.equals(Action.MOVE_RIGHT) && this.getX()<512 &&
//                this.getBf().getBattleField()[this.getY()/64][(this.getX()/64)+1] instanceof Brick) {
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//
//    private boolean isAimed(){
//        if((this.getX()==256 && this.getDirection().equals(Direction.DOWN)) ||
//                (this.getY()==512 && this.getX()<256 && this.getDirection().equals(Direction.RIGHT)) ||
//                (this.getY()==512 && this.getX()>256 && this.getDirection().equals(Direction.LEFT))){
//            return true;
//        }
//        return false;
//    }
//
//    private Action aimAtEagle(){
//        if(this.getX()==256 && !(this.getDirection().equals(Direction.DOWN))){
//            return Action.TURN_DOWN;
//        }
//        else if(this.getY()==512 && this.getX()>256 && this.getDirection().equals(Direction.DOWN)){
//            return Action.TURN_LEFT;
//        }
//        else{
//            return Action.TURN_RIGHT;
//        }
//    }
//- Algoritm 1 Finish -

    public LinkedList<Action> eagleDestroyAlgoritm1() {
        LinkedList<Action> res = new  LinkedList<Action>();
        res.addFirst(Action.FIRE);
        int pathLength = 0;
        int[][] array = new int[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(bf.getBattleField()[i][j]instanceof Brick){
                    array[i][j] = 100;
                    continue;
                }
                if(bf.getBattleField()[i][j]instanceof Rock){
                    array[i][j] = 300;
                    continue;
                }
//                if(bf.getBattleField()[i][j]instanceof Water){
//                    array[i][j] = 200;
//                    continue;
//                }
                array[i][j] = 0;
            }
        }
        array[this.getY()/64][this.getX()/64] = 1;

        ArrayList<String> even = new ArrayList<String>();
        ArrayList<String> odd = new ArrayList<String>();
        even.add(Integer.toString(this.getX()/64) + Integer.toString(this.getY()/64));

        for(int i=2; i<50; i++) {
            ArrayList<String> work, reserv;
            if(array[8][4]==0){
                if(i%2==0){
                    work = even;
                    reserv = odd;
                }
                else{
                    work = odd;
                    reserv = even;
                }
                Iterator<String> iterator = work.iterator();
                while (iterator.hasNext()) {
                    String xy = iterator.next();
                    int x = Integer.parseInt(xy.substring(0,1));
                    int y = Integer.parseInt(xy.substring(1));

//                    System.out.print(x); System.out.println(y);


                        if(x-1>=0 && array[y][x-1]==0){
                            array[y][x-1]=i;
                            reserv.add(Integer.toString(x-1) + Integer.toString(y));
                        }
                        if(x-1>=0 && array[y][x-1]==100){
                            array[y][x-1]=-i;
                            reserv.add(Integer.toString(x-1) + Integer.toString(y));
                        }
                        if(x+1<9 && array[y][x+1]==0){
                            array[y][x+1]=i;
                            reserv.add(Integer.toString(x+1) + Integer.toString(y));
                        }
                        if(x+1<9 && array[y][x+1]==100){
                            array[y][x+1]=-i;
                            reserv.add(Integer.toString(x+1) + Integer.toString(y));
                        }
                        if(y-1>=0 && array[y-1][x]==0){
                            array[y-1][x]=i;
                            reserv.add(Integer.toString(x) + Integer.toString(y-1));
                        }
                        if(y-1>=0 && array[y-1][x]==100){
                            array[y-1][x]=-i;
                            reserv.add(Integer.toString(x) + Integer.toString(y-1));
                        }
                        if(y+1<9 && array[y+1][x]==0){
                            array[y+1][x]=i;
                            reserv.add(Integer.toString(x) + Integer.toString(y+1));
                        }
                        if(y+1<9 && array[y+1][x]==100){
                            array[y+1][x]=-i;
                            reserv.add(Integer.toString(x) + Integer.toString(y+1));
                        }


                }
                work.clear();
            }
            else{
                pathLength = array[8][4];
            }
        }

        for(int k = 0; k<9; k++){
            for(int k1 = 0; k1<9; k1++) {
                System.out.print(array[k][k1] + " ");
            }
            System.out.println("");
        }
        System.out.println("PathLength="+pathLength);

        int x = 4, y = 8;
        for(int i = pathLength-1;i>0; i--){
            if((x-1>=0) && ((array[y][x-1]==i) || (array[y][x-1]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_RIGHT);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_RIGHT);
                }
                else{
                    res.addFirst(Action.MOVE_RIGHT);
                }
                x=x-1;
                System.out.println("i="+i + " MOVE_RIGHT added.");
                continue;
            }
            if(((y-1)>=0) && ((array[y-1][x]==i) || (array[y-1][x]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_DOWN);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_DOWN);
                }
                else{
                    res.addFirst(Action.MOVE_DOWN);
                }
                y=y-1;
                System.out.println("i="+i + " MOVE_DOWN added.");
                continue;
            }
            if((x+1<=8) && ((array[y][x+1]==i) || (array[y][x+1]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_LEFT);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_LEFT);
                }
                else{
                    res.addFirst(Action.MOVE_LEFT);
                }
                x=x+1;
                System.out.println("i="+i + " MOVE_LEFT added.");
                continue;
            }
            if((y+1<=8) && ((array[y+1][x]==i) || (array[y+1][x]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_UP);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_UP);
                }
                else{
                    res.addFirst(Action.MOVE_UP);
                }
                x=x+1;
                System.out.println("i="+i + " MOVE_UP added.");
                continue;
            }
            System.out.println("x="+x + " y="+y);System.out.println("y-1="+array[y-1][x]);
            System.out.println("i="+i + " No move added.");
        }
        System.out.println(res.size());
        return res;
    }



    public LinkedList<Action> defenderDestroyAlgoritm(int x, int y) {
        LinkedList<Action> res = new  LinkedList<Action>();
        res.addFirst(Action.FIRE);
        int pathLength = 0;
        int[][] array = new int[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(bf.getBattleField()[i][j]instanceof Brick){
                    array[i][j] = 100;
                    continue;
                }
                if(bf.getBattleField()[i][j]instanceof Rock){
                    array[i][j] = 300;
                    continue;
                }
                if(bf.getBattleField()[i][j]instanceof Eagle){
                    array[i][j] = 200;
                    continue;
                }
                array[i][j] = 0;
            }
        }
        array[this.getY()/64][this.getX()/64] = 1;

        ArrayList<String> even = new ArrayList<String>();
        ArrayList<String> odd = new ArrayList<String>();
        even.add(Integer.toString(this.getX()/64) + Integer.toString(this.getY()/64));

        for(int i=2; i<50; i++) {
            ArrayList<String> work, reserv;
            if(array[y][x]==0){
                if(i%2==0){
                    work = even;
                    reserv = odd;
                }
                else{
                    work = odd;
                    reserv = even;
                }
                Iterator<String> iterator = work.iterator();
                while (iterator.hasNext()) {
                    String xy = iterator.next();
                    int x1 = Integer.parseInt(xy.substring(0,1));
                    int y1 = Integer.parseInt(xy.substring(1));

                    System.out.print(x1); System.out.println(y1);


                    if(x1-1>=0 && array[y1][x1-1]==0){
                        array[y1][x1-1]=i;
                        reserv.add(Integer.toString(x1-1) + Integer.toString(y1));
                    }
                    if(x1-1>=0 && array[y1][x1-1]==100){
                        array[y1][x1-1]=-i;
                        reserv.add(Integer.toString(x1-1) + Integer.toString(y1));
                    }
                    if(x1+1<9 && array[y1][x1+1]==0){
                        array[y1][x1+1]=i;
                        reserv.add(Integer.toString(x1+1) + Integer.toString(y1));
                    }
                    if(x1+1<9 && array[y1][x1+1]==100){
                        array[y1][x1+1]=-i;
                        reserv.add(Integer.toString(x1+1) + Integer.toString(y1));
                    }
                    if(y1-1>=0 && array[y1-1][x1]==0){
                        array[y1-1][x1]=i;
                        reserv.add(Integer.toString(x1) + Integer.toString(y1-1));
                    }
                    if(y1-1>=0 && array[y1-1][x1]==100){
                        array[y1-1][x1]=-i;
                        reserv.add(Integer.toString(x1) + Integer.toString(y1-1));
                    }
                    if(y1+1<9 && array[y1+1][x1]==0){
                        array[y1+1][x1]=i;
                        reserv.add(Integer.toString(x1) + Integer.toString(y1+1));
                    }
                    if(y1+1<9 && array[y1+1][x1]==100){
                        array[y1+1][x1]=-i;
                        reserv.add(Integer.toString(x1) + Integer.toString(y1+1));
                    }


                }
                work.clear();
            }
            else{
                pathLength = array[y][x];
            }
        }

        for(int k = 0; k<9; k++){
            for(int k1 = 0; k1<9; k1++) {
                System.out.print(array[k][k1] + " ");
            }
            System.out.println("");
        }
        System.out.println("PathLength="+pathLength);
        res.addFirst(Action.NONE);
//        int x = 4, y = 8;
        for(int i = pathLength;i>0; i--){
            if(this.getX()/64==x && this.getY()/64==y){
                res.addFirst(Action.NONE);
                break;
            }
            if((x-1>=0) && ((array[y][x-1]==i) || (array[y][x-1]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_RIGHT);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_RIGHT);
                }
                else{
                    res.addFirst(Action.MOVE_RIGHT);
                }
                x=x-1;
                System.out.println("i="+i + " MOVE_RIGHT added.");
                continue;
            }
            if(((y-1)>=0) && ((array[y-1][x]==i) || (array[y-1][x]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_DOWN);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_DOWN);
                }
                else{
                    res.addFirst(Action.MOVE_DOWN);
                }
                y=y-1;
                System.out.println("i="+i + " MOVE_DOWN added.");
                continue;
            }
            if((x+1<=8) && ((array[y][x+1]==i) || (array[y][x+1]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_LEFT);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_LEFT);
                }
                else{
                    res.addFirst(Action.MOVE_LEFT);
                }
                x=x+1;
                System.out.println("i="+i + " MOVE_LEFT added.");
                continue;
            }
            if((y+1<=8) && ((array[y+1][x]==i) || (array[y+1][x]==-i))){
                if(array[y][x]<0){
                    res.addFirst(Action.MOVE_UP);
                    res.addFirst(Action.FIRE);
                    res.addFirst(Action.TURN_UP);
                }
                else{
                    res.addFirst(Action.MOVE_UP);
                }
                x=x+1;
                System.out.println("i="+i + " MOVE_UP added.");
                continue;
            }
            res.addFirst(Action.NONE);
            System.out.println("x="+x + " y="+y);System.out.println("y-1="+array[y-1][x]);
            System.out.println("i="+i + " None move added.");
        }
        System.out.println(res.size());
        int j = res.size();
        for(int i = j; i>(j-1)/2; i--){
            res.removeLast();
        }
        res.addLast(Action.FIRE);
        System.out.println(res.size());
        return res;
    }
    public Composite setTransperancy(BattleField bf, int x, int y){
        if(this.isDestroyed()==false) {
            if (bf.getBattleField()[(y + 32) / 64][(x + 32) / 64] instanceof Water) {
                return transp;
            } else {
                return normal;
            }
        }
        else{
            return normal;
        }
    }
    public static Action randomAction(){
        return MOVES[(int)(Math.random()*4)];
    }
}


