package com.example.p2g2t222mini_project;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D4Fragment extends Fragment {

    private FragmentD4Binding binding;
    private TextView rollText4;
    private GifImageView D4gif;
//    private GifImageView D8gif;
//    private GifImageView D10gif;
//    private GifImageView D12gif;
//    private GifImageView D20gif;
    private ImageView D4static;
//    private ImageView D8static;
//    private ImageView D10static;
//    private ImageView D12static;
//    private ImageView D20static;
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
                binding.D4RollButton.setEnabled(false);
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
                        D4gif.setVisibility(View.GONE);
                        D4static.setVisibility(View.VISIBLE);
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

        binding = FragmentD4Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText4 = (TextView) getView().findViewById(R.id.D4RollText);
        D4gif = (GifImageView) getView().findViewById(R.id.D4GIF);

        D4static = (ImageView) getView().findViewById(R.id.D4StaticDie);


        if(mainActivity.diceColorGreen == true){
            D4static.setImageResource(R.drawable.d4_green1);
            D4gif.setImageResource(R.drawable.d4_green);;
        }

        if(mainActivity.diceColorRed == true){
            D4static.setImageResource(R.drawable.d4_red1);
            D4gif.setImageResource(R.drawable.d4_red);;
        }

        if(mainActivity.diceColorBlue == true){
            D4static.setImageResource(R.drawable.d4_blue1);
            D4gif.setImageResource(R.drawable.d4_blue);;
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
                binding.D4RollButton.setEnabled(false);
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
                        D4gif.setVisibility(View.GONE);
                        D4static.setVisibility(View.VISIBLE);
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