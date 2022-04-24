package com.example.p2g2t222mini_project;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D4Fragment extends Fragment {

    private FragmentD4Binding binding;
    private TextView rollText4;
    private GifImageView D4gif;
    private ImageView Logo;
    private Button D4butD6;
    private Button D4butD8;
    private Button D4butD10;
    private Button D4butD12;
    private Button D4butD20;
    private Button D4butD100;
    private Button D4rollBut;
    private List<RollHistoryItem> rollHistoryList;
    private GlobalList globalList;

    private ImageView D4static;

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
                onRollDice();
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        globalList = (GlobalList) getActivity().getApplication();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD4Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        rollHistoryList = globalList.getRollHistoryList();

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText4 = (TextView) getView().findViewById(R.id.D4RollText);
        D4gif = (GifImageView) getView().findViewById(R.id.D4GIF);
        D4butD6 = (Button) getView().findViewById(R.id.D4ButtonD6);
        D4butD8 = (Button) getView().findViewById(R.id.D4ButtonD8);
        D4butD10 = (Button) getView().findViewById(R.id.D4ButtonD10);
        D4butD12 = (Button) getView().findViewById(R.id.D4ButtonD12);
        D4butD20 = (Button) getView().findViewById(R.id.D4ButtonD20);
        D4butD100 = (Button) getView().findViewById(R.id.D4ButtonD100);
        D4rollBut = (Button) getView().findViewById(R.id.D4RollButton);
        Logo = (ImageView) getView().findViewById(R.id.LogoD4);



        D4static = (ImageView) getView().findViewById(R.id.D4StaticDie);


        if(mainActivity.diceColorGreen == true){
            Logo.setImageResource(R.drawable.logogreen);
            D4static.setImageResource(R.drawable.d4_green1);
            D4gif.setImageResource(R.drawable.d4_green);
            D4butD6.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D4butD8.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D4butD10.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D4butD12.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D4butD20.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D4butD100.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D4rollBut.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
        }

        if(mainActivity.diceColorRed == true){
            Logo.setImageResource(R.drawable.logored);
            D4static.setImageResource(R.drawable.d4_red1);
            D4gif.setImageResource(R.drawable.d4_red);
            D4butD6.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D4butD8.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D4butD10.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D4butD12.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D4butD20.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D4butD100.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D4rollBut.setBackgroundColor(getResources().getColor(R.color.redbutton));
        }

        if(mainActivity.diceColorBlue == true){
            Logo.setImageResource(R.drawable.logoblue);
            D4static.setImageResource(R.drawable.d4_blue1);
            D4gif.setImageResource(R.drawable.d4_blue);
            D4butD6.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D4butD8.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D4butD10.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D4butD12.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D4butD20.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D4butD100.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D4rollBut.setBackgroundColor(getResources().getColor(R.color.bluebutton));
        }

        binding.D4ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D4Fragment.this)
                        .navigate(R.id.action_D4Fragment_to_D10Fragment);
            }
        });

        binding.D4ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D4Fragment.this)
                        .navigate(R.id.action_D4Fragment_to_d8Fragment);
            }
        });

        binding.D4ButtonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D4Fragment.this)
                        .navigate(R.id.action_D4Fragment_to_d6Fragment);
            }
        });

        binding.D4ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D4Fragment.this)
                        .navigate(R.id.action_D4Fragment_to_d12Fragment);
            }
        });

        binding.D4ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D4Fragment.this)
                        .navigate(R.id.action_D4Fragment_to_d20Fragment);
            }
        });

        binding.D4ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D4Fragment.this)
                        .navigate(R.id.action_D4Fragment_to_d100Fragment);
            }
        });

        binding.D4RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRollDice();

            }
        });
    }

    private void onRollDice(){
        ranRecently = true;
        binding.D4RollButton.setEnabled(false);
        binding.D4ButtonD6.setEnabled(false);
        binding.D4ButtonD8.setEnabled(false);
        binding.D4ButtonD10.setEnabled(false);
        binding.D4ButtonD12.setEnabled(false);
        binding.D4ButtonD20.setEnabled(false);
        binding.D4ButtonD100.setEnabled(false);
        BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
        bNavView.setVisibility(View.GONE);
        String resetString = " ";
        rollText4.setText(resetString);
        D4gif.setVisibility(View.VISIBLE);
        D4static.setVisibility(View.GONE);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
        mediaPlayer.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final int min = 1;
                final int max = 4;
                final int random1to4 = new Random().nextInt((max - min) +1) +min;
                Integer number = random1to4;
                rollText4.setText(number.toString());
                binding.D4RollButton.setEnabled(true);
                binding.D4ButtonD6.setEnabled(true);
                binding.D4ButtonD8.setEnabled(true);
                binding.D4ButtonD10.setEnabled(true);
                binding.D4ButtonD12.setEnabled(true);
                binding.D4ButtonD20.setEnabled(true);
                binding.D4ButtonD100.setEnabled(true);
                D4gif.setVisibility(View.GONE);
                D4static.setVisibility(View.VISIBLE);
                bNavView.setVisibility(View.VISIBLE);
                if(mainActivity.diceColorRed == true) {
                    Drawable diceImage = (Drawable) getResources().getDrawable(R.drawable.d4_red1);
                    int nextID = globalList.getNextID();
                    RollHistoryItem item = new RollHistoryItem(nextID, "D4", number, diceImage);
                    rollHistoryList.add(item);
                    globalList.setNextID(nextID++);
                }
                if(mainActivity.diceColorGreen == true) {
                    Drawable diceImage = (Drawable) getResources().getDrawable(R.drawable.d4_green1);
                    int nextID = globalList.getNextID();
                    RollHistoryItem item = new RollHistoryItem(nextID, "D4", number, diceImage);
                    rollHistoryList.add(item);
                    globalList.setNextID(nextID++);
                }
                if(mainActivity.diceColorBlue == true) {
                    Drawable diceImage = (Drawable) getResources().getDrawable(R.drawable.d4_blue1);
                    int nextID = globalList.getNextID();
                    RollHistoryItem item = new RollHistoryItem(nextID, "D4", number, diceImage);
                    rollHistoryList.add(item);
                    globalList.setNextID(nextID++);
                }
                ranRecently = false;
            }
        },2000); //this is the delay before button is re-activated
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