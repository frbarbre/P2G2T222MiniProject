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
import android.widget.Button;
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
    private Button D6butD4;
    private Button D6butD8;
    private Button D6butD10;
    private Button D6butD12;
    private Button D6butD20;
    private Button D6butD100;
    private Button D6rollBut;
    private ImageView Logo;

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
        D6butD4 = (Button) getView().findViewById(R.id.D6ButtonD4);
        D6butD8 = (Button) getView().findViewById(R.id.D6ButtonD8);
        D6butD10 = (Button) getView().findViewById(R.id.D6ButtonD10);
        D6butD12 = (Button) getView().findViewById(R.id.D6ButtonD12);
        D6butD20 = (Button) getView().findViewById(R.id.D6ButtonD20);
        D6butD100 = (Button) getView().findViewById(R.id.D6ButtonD100);
        D6rollBut = (Button) getView().findViewById(R.id.D6RollButton);
        Logo = (ImageView) getView().findViewById(R.id.LogoD6);


        if(mainActivity.diceColorGreen == true) {
            Logo.setImageResource(R.drawable.logogreen);
            D6Static.setImageResource(R.drawable.d6_green1);
            D6Gif.setImageResource(R.drawable.d6_green);
            D6butD4.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D6butD8.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D6butD10.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D6butD12.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D6butD20.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D6butD100.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D6rollBut.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
        }

        if(mainActivity.diceColorRed == true) {
            Logo.setImageResource(R.drawable.logored);
            D6Static.setImageResource(R.drawable.d6_red1);
            D6Gif.setImageResource(R.drawable.d6_red);
            D6butD4.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D6butD8.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D6butD10.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D6butD12.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D6butD20.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D6butD100.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D6rollBut.setBackgroundColor(getResources().getColor(R.color.redbutton));
        }

        if(mainActivity.diceColorBlue == true) {
            Logo.setImageResource(R.drawable.logoblue);
            D6Static.setImageResource(R.drawable.d6_blue1);
            D6Gif.setImageResource(R.drawable.d6_blue);
            D6butD4.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D6butD8.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D6butD10.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D6butD12.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D6butD20.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D6butD100.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D6rollBut.setBackgroundColor(getResources().getColor(R.color.bluebutton));
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