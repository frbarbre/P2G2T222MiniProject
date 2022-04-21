package com.example.p2g2t222mini_project;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p2g2t222mini_project.databinding.FragmentDiceBinding;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;


public class DiceFragment extends Fragment {


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


        binding.DiceGreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.diceColorGreen = true;
                mainActivity.diceColorRed = false;
                mainActivity.diceColorBlue = false;
            }
        });

        binding.DiceRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.diceColorGreen = false;
                mainActivity.diceColorRed = true;
                mainActivity.diceColorBlue = false;
            }
        });

        binding.DiceBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.diceColorGreen = false;
                mainActivity.diceColorRed = false;
                mainActivity.diceColorBlue = true;

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}