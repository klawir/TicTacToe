package com.example.czesc.myapplicationgame;

import android.widget.TextView;

public class Player {

    private int points;
    private TextView textView;
    String name;

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public Player(String name)
    {
        points=0;
        this.name=name;
    }

    public void AddPoint()
    {
        points++;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void updatePointsText() {
        textView.setText(name+" "+points);
    }

    public void Wins() {
        AddPoint();
        updatePointsText();
    }
}
