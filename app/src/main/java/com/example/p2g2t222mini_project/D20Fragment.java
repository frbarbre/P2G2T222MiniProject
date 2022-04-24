package com.example.p2g2t222mini_project;

import android.content.Context;
import android.content.res.AssetManager;
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
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD12Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD20Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D20Fragment extends Fragment {

    private FragmentD20Binding binding;
    private TextView rollText20;
    private ImageView D20static;
    private GifImageView D20gif;
    private Button D20butD6;
    private Button D20butD8;
    private Button D20butD10;
    private Button D20butD12;
    private Button D20butD4;
    private Button D20butD100;
    private Button D20rollBut;
    private ImageView Logo;
    private List<RollHistoryItem> rollHistoryList;
    private GlobalList globalList;

    private double accelCurrentValue;
    private double accelPreviousValue;
    private boolean ranRecently = false;
    private MainActivity mainActivity;

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

        binding = FragmentD20Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        rollHistoryList = globalList.getRollHistoryList();

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText20 = (TextView) getView().findViewById(R.id.D20RollText);
        D20static = (ImageView) getView().findViewById(R.id.D20Static);
        D20gif = (GifImageView) getView().findViewById(R.id.D20GIF);
        D20butD6 = (Button) getView().findViewById(R.id.D20ButtonD6);
        D20butD8 = (Button) getView().findViewById(R.id.D20ButtonD8);
        D20butD10 = (Button) getView().findViewById(R.id.D20ButtonD10);
        D20butD12 = (Button) getView().findViewById(R.id.D20ButtonD12);
        D20butD4 = (Button) getView().findViewById(R.id.D20ButtonD4);
        D20butD100 = (Button) getView().findViewById(R.id.D20ButtonD100);
        D20rollBut = (Button) getView().findViewById(R.id.D20RollButton);
        Logo = (ImageView) getView().findViewById(R.id.LogoD20);

        if(mainActivity.diceColorGreen == true) {
            Logo.setImageResource(R.drawable.logogreen);
            D20static.setImageResource(R.drawable.d20_green1);
            D20gif.setImageResource(R.drawable.d20_green);
            D20butD6.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D20butD8.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D20butD10.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D20butD12.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D20butD4.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D20butD100.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D20rollBut.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
        }

        if(mainActivity.diceColorRed == true) {
            Logo.setImageResource(R.drawable.logored);
            D20static.setImageResource(R.drawable.d20_red1);
            D20gif.setImageResource(R.drawable.d20_red);
            D20butD6.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D20butD8.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D20butD10.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D20butD12.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D20butD4.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D20butD100.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D20rollBut.setBackgroundColor(getResources().getColor(R.color.redbutton));
        }

        if(mainActivity.diceColorBlue == true) {
            Logo.setImageResource(R.drawable.logoblue);
            D20static.setImageResource(R.drawable.d20_blue1);
            D20gif.setImageResource(R.drawable.d20_blue);
            D20butD6.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D20butD8.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D20butD10.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D20butD12.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D20butD4.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D20butD100.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D20rollBut.setBackgroundColor(getResources().getColor(R.color.bluebutton));
        }

        binding.D20ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D20Fragment.this)
                        .navigate(R.id.action_d20Fragment_to_D4Fragment);
            }
        });

        binding.D20ButtonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D20Fragment.this)
                        .navigate(R.id.action_d20Fragment_to_d6Fragment);
            }
        });

        binding.D20ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D20Fragment.this)
                        .navigate(R.id.action_d20Fragment_to_d8Fragment);
            }
        });

        binding.D20ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D20Fragment.this)
                        .navigate(R.id.action_d20Fragment_to_d12Fragment);
            }
        });

        binding.D20ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D20Fragment.this)
                        .navigate(R.id.action_d20Fragment_to_d100Fragment);
            }
        });

        binding.D20ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D20Fragment.this)
                        .navigate(R.id.action_d20Fragment_to_D10Fragment);
            }
        });

        binding.D20RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRollDice();

            }
        });

    }

    private void onRollDice(){
        ranRecently = true;
        binding.D20RollButton.setEnabled(false);
        binding.D20ButtonD4.setEnabled(false);
        binding.D20ButtonD6.setEnabled(false);
        binding.D20ButtonD8.setEnabled(false);
        binding.D20ButtonD10.setEnabled(false);
        binding.D20ButtonD10.setEnabled(false);
        binding.D20ButtonD12.setEnabled(false);
        binding.D20ButtonD100.setEnabled(false);
        BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
        bNavView.setVisibility(View.GONE);
        String resetString = " ";
        rollText20.setText(resetString);
        D20gif.setVisibility(View.VISIBLE);
        D20static.setVisibility(View.GONE);
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
        mediaPlayer.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final int min = 1;
                final int max = 20;
                final int random1to20 = new Random().nextInt((max - min) +1) +min;
                Integer number = random1to20;
                rollText20.setText(number.toString());
                binding.D20RollButton.setEnabled(true);
                binding.D20RollButton.setEnabled(true);
                binding.D20ButtonD4.setEnabled(true);
                binding.D20ButtonD6.setEnabled(true);
                binding.D20ButtonD8.setEnabled(true);
                binding.D20ButtonD10.setEnabled(true);
                binding.D20ButtonD12.setEnabled(true);
                binding.D20ButtonD100.setEnabled(true);
                D20gif.setVisibility(View.GONE);
                D20static.setVisibility(View.VISIBLE);
                bNavView.setVisibility(View.VISIBLE);
                if(mainActivity.diceColorRed == true) {
                    Drawable diceImage = (Drawable) getResources().getDrawable(R.drawable.d20_red1);
                    int nextID = globalList.getNextID();
                    int sortingid = globalList.getNextID();
                    RollHistoryItem item = new RollHistoryItem(nextID, "D20", number, diceImage, sortingid);
                    rollHistoryList.add(item);
                    globalList.setNextID(nextID+1);
                }
                if(mainActivity.diceColorGreen == true) {
                    Drawable diceImage = (Drawable) getResources().getDrawable(R.drawable.d20_green1);
                    int nextID = globalList.getNextID();
                    int sortingid = globalList.getNextID();
                    RollHistoryItem item = new RollHistoryItem(nextID, "D20", number, diceImage, sortingid);
                    rollHistoryList.add(item);
                    globalList.setNextID(nextID+1);
                }
                if(mainActivity.diceColorBlue == true) {
                    Drawable diceImage = (Drawable) getResources().getDrawable(R.drawable.d20_blue1);
                    int nextID = globalList.getNextID();
                    int sortingid = globalList.getNextID();
                    RollHistoryItem item = new RollHistoryItem(nextID, "D20", number, diceImage, sortingid);
                    rollHistoryList.add(item);
                    globalList.setNextID(nextID+1);
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