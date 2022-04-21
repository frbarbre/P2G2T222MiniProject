package com.example.p2g2t222mini_project;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    List<RollHistoryItem> historyList = new ArrayList<RollHistoryItem>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);





        }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.HistoryRecycler);
        recyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewAdapter(historyList, getContext());
        Drawable diceImage = (Drawable) getResources().getDrawable(R.drawable.d20_red1);
        RollHistoryItem r0 = new RollHistoryItem(0,"D20", 6, diceImage);
        historyList.add(r0);
        recyclerView.setAdapter(mAdapter);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}