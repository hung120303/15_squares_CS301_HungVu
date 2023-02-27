/*@author Hung-Nghi D. Vu*/
/*@version 2/26/2023*/
/*@description GameView.java class to display the attributes of views (buttons)*/
package com.example.a15_squares_cs301_hungvu;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;
public class GameView {

    private Button[][] buttons; //The board
    private GameModel gameModel;
    private Button resetButton;
    Random rng = new Random();
    public GameView(GameModel m){
        gameModel = m;
        buttons = new Button[4][4];
    }

    //Function to add button to the board
    public void addButton(int row, int col, Button b){
        buttons[row][col] = b;
    }

    //Function to add reset button
    public void addResetButton(Button b){
        resetButton = b;
    }

    /*Shuffles the board (buttons[][]) by first clearing all text of the buttons, have the
    new blank button be randomly assigned, then randomly assign numbers 1-15 to 15 of the
    other 16 buttons of the board*/
    public void shuffleBoard() {
        gameModel.randomBlankSpace(); // Gives the [row][col] of the blank button random

        //Go through the whole board (buttons[][])
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                buttons[i][j].setText(""); //Clear the buttons' text
            }
        }

        ArrayList<Integer> nums = new ArrayList<>(); //ArrayList to keep track of current numbers used
        int k;
        //Go through whole array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //Code only executes if the [row][col] is not the one of the blank button
                if (!(gameModel.getColBlank() == j && gameModel.getRowBlank() == i)) {
                    k = rng.nextInt(15)+1; //Random number 1-15
                    while(nums.contains(k)){ //Until the number is one that hasn't been used...
                        k = rng.nextInt(15)+1; //Create another random number 1-15
                    }
                    nums.add(k); //Add the new number to the list
                    buttons[i][j].setText(Integer.toString(k)); //Set the text to the current button to this random number
                }
            }
        }
        updateBoard(); //Updates the valid moves and correct places of the button
    }

    //Updates the board with valid moves (sets only buttons adjacent to the blank button as clickable
    //Also changes background of the buttons of the board that are in the correct place
    public void updateBoard(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                buttons[i][j].setClickable(false); //Set all buttons on the board to not clickable
            }
        }
        //Sets the button above, below, left, and right to the blank one to clickable
        //if the button is within the board's bounds
        if(gameModel.rowBlank-1 != -1){
            buttons[gameModel.rowBlank-1][gameModel.colBlank].setClickable(true);
        }
        if(gameModel.rowBlank+1 != 4){
            buttons[gameModel.rowBlank+1][gameModel.colBlank].setClickable(true);
        }
        if(gameModel.colBlank-1 != -1){
            buttons[gameModel.rowBlank][gameModel.colBlank-1].setClickable(true);
        }
        if(gameModel.colBlank+1 != 4){
            buttons[gameModel.rowBlank][gameModel.colBlank+1].setClickable(true);
        }

        int count =1; //int to keep count
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                //Go through the board
                //If the button is in the right place, set it to correct, otherwise it's incorrect
                if(buttons[i][j].getText().equals(Integer.toString(count))){
                    setStatus(buttons[i][j], true);
                }
                else
                    setStatus(buttons[i][j], false);
                count++; //Increase the count by one for the next button
            }
        }
    }

    //Sets the button to green if true, red if false
    public void setStatus(Button b, boolean boo){
        if(boo){
            b.setBackgroundColor(Color.GREEN);
        }
        else
            b.setBackgroundColor(Color.RED);
    }


    //Sets onClickListeners to all buttons
    public void setOnClick(GameController game){
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                buttons[i][j].setOnClickListener(game);
            }
        }
        resetButton.setOnClickListener(game);
    }

    //Switches a button's contents to the blank button and vice versa.
    public void switchPos(Button b){
        int row =0;
        int col =0;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(buttons[i][j].equals(b)){ //Check the entire board and store its row and col
                    row = i;
                    col = j;
                }
            }
        }
        String s = (String)buttons[row][col].getText(); //Get the text of the current button
        buttons[gameModel.rowBlank][gameModel.colBlank].setText(s); //Set the blank button to that text
        buttons[row][col].setText(""); //Set the current button to blank text
        gameModel.setRowBlank(row); //Assign the coordinates of the blank button to the current button
        gameModel.setColBlank(col);
        updateBoard(); //Update the board
    }


}
