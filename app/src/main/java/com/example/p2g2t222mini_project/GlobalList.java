package com.example.p2g2t222mini_project;

import android.app.Application;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class GlobalList extends Application {

    private static List<RollHistoryItem> rollHistoryList = new ArrayList<RollHistoryItem>();
    private static int nextID = 1;

    public GlobalList(){
        fillRollHistoryList();
    }

    private void fillRollHistoryList(){
    }

    public static List<RollHistoryItem> getRollHistoryList() {
        return rollHistoryList;
    }

    public static void setRollHistoryList(List<RollHistoryItem> rollHistoryList) {
        GlobalList.rollHistoryList = rollHistoryList;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        GlobalList.nextID = nextID;
    }


}
