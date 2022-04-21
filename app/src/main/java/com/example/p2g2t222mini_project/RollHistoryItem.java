package com.example.p2g2t222mini_project;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

public class RollHistoryItem {
    private int id;
    private String diceName;
    private int rollAmount;
    private Drawable diceImage;

    public RollHistoryItem(int id, String diceName, int rollAmount, Drawable diceImage) {
        this.id = id;
        this.diceName = diceName;
        this.rollAmount = rollAmount;
        this.diceImage = diceImage;

    }

    @Override
    public String toString() {
        return "RollHistoryItem{" +
                "id=" + id +
                ", diceName='" + diceName + '\'' +
                ", rollAmount=" + rollAmount +
                ", diceImage=" + diceImage +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiceName() {
        return diceName;
    }

    public void setDiceName(String diceName) {
        this.diceName = diceName;
    }
    public int getRollAmount() {
        return rollAmount;
    }

    public void setRollAmount(int rollAmount) {
        this.rollAmount = rollAmount;
    }

    public Drawable getDiceImage() {
        return diceImage;
    }

    public void setDiceImage(Drawable diceImage) {
        this.diceImage = diceImage;
    }



}
