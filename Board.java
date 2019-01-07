package com.example.czesc.myapplicationgame;

import android.widget.Button;



public class Board{

    private Button[][] buttons;
    public  final int size=3;
    String[][] field;

    public Button[][] getButtons() {
        return buttons;
    }

    public Board()
    {
        buttons = new Button[size][size];
        field = new String[size][size];
    }
    public void Reset()
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setText("");
            }
        }
    }
    public   void Init()
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
    }
    public  boolean CheckVertical()
    {
        for (int i = 0; i < size; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }
        return false;
    }
    public  boolean CheckHorizontal()
    {
        for (int i = 0; i < size; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        return false;
    }
    public  boolean CheckDiagonalRight()
    {
        return (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals(""));
    }
    public  boolean CheckDiagonalLeft()
    {
        return (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) ;
    }

}