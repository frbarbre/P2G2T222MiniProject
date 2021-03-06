package com.example.p2g2t222mini_project;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.p2g2t222mini_project.databinding.FragmentDiceBinding;


public class DiceFragment extends Fragment {

    private ImageView LogoRed;
    private ImageView LogoGreen;
    private ImageView LogoBlue;

    private FragmentDiceBinding binding;
    private static MainActivity mainActivity;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDiceBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LogoRed = (ImageView) getView().findViewById(R.id.LogoDiceRed);
        LogoGreen = (ImageView) getView().findViewById(R.id.LogoDiceGreen);
        LogoBlue = (ImageView) getView().findViewById(R.id.LogoDiceBlue);

        if(mainActivity.diceColorBlue == true){
            LogoRed.setVisibility(View.GONE);
            LogoGreen.setVisibility(View.GONE);
            LogoBlue.setVisibility(View.VISIBLE);
        }
        if(mainActivity.diceColorGreen == true){
            LogoRed.setVisibility(View.GONE);
            LogoGreen.setVisibility(View.VISIBLE);
            LogoBlue.setVisibility(View.GONE);
        }
        if(mainActivity.diceColorRed == true){
            LogoRed.setVisibility(View.VISIBLE);
            LogoGreen.setVisibility(View.GONE);
            LogoBlue.setVisibility(View.GONE);
        }


        binding.DiceGreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.diceColorGreen = true;
                mainActivity.diceColorRed = false;
                mainActivity.diceColorBlue = false;
                LogoRed.setVisibility(View.GONE);
                LogoGreen.setVisibility(View.VISIBLE);
                LogoBlue.setVisibility(View.GONE);
            }
        });

        binding.DiceRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.diceColorGreen = false;
                mainActivity.diceColorRed = true;
                mainActivity.diceColorBlue = false;
                LogoRed.setVisibility(View.VISIBLE);
                LogoGreen.setVisibility(View.GONE);
                LogoBlue.setVisibility(View.GONE);
            }
        });

        binding.DiceBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.diceColorGreen = false;
                mainActivity.diceColorRed = false;
                mainActivity.diceColorBlue = true;
                LogoRed.setVisibility(View.GONE);
                LogoGreen.setVisibility(View.GONE);
                LogoBlue.setVisibility(View.VISIBLE);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}