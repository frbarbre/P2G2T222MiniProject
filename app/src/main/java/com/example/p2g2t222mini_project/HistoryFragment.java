package com.example.p2g2t222mini_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    private ListView historyListView;
    private MainActivity mainActivity;
    public ArrayList<String> historyList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mainActivity.setContentView(R.layout.activity_main);

//        historyListView = (ListView) getView().findViewById(R.id.HistoryListView);

        ArrayAdapter historyAdapter = new ArrayAdapter(getContext(),(R.layout.fragment_history));

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}