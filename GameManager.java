package com.example.czesc.myapplicationgame;

import android.os.Bundle;

public class GameManager {

    private boolean player1Turn;
    private int roundCount;

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }

    public GameManager() {
        player1Turn = true;
    }

    public void setPlayer1Turn(boolean player1Turn) {
        this.player1Turn = player1Turn;
    }

    public boolean ChangePlayerTurn()
    {
        return player1Turn = !player1Turn;
    }
    public void ResetRoundCounter()
    {
        roundCount=0;
    }
    public boolean Draw()
    {
        return roundCount==9;
    }
    public void IncrementRoundCounter()
    {
        roundCount++;
    }
    public void RoundCount(Bundle savedInstanceState)
    {
        setRoundCount(savedInstanceState.getInt("roundCount"));
    }
    public void setPlayer1Turn(Bundle savedInstanceState)
    {
        setRoundCount(savedInstanceState.getInt("player1Turn"));
    }
    public boolean checkForWin(Board board) {

        board.Init();
        return (board.CheckVertical() || board.CheckHorizontal() || board.CheckDiagonalRight() || board.CheckDiagonalLeft());
    }
    public void ResetBoard(Board board)
    {
        board.Reset();
        ResetRoundCounter();
        setPlayer1Turn(true);
    }
}
