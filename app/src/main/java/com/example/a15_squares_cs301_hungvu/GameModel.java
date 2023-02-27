/*@author Hung-Nghi D. Vu*/
/*@version 2/26/2023*/
/*@description GameModel.java class to store key information of the board (where the blank button is)*/
package com.example.a15_squares_cs301_hungvu;
import java.util.Random;
public class GameModel {
    int rowBlank;
    int colBlank;
    Random rng = new Random();
    public GameModel(){
        rowBlank = 0;
        colBlank = 0;
    }

    public int getRowBlank()
    {
        return rowBlank;
    }
    public int getColBlank()
    {
        return colBlank;
    }
    public void randomBlankSpace(){ //Changes the blank buttons coordinates to a random place on the board
        rowBlank = rng.nextInt(4);
        colBlank = rng.nextInt(4);
    }
    public void setRowBlank(int i){ rowBlank = i; };

    public void setColBlank(int i){ colBlank = i; };


}
