/*@author Hung-Nghi D. Vu*/
/*@version 2/26/2023*/
/*@description GameController.java class to enable function to the buttons*/
package com.example.a15_squares_cs301_hungvu;
import android.view.View;
import android.widget.Button;

public class GameController implements View.OnClickListener{
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
}
