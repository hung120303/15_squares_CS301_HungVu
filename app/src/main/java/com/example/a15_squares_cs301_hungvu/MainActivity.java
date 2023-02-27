/*@author Hung-Nghi D. Vu*/
/*@version 2/26/2023*/
/*@description MainActivity.java file to run the game. Sets the content of the activity_main.xml file and
 * adds function through GameModel, GameController, and GameView classes*/
package com.example.a15_squares_cs301_hungvu;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create instances of GameModel and Game View
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView(gameModel);

        //Add buttons from activity_main.xml to the gameView
        gameView.addButton(0, 0, findViewById(R.id.button1));
        gameView.addButton(0, 1, findViewById(R.id.button2));
        gameView.addButton(0, 2, findViewById(R.id.button3));
        gameView.addButton(0, 3, findViewById(R.id.button4));
        gameView.addButton(1, 0, findViewById(R.id.button5));
        gameView.addButton(1, 1, findViewById(R.id.button6));
        gameView.addButton(1, 2, findViewById(R.id.button7));
        gameView.addButton(1, 3, findViewById(R.id.button8));
        gameView.addButton(2, 0, findViewById(R.id.button9));
        gameView.addButton(2, 1, findViewById(R.id.button10));
        gameView.addButton(2, 2, findViewById(R.id.button11));
        gameView.addButton(2, 3, findViewById(R.id.button12));
        gameView.addButton(3, 0, findViewById(R.id.button13));
        gameView.addButton(3, 1, findViewById(R.id.button14));
        gameView.addButton(3, 2, findViewById(R.id.button15));
        gameView.addButton(3, 3, findViewById(R.id.button16));
        gameView.addResetButton(findViewById(R.id.button17));

        //Add instance of gameController
        GameController gameController = new GameController(gameModel, gameView);

        //Set on click listeners to all buttons (check gameView)
        gameView.setOnClick(gameController);

        //Start game with shuffled board
        gameView.shuffleBoard();
    }
}