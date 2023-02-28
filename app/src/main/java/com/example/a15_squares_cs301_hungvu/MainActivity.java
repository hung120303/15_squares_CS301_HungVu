/*@author Hung-Nghi D. Vu*/
/*@version 2/27/2023*/
/*@description MainActivity.java file to run the game. Sets the content of the activity_main.xml file and
 * adds function through GameModel, GameController, and GameView classes*/
/*@enhancement - added more buttons to allow for a maximum 9x9 puzzle. added a seekbar for the user
* to set the puzzle size*/

package com.example.a15_squares_cs301_hungvu;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SeekBar;

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

        gameView.addButton(0, 4, findViewById(R.id.button0_4));
        gameView.addButton(0, 5, findViewById(R.id.button0_5));
        gameView.addButton(0, 6, findViewById(R.id.button0_6));
        gameView.addButton(0, 7, findViewById(R.id.button0_7));
        gameView.addButton(0, 8, findViewById(R.id.button0_8));

        gameView.addButton(1, 4, findViewById(R.id.button1_4));
        gameView.addButton(1, 5, findViewById(R.id.button1_5));
        gameView.addButton(1, 6, findViewById(R.id.button1_6));
        gameView.addButton(1, 7, findViewById(R.id.button1_7));
        gameView.addButton(1, 8, findViewById(R.id.button1_8));

        gameView.addButton(2, 4, findViewById(R.id.button2_4));
        gameView.addButton(2, 5, findViewById(R.id.button2_5));
        gameView.addButton(2, 6, findViewById(R.id.button2_6));
        gameView.addButton(2, 7, findViewById(R.id.button2_7));
        gameView.addButton(2, 8, findViewById(R.id.button2_8));

        gameView.addButton(3, 4, findViewById(R.id.button3_4));
        gameView.addButton(3, 5, findViewById(R.id.button3_5));
        gameView.addButton(3, 6, findViewById(R.id.button3_6));
        gameView.addButton(3, 7, findViewById(R.id.button3_7));
        gameView.addButton(3, 8, findViewById(R.id.button3_8));

        gameView.addButton(4, 0, findViewById(R.id.button4_0));
        gameView.addButton(4, 1, findViewById(R.id.button4_1));
        gameView.addButton(4, 2, findViewById(R.id.button4_2));
        gameView.addButton(4, 3, findViewById(R.id.button4_3));
        gameView.addButton(4, 4, findViewById(R.id.button4_4));
        gameView.addButton(4, 5, findViewById(R.id.button4_5));
        gameView.addButton(4, 6, findViewById(R.id.button4_6));
        gameView.addButton(4, 7, findViewById(R.id.button4_7));
        gameView.addButton(4, 8, findViewById(R.id.button4_8));

        gameView.addButton(5, 0, findViewById(R.id.button5_0));
        gameView.addButton(5, 1, findViewById(R.id.button5_1));
        gameView.addButton(5, 2, findViewById(R.id.button5_2));
        gameView.addButton(5, 3, findViewById(R.id.button5_3));
        gameView.addButton(5, 4, findViewById(R.id.button5_4));
        gameView.addButton(5, 5, findViewById(R.id.button5_5));
        gameView.addButton(5, 6, findViewById(R.id.button5_6));
        gameView.addButton(5, 7, findViewById(R.id.button5_7));
        gameView.addButton(5, 8, findViewById(R.id.button5_8));

        gameView.addButton(6, 0, findViewById(R.id.button6_0));
        gameView.addButton(6, 1, findViewById(R.id.button6_1));
        gameView.addButton(6, 2, findViewById(R.id.button6_2));
        gameView.addButton(6, 3, findViewById(R.id.button6_3));
        gameView.addButton(6, 4, findViewById(R.id.button6_4));
        gameView.addButton(6, 5, findViewById(R.id.button6_5));
        gameView.addButton(6, 6, findViewById(R.id.button6_6));
        gameView.addButton(6, 7, findViewById(R.id.button6_7));
        gameView.addButton(6, 8, findViewById(R.id.button6_8));

        gameView.addButton(7, 0, findViewById(R.id.button7_0));
        gameView.addButton(7, 1, findViewById(R.id.button7_1));
        gameView.addButton(7, 2, findViewById(R.id.button7_2));
        gameView.addButton(7, 3, findViewById(R.id.button7_3));
        gameView.addButton(7, 4, findViewById(R.id.button7_4));
        gameView.addButton(7, 5, findViewById(R.id.button7_5));
        gameView.addButton(7, 6, findViewById(R.id.button7_6));
        gameView.addButton(7, 7, findViewById(R.id.button7_7));
        gameView.addButton(7, 8, findViewById(R.id.button7_8));

        gameView.addButton(8, 0, findViewById(R.id.button8_0));
        gameView.addButton(8, 1, findViewById(R.id.button8_1));
        gameView.addButton(8, 2, findViewById(R.id.button8_2));
        gameView.addButton(8, 3, findViewById(R.id.button8_3));
        gameView.addButton(8, 4, findViewById(R.id.button8_4));
        gameView.addButton(8, 5, findViewById(R.id.button8_5));
        gameView.addButton(8, 6, findViewById(R.id.button8_6));
        gameView.addButton(8, 7, findViewById(R.id.button8_7));
        gameView.addButton(8, 8, findViewById(R.id.button8_8));


        gameView.addResetButton(findViewById(R.id.button17));
        SeekBar s = findViewById(R.id.seekBar);

        //Add instance of gameController
        GameController gameController = new GameController(gameModel, gameView);

        //Set on click listeners to all buttons (check gameView)
        gameView.setOnClick(gameController);

        s.setOnSeekBarChangeListener(gameController);

        //Start game with shuffled board
        gameView.shuffleBoard();
    }
}