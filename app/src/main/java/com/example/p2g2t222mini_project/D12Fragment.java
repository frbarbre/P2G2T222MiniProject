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

import com.example.p2g2t222mini_project.databinding.FragmentD12Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D12Fragment extends Fragment {

    private FragmentD12Binding binding;
    private TextView rollText12;
    private ImageView D12static;
    private GifImageView D12gif;
    private Button D12butD6;
    private Button D12butD8;
    private Button D12butD10;
    private Button D12butD4;
    private Button D12butD20;
    private Button D12butD100;
    private Button D12rollBut;


    private MainActivity mainActivity;

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
                binding.D12RollButton.setEnabled(false);
                binding.D12ButtonD4.setEnabled(false);
                binding.D12ButtonD6.setEnabled(false);
                binding.D12ButtonD8.setEnabled(false);
                binding.D12ButtonD10.setEnabled(false);
                binding.D12ButtonD20.setEnabled(false);
                binding.D12ButtonD100.setEnabled(false);
                BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
                bNavView.setVisibility(View.GONE);
                String resetString = " ";
                rollText12.setText(resetString);
                D12gif.setVisibility(View.VISIBLE);
                D12static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 12;
                        final int random1to12 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to12;
                        rollText12.setText(number.toString());
                        binding.D12RollButton.setEnabled(true);
                        binding.D12RollButton.setEnabled(true);
                        binding.D12ButtonD4.setEnabled(true);
                        binding.D12ButtonD6.setEnabled(true);
                        binding.D12ButtonD8.setEnabled(true);
                        binding.D12ButtonD10.setEnabled(true);
                        binding.D12ButtonD20.setEnabled(true);
                        binding.D12ButtonD100.setEnabled(true);
                        D12gif.setVisibility(View.GONE);
                        D12static.setVisibility(View.VISIBLE);
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

        binding = FragmentD12Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText12 = (TextView) getView().findViewById(R.id.D12RollText);
        D12gif = (GifImageView) getView().findViewById(R.id.D12GIF);
        D12static = (ImageView) getView().findViewById(R.id.D12Static);
        D12butD6 = (Button) getView().findViewById(R.id.D12ButtonD6);
        D12butD8 = (Button) getView().findViewById(R.id.D12ButtonD8);
        D12butD10 = (Button) getView().findViewById(R.id.D12ButtonD10);
        D12butD4 = (Button) getView().findViewById(R.id.D12ButtonD4);
        D12butD20 = (Button) getView().findViewById(R.id.D12ButtonD20);
        D12butD100 = (Button) getView().findViewById(R.id.D12ButtonD100);
        D12rollBut = (Button) getView().findViewById(R.id.D12RollButton);

        if(mainActivity.diceColorGreen == true) {
            D12static.setImageResource(R.drawable.d12_green1);
            D12gif.setImageResource(R.drawable.d12_green);
            D12butD6.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D12butD8.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D12butD10.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D12butD4.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D12butD20.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D12butD100.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D12rollBut.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
        }

        if(mainActivity.diceColorRed == true) {
            D12static.setImageResource(R.drawable.d12_red1);
            D12gif.setImageResource(R.drawable.d12_red);
            D12butD6.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D12butD8.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D12butD10.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D12butD4.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D12butD20.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D12butD100.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D12rollBut.setBackgroundColor(getResources().getColor(R.color.redbutton));
        }

        if(mainActivity.diceColorBlue == true) {
            D12static.setImageResource(R.drawable.d12_blue1);
            D12gif.setImageResource(R.drawable.d12_blue);
            D12butD6.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D12butD8.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D12butD10.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D12butD4.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D12butD20.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D12butD100.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D12rollBut.setBackgroundColor(getResources().getColor(R.color.bluebutton));
        }

        binding.D12ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_D4Fragment);
            }
        });

        binding.D12ButtonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d6Fragment);
            }
        });

        binding.D12ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d8Fragment);
            }
        });

        binding.D12ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_D10Fragment);
            }
        });

        binding.D12ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d20Fragment);
            }
        });

        binding.D12ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d100Fragment);
            }
        });

        binding.D12RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.D12RollButton.setEnabled(false);
                binding.D12ButtonD4.setEnabled(false);
                binding.D12ButtonD6.setEnabled(false);
                binding.D12ButtonD8.setEnabled(false);
                binding.D12ButtonD10.setEnabled(false);
                binding.D12ButtonD20.setEnabled(false);
                binding.D12ButtonD100.setEnabled(false);
                BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
                bNavView.setVisibility(View.GONE);
                String resetString = " ";
                rollText12.setText(resetString);
                D12gif.setVisibility(View.VISIBLE);
                D12static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 12;
                        final int random1to12 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to12;
                        rollText12.setText(number.toString());
                        binding.D12RollButton.setEnabled(true);
                        binding.D12RollButton.setEnabled(true);
                        binding.D12ButtonD4.setEnabled(true);
                        binding.D12ButtonD6.setEnabled(true);
                        binding.D12ButtonD8.setEnabled(true);
                        binding.D12ButtonD10.setEnabled(true);
                        binding.D12ButtonD20.setEnabled(true);
                        binding.D12ButtonD100.setEnabled(true);
                        D12gif.setVisibility(View.GONE);
                        D12static.setVisibility(View.VISIBLE);
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