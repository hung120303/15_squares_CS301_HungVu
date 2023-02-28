/*@author Hung-Nghi D. Vu*/
/*@version 2/27/2023*/
/*@description GameModel.java class to store key information of the board (where the blank button is)*/
/*@enhancements Initialized instance variables to allow for manipulation of the puzzle size. Included
* functions to access these variables in GameView. Max size for the row and col size is made */
package com.example.a15_squares_cs301_hungvu;
import java.util.Random;
public class GameModel {
    public final int maxRowSize = 9;
    public final int maxColSize = 9;
    int rowBlank;
    int colBlank;

    int rowSize;

    int colSize;
    Random rng = new Random();
    public GameModel(){
        rowBlank = 0;
        colBlank = 0;
        rowSize = 4;
        colSize = 4;
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
        rowBlank = rng.nextInt(rowSize);
        colBlank = rng.nextInt(colSize);
    }
    public void setRowBlank(int i){ rowBlank = i; }

    public void setColBlank(int i){ colBlank = i; }

    public int getRowSize(){ return rowSize; }
    public int getColSize(){ return colSize; }
    public void setRowSize(int i){ rowSize = i; }
    public void setColSize(int i){ colSize = i; }



}
