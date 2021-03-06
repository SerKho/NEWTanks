package Tanks.interfaces;

import Tanks.ActionField;
import Tanks.bfobjects.*;

/**
 * Created by 777 on 15.02.2016.
 */
public class BattleField {
    private int BF_WIDTH = 576;
    private int BF_HEIGHT = 576;
    ActionField af;
    BFObject[][] battleField;
//            {
//            {" ", " ", "B", "B", " ", "B", "B", " ", " "},
//            {" ", "B", "B", " ", "B", " ", " ", " ", " "},
//            {" ", " ", " ", " ", "B", "B", "B", "B", "B"},
//            {"B", "B", "B", "B", "B", " ", " ", " ", "B"},
//            {"B", " ", " ", "B", "B", "B", "B", " ", " "},
//            {" ", " ", " ", " ", " ", "B", "B", "B", " "},
//            {" ", " ", "B", " ", " ", "B", " ", " ", "B"},
//            {" ", " ", " ", " ", "B", "B", "B", " ", "B"},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "}
//            };

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public BattleField(ActionField af){
        this.af = af;
        battleField = new BFObject[9][9];
        for(int i=0;i<9;i++){
            for(int j=0; j<9;j++){
                battleField[i][j] = new BFObject(af, i+1,j+1);
            }
        }
        battleField[0][3] = new Rock(af, 1,4);
        battleField[2][0] = new Rock(af, 3,1);
        battleField[2][1] = new Rock(af, 3,2);
        battleField[2][2] = new Rock(af, 3,3);
        battleField[2][3] = new Rock(af, 3,4);
        battleField[2][4] = new Rock(af, 3,5);
        battleField[2][7] = new Rock(af, 3,8);
        battleField[2][8] = new Rock(af, 3,9);
        battleField[2][6] = new Brick(af, 3,7);
        battleField[6][0] = new Brick(af, 7,1);
//        battleField[7][2] = new Brick(af, 8,3);
        battleField[7][0] = new Brick(af, 8,1);
        battleField[2][5] = new Water(af, 3,6);
        battleField[8][4] = new Eagle(af, 9,5);
        battleField[8][3] = new Brick(af, 9,4);
        battleField[7][3] = new Brick(af, 8,4);
        battleField[7][4] = new Brick(af, 8,5);
        battleField[8][5] = new Brick(af, 9,6);
        battleField[7][5] = new Brick(af, 8,6);
        battleField[6][4] = new Rock(af, 7,5);

        battleField[4][0] = new Rock(af, 5,1);
        battleField[4][5] = new Rock(af, 5,6);
        battleField[4][2] = new Rock(af, 5,3);
        battleField[4][3] = new Rock(af, 5,4);
        battleField[4][4] = new Rock(af, 5,5);
        battleField[4][7] = new Rock(af, 5,8);
        battleField[4][8] = new Rock(af, 5,9);
        battleField[4][6] = new Rock(af, 5,7);

    }
    public BattleField(){

    }

    public BFObject[][] getBattleField() {
        return battleField;
    }

    public BFObject scanBattleField(int x, int y){
        return battleField[x][y];
    }

//    public String scanQuadrant(int y, int x){
//        return battleField[y][x];
//    }
//
    public void updateQuadrant(int y, int x, BFObject object){
        battleField[y][x] = object;
    }

    public int getDimensionX(){
        return battleField[0].length;
    }

    public int getDimensionY(){
        return battleField.length;
    }
}
