package com.example.p2g2t222mini_project;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.util.Comparator;

public class RollHistoryItem {
    private int id;
    private String diceName;
    private int rollAmount;
    private Drawable diceImage;
    private int sortingID;

    public RollHistoryItem(int id, String diceName, int rollAmount, Drawable diceImage, int sortingID) {
        this.id = id;
        this.diceName = diceName;
        this.rollAmount = rollAmount;
        this.diceImage = diceImage;
        this.sortingID = sortingID;

    }

    public static Comparator<RollHistoryItem> rollHistoryItemIDComparator = new Comparator<RollHistoryItem>() {
        @Override
        public int compare(RollHistoryItem t1, RollHistoryItem t2) {
            return t2.getSortingID() - t1.getSortingID();
        }
    };

    @Override
    public String toString() {
        return "RollHistoryItem{" +
                "id=" + id +
                ", diceName='" + diceName + '\'' +
                ", rollAmount=" + rollAmount +
                ", diceImage=" + diceImage +
                "sortingID=" + sortingID +
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

    public int getSortingID(){return sortingID;}

    public void setSortingID(int sortingID){this.sortingID = sortingID;}



}
