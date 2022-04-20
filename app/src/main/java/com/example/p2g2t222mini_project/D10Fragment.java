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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD10Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD10Binding;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D10Fragment extends Fragment {

    private FragmentD10Binding binding;
    private TextView rollText10;
    private ImageView D10static;
    private GifImageView D10gif;

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
                binding.D10RollButton.setEnabled(false);
                String resetString = " ";
                rollText10.setText(resetString);
                D10gif.setVisibility(View.VISIBLE);
                D10static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 10;
                        final int random1to10 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to10;
                        rollText10.setText(number.toString());
                        binding.D10RollButton.setEnabled(true);
                        D10gif.setVisibility(View.GONE);
                        D10static.setVisibility(View.VISIBLE);
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

        binding = FragmentD10Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText10 = (TextView) getView().findViewById(R.id.D10RollText);
        D10static = (ImageView) getView().findViewById(R.id.D10Static);
        D10gif = (GifImageView) getView().findViewById(R.id.D10GIF);

        binding.D10ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_D4Fragment);
            }
        });

            binding.D10ButtonD6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(D10Fragment.this)
                            .navigate(R.id.action_D10Fragment_to_d6Fragment);
                }
            });

        binding.D10ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d8Fragment);
            }
        });

        binding.D10ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d12Fragment);
            }
        });

        binding.D10ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d20Fragment);
            }
        });

        binding.D10ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d100Fragment);
            }
        });

        binding.D10RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.D10RollButton.setEnabled(false);
                String resetString = " ";
                rollText10.setText(resetString);
                D10gif.setVisibility(View.VISIBLE);
                D10static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 10;
                        final int random1to10 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to10;
                        rollText10.setText(number.toString());
                        binding.D10RollButton.setEnabled(true);
                        D10gif.setVisibility(View.GONE);
                        D10static.setVisibility(View.VISIBLE);
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