package com.example.p2g2t222mini_project;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.os.Handler;

import com.example.p2g2t222mini_project.databinding.FragmentD100Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D100Fragment extends Fragment {

    private FragmentD100Binding binding;
    private TextView rollText100;
    private TextView rollText100Two;
    private TextView rollText100Sum;
    private ImageView D100static1;
    private ImageView D100static2;
    private GifImageView D100gif1;
    private GifImageView D100gif2;
    private Button D100butD6;
    private Button D100butD8;
    private Button D100butD10;
    private Button D100butD12;
    private Button D100butD4;
    private Button D100butD20;
    private Button D100rollBut;
    private ImageView Logo;

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
                ranRecently = true;
                binding.D100RollButton.setEnabled(false);
                binding.D100ButtonD4.setEnabled(false);
                binding.D100ButtonD6.setEnabled(false);
                binding.D100ButtonD8.setEnabled(false);
                binding.D100ButtonD10.setEnabled(false);
                binding.D100ButtonD10.setEnabled(false);
                binding.D100ButtonD12.setEnabled(false);
                binding.D100ButtonD20.setEnabled(false);
                BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
                bNavView.setVisibility(View.GONE);
                String resetString = " ";
                rollText100.setText(resetString);
                rollText100Two.setText(resetString);
                rollText100Sum.setText(resetString);
                D100gif1.setVisibility(View.VISIBLE);
                D100gif2.setVisibility(View.VISIBLE);
                D100static1.setVisibility(View.GONE);
                D100static2.setVisibility(View.GONE);
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
                        rollText100.setText(number.toString());
                        final int min2 = 0;
                        final int max2 = 9;
                        final int random0to9Two = new Random().nextInt((max2 - min2) +1) +min2;
                        Integer number2 = random0to9Two;
                        rollText100Two.setText(number2.toString());
                        rollText100Sum.setText(number.toString()+number2.toString());
                        if(number == 0 && number2 == 0){
                            rollText100Sum.setText("100");
                        }
                        binding.D100RollButton.setEnabled(true);
                        binding.D100RollButton.setEnabled(true);
                        binding.D100ButtonD4.setEnabled(true);
                        binding.D100ButtonD6.setEnabled(true);
                        binding.D100ButtonD8.setEnabled(true);
                        binding.D100ButtonD10.setEnabled(true);
                        binding.D100ButtonD12.setEnabled(true);
                        binding.D100ButtonD20.setEnabled(true);
                        D100gif1.setVisibility(View.GONE);
                        D100gif2.setVisibility(View.GONE);
                        D100static1.setVisibility(View.VISIBLE);
                        D100static2.setVisibility(View.VISIBLE);
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

        binding = FragmentD100Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText100 = (TextView) getView().findViewById(R.id.d100RollText1);
        rollText100Two = (TextView) getView().findViewById(R.id.D100RollText2);
        rollText100Sum = (TextView) getView().findViewById(R.id.D100RollSum);
        D100static1 = (ImageView) getView().findViewById(R.id.D100Static1);
        D100static2 = (ImageView) getView().findViewById(R.id.D100Static2);
        D100gif1 = (GifImageView) getView().findViewById(R.id.D100GIF1);
        D100gif2 = (GifImageView) getView().findViewById(R.id.D100GIF2);
        D100butD6 = (Button) getView().findViewById(R.id.D100ButtonD6);
        D100butD8 = (Button) getView().findViewById(R.id.D100ButtonD8);
        D100butD10 = (Button) getView().findViewById(R.id.D100ButtonD10);
        D100butD12 = (Button) getView().findViewById(R.id.D100ButtonD12);
        D100butD4 = (Button) getView().findViewById(R.id.D100ButtonD4);
        D100butD20 = (Button) getView().findViewById(R.id.D100ButtonD20);
        D100rollBut = (Button) getView().findViewById(R.id.D100RollButton);
        Logo = (ImageView) getView().findViewById(R.id.LogoD100);

        if(mainActivity.diceColorGreen == true) {
            Logo.setImageResource(R.drawable.logogreen);
            D100static1.setImageResource(R.drawable.d10_green1);
            D100static2.setImageResource(R.drawable.d10_green1);
            D100gif1.setImageResource(R.drawable.d10_green);
            D100gif2.setImageResource(R.drawable.d10_green);
            D100butD6.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D100butD8.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D100butD10.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D100butD12.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D100butD4.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D100butD20.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
            D100rollBut.setBackgroundColor(getResources().getColor(R.color.greeenbutton));
        }

        if(mainActivity.diceColorRed == true) {
            Logo.setImageResource(R.drawable.logored);
            D100static1.setImageResource(R.drawable.d10_red1);
            D100static2.setImageResource(R.drawable.d10_red1);
            D100gif1.setImageResource(R.drawable.d10_red);
            D100gif2.setImageResource(R.drawable.d10_red);
            D100butD6.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D100butD8.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D100butD10.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D100butD12.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D100butD4.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D100butD20.setBackgroundColor(getResources().getColor(R.color.redbutton));
            D100rollBut.setBackgroundColor(getResources().getColor(R.color.redbutton));
        }

        if(mainActivity.diceColorBlue == true) {
            Logo.setImageResource(R.drawable.logoblue);
            D100static1.setImageResource(R.drawable.d10_blue1);
            D100static2.setImageResource(R.drawable.d10_blue1);
            D100gif1.setImageResource(R.drawable.d10_blue);
            D100gif2.setImageResource(R.drawable.d10_blue);
            D100butD6.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D100butD8.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D100butD10.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D100butD12.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D100butD4.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D100butD20.setBackgroundColor(getResources().getColor(R.color.bluebutton));
            D100rollBut.setBackgroundColor(getResources().getColor(R.color.bluebutton));
        }

        binding.D100ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D100Fragment.this)
                        .navigate(R.id.action_d100Fragment_to_D4Fragment);
            }
        });

        binding.D100ButtonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D100Fragment.this)
                        .navigate(R.id.action_d100Fragment_to_d6Fragment);
            }
        });

        binding.D100ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D100Fragment.this)
                        .navigate(R.id.action_d100Fragment_to_d8Fragment);
            }
        });

        binding.D100ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D100Fragment.this)
                        .navigate(R.id.action_d100Fragment_to_D10Fragment);
            }
        });

        binding.D100ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D100Fragment.this)
                        .navigate(R.id.action_d100Fragment_to_d12Fragment);
            }
        });

        binding.D100ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D100Fragment.this)
                        .navigate(R.id.action_d100Fragment_to_d20Fragment);
            }
        });



        binding.D100RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.D100RollButton.setEnabled(false);
                binding.D100ButtonD4.setEnabled(false);
                binding.D100ButtonD6.setEnabled(false);
                binding.D100ButtonD8.setEnabled(false);
                binding.D100ButtonD10.setEnabled(false);
                binding.D100ButtonD12.setEnabled(false);
                binding.D100ButtonD20.setEnabled(false);
                BottomNavigationView bNavView = getActivity().findViewById(R.id.bottom_nav_view);
                bNavView.setVisibility(View.GONE);
                String resetString = " ";
                rollText100.setText(resetString);
                rollText100Two.setText(resetString);
                rollText100Sum.setText(resetString);
                D100gif1.setVisibility(View.VISIBLE);
                D100gif2.setVisibility(View.VISIBLE);
                D100static1.setVisibility(View.GONE);
                D100static2.setVisibility(View.GONE);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.dice);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 0;
                        final int max = 9;
                        final int random0to9 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random0to9;
                        rollText100.setText(number.toString());
                        final int min2 = 0;
                        final int max2 = 9;
                        final int random0to9Two = new Random().nextInt((max2 - min2) +1) +min2;
                        Integer number2 = random0to9Two;
                        rollText100Two.setText(number2.toString());
                        rollText100Sum.setText(number.toString()+number2.toString());
                        if(number == 0 && number2 == 0){
                            rollText100Sum.setText("100");
                        }
                        binding.D100RollButton.setEnabled(true);
                        binding.D100ButtonD4.setEnabled(true);
                        binding.D100ButtonD6.setEnabled(true);
                        binding.D100ButtonD8.setEnabled(true);
                        binding.D100ButtonD10.setEnabled(true);
                        binding.D100ButtonD12.setEnabled(true);
                        binding.D100ButtonD20.setEnabled(true);
                        D100gif1.setVisibility(View.GONE);
                        D100gif2.setVisibility(View.GONE);
                        D100static1.setVisibility(View.VISIBLE);
                        D100static2.setVisibility(View.VISIBLE);
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