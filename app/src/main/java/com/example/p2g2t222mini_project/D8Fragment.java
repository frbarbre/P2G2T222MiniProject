package com.example.p2g2t222mini_project;

import static android.content.Context.SENSOR_SERVICE;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD8Binding;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifImageView;

public class D8Fragment extends Fragment {

    private FragmentD8Binding binding;
    private TextView rollText8;
    private GifImageView D8Gif;
    private ImageView D8Static;
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
                binding.D8RollButon.setEnabled(false);
                String resetString = " ";
                rollText8.setText(resetString);
                D8Gif.setVisibility(View.VISIBLE);
                D8Static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 8;
                        final int random1to8 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to8;
                        rollText8.setText(number.toString());
                        binding.D8RollButon.setEnabled(true);
                        D8Gif.setVisibility(View.GONE);
                        D8Static.setVisibility(View.VISIBLE);
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

        binding = FragmentD8Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText8 = (TextView) getView().findViewById(R.id.D8RollText);
        D8Gif = (GifImageView) getView().findViewById(R.id.D8Gif);
        D8Static = (ImageView) getView().findViewById(R.id.D8StaticDie);

        if(mainActivity.diceColorGreen == true) {
            D8Static.setImageResource(R.drawable.d8_green1);
            D8Gif.setImageResource(R.drawable.d8_green);
            ;
        }

        if(mainActivity.diceColorRed == true) {
            D8Static.setImageResource(R.drawable.d8_red1);
            D8Gif.setImageResource(R.drawable.d8_red);
            ;
        }

        if(mainActivity.diceColorBlue == true) {
            D8Static.setImageResource(R.drawable.d8_blue1);
            D8Gif.setImageResource(R.drawable.d8_blue);
            ;
        }


        binding.D8ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D8Fragment.this)
                        .navigate(R.id.action_d8Fragment_to_D4Fragment);
            }
        });

        binding.D8ButtonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D8Fragment.this)
                        .navigate(R.id.action_d8Fragment_to_d6Fragment);
            }
        });

        binding.D8ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D8Fragment.this)
                        .navigate(R.id.action_d8Fragment_to_D10Fragment);
            }
        });

        binding.D8ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D8Fragment.this)
                        .navigate(R.id.action_d8Fragment_to_d12Fragment);
            }
        });

        binding.D8ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D8Fragment.this)
                        .navigate(R.id.action_d8Fragment_to_d20Fragment);
            }
        });

        binding.D8ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D8Fragment.this)
                        .navigate(R.id.action_d8Fragment_to_d100Fragment);
            }
        });

        binding.D8RollButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.D8RollButon.setEnabled(false);
                String resetString = " ";
                rollText8.setText(resetString);
                D8Gif.setVisibility(View.VISIBLE);
                D8Static.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 8;
                        final int random1to8 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to8;
                        rollText8.setText(number.toString());
                        binding.D8RollButon.setEnabled(true);
                        D8Gif.setVisibility(View.GONE);
                        D8Static.setVisibility(View.VISIBLE);
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