/*@author Hung-Nghi D. Vu*/
/*@version 2/27/2023*/
/*@description GameController.java class to enable function to the buttons*/
/*@enhancements give function to the new seekbar to allow user to change board size using it*/
package com.example.a15_squares_cs301_hungvu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class GameController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{
    GameView gameView;
    GameModel gameModel;

    public GameController(GameModel m, GameView v) {
        gameModel = m;
        gameView = v;
    }

    @Override
    public void onClick(View view) {
        Button b = (Button)view;
        if((b.getText()).equals("RESET")){ // If the button is the reset button, shuffle the board
            gameView.shuffleBoard();
        }
        else //otherwise, switch the position of the button pressed and the blank button (else case is always a button on the board)
            gameView.switchPos((Button)view);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //Set the col and row to the progress of the seekBar, then change the size in gameView
        gameModel.setColSize(i);
        gameModel.setRowSize(i);
        gameView.changeSize();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
