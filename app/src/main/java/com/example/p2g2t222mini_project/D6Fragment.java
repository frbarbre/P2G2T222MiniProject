package com.example.p2g2t222mini_project;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD6Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D6Fragment extends Fragment {

    private FragmentD6Binding binding;
    private TextView rollText6;
    private GifImageView D6Gif;
    private ImageView D6Static;
    private static MainActivity mainActivity;

    private double accelCurrentValue;
    private double accelPreviousValue;
    private boolean ranRecently = false;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            accelCurrentValue = Math.sqrt((x*x + y*y + z*z));
            double accelChangeValue = Math.abs(accelCurrentValue - accelPreviousValue);
            accelPreviousValue = accelCurrentValue;


            if (accelChangeValue > 12 && ranRecently == false){
                ranRecently = true;
                binding.D6RollButton.setEnabled(false);
                binding.D6ButtonD4.setEnabled(false);
                binding.D6ButtonD8.setEnabled(false);
                binding.D6ButtonD10.setEnabled(false);
                binding.D6ButtonD12.setEnabled(false);
                binding.D6ButtonD20.setEnabled(false);
                binding.D6ButtonD100.setEnabled(false);
                BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
                bNavView.setVisibility(View.GONE);
                String resetString = " ";
                rollText6.setText(resetString);
                D6Gif.setVisibility(View.VISIBLE);
                D6Static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 6;
                        final int random1to6 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to6;
                        rollText6.setText(number.toString());
                        binding.D6RollButton.setEnabled(true);
                        binding.D6ButtonD4.setEnabled(true);
                        binding.D6ButtonD8.setEnabled(true);
                        binding.D6ButtonD10.setEnabled(true);
                        binding.D6ButtonD12.setEnabled(true);
                        binding.D6ButtonD20.setEnabled(true);
                        binding.D6ButtonD100.setEnabled(true);
                        D6Gif.setVisibility(View.GONE);
                        D6Static.setVisibility(View.VISIBLE);
                        bNavView.setVisibility(View.VISIBLE);
                        ranRecently = false;
                    }
                },2000); //this is the delay before button is re-activated
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD6Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText6 = (TextView) getView().findViewById(R.id.D6RollText);
        D6Gif = (GifImageView) getView().findViewById(R.id.D6GIF);
        D6Static = (ImageView) getView().findViewById(R.id.D6Static);

        if(mainActivity.diceColorGreen == true) {
            D6Static.setImageResource(R.drawable.d6_green1);
            D6Gif.setImageResource(R.drawable.d6_green);
            ;
        }

        if(mainActivity.diceColorRed == true) {
            D6Static.setImageResource(R.drawable.d6_red1);
            D6Gif.setImageResource(R.drawable.d6_red);
            ;
        }

        if(mainActivity.diceColorBlue == true) {
            D6Static.setImageResource(R.drawable.d6_blue1);
            D6Gif.setImageResource(R.drawable.d6_blue);
            ;
        }

        binding.D6ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d8Fragment);
            }
        });

        binding.D6ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_D4Fragment);
            }
        });

        binding.D6ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_D10Fragment);
            }
        });

        binding.D6ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d12Fragment);
            }
        });

        binding.D6ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d20Fragment);
            }
        });

        binding.D6ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d100Fragment);
            }
        });

        binding.D6RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.D6RollButton.setEnabled(false);
                binding.D6ButtonD4.setEnabled(false);
                binding.D6ButtonD8.setEnabled(false);
                binding.D6ButtonD10.setEnabled(false);
                binding.D6ButtonD12.setEnabled(false);
                binding.D6ButtonD20.setEnabled(false);
                binding.D6ButtonD100.setEnabled(false);
                BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
                bNavView.setVisibility(View.GONE);
                String resetString = " ";
                rollText6.setText(resetString);
                D6Gif.setVisibility(View.VISIBLE);
                D6Static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 6;
                        final int random1to6 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to6;
                        rollText6.setText(number.toString());
                        binding.D6RollButton.setEnabled(true);
                        binding.D6ButtonD4.setEnabled(true);
                        binding.D6ButtonD8.setEnabled(true);
                        binding.D6ButtonD10.setEnabled(true);
                        binding.D6ButtonD12.setEnabled(true);
                        binding.D6ButtonD20.setEnabled(true);
                        binding.D6ButtonD100.setEnabled(true);
                        D6Gif.setVisibility(View.GONE);
                        D6Static.setVisibility(View.VISIBLE);
                        bNavView.setVisibility(View.VISIBLE);
                    }
                },2000); //this is the delay before button is re-activated

            }
        });
    }

    public void onResume(){
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, mSensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}