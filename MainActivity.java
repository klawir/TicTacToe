package com.example.czesc.myapplicationgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Board board;
    private GameManager gameManager;
    private Player player1;
    private Player playerCpu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board =new Board();
        gameManager = new GameManager();
        player1= new Player("Player1");
        playerCpu=new Player("Player Cpu");

        player1.setTextView((TextView) findViewById(R.id.text_view_p1));
        playerCpu.setTextView((TextView) findViewById(R.id.text_view_p2));

        BoardInit();
    }
    public  void BoardInit()
    {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                board.getButtons()[i][j] = findViewById(resID);
                board.getButtons()[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (gameManager.isPlayer1Turn()) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        gameManager.IncrementRoundCounter();

        if (gameManager.checkForWin(board)) {
            if (gameManager.isPlayer1Turn()) {
                Player1Wins();
            } else {
                PlayerCpuWins();
            }
        } else if (gameManager.Draw()) {
            Draw();
        } else {
            gameManager.ChangePlayerTurn();
        }

    }

    private void Player1Wins() {
        player1.Wins();
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        gameManager.ResetBoard(board);
    }

    private void PlayerCpuWins() {
        playerCpu.Wins();
        Toast.makeText(this, "Player Cpu wins!", Toast.LENGTH_SHORT).show();
        gameManager.ResetBoard(board);
    }

    private void Draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        gameManager.ResetBoard(board);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", gameManager.getRoundCount());
        outState.putInt("player1Points", player1.getPoints());
        outState.putInt("player2Points", playerCpu.getPoints());
        outState.putBoolean("player1Turn", gameManager.isPlayer1Turn());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        gameManager.RoundCount(savedInstanceState);
        player1.setPoints(savedInstanceState.getInt("player1Points"));
        playerCpu.setPoints(savedInstanceState.getInt("player2Points"));
        gameManager.setPlayer1Turn(savedInstanceState);
    }
}