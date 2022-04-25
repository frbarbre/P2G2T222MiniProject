package com.example.p2g2t222mini_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;


public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GlobalList globalList;
    private List<RollHistoryItem> rollHistoryList;
    private static MainActivity mainActivity;
    private ImageView LogoRed;


    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        globalList = (GlobalList) getActivity().getApplication();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rollHistoryList = globalList.getRollHistoryList();

        }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.HistoryRecycler);
        recyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewAdapter(rollHistoryList, getContext());
        recyclerView.setAdapter(mAdapter);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter.notifyDataSetChanged();
        Collections.sort(rollHistoryList, RollHistoryItem.rollHistoryItemIDComparator);
        mAdapter.notifyDataSetChanged();


        return view;

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogoRed = (ImageView) getView().findViewById(R.id.LogoHistory);
        if(mainActivity.diceColorBlue == true){
            LogoRed.setImageResource(R.drawable.logoblue);
        }
        if(mainActivity.diceColorGreen == true){
            LogoRed.setImageResource(R.drawable.logogreen);
        }
        if(mainActivity.diceColorRed == true){
            LogoRed.setImageResource(R.drawable.logored);
        }



    }

}