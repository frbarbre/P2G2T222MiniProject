package com.example.p2g2t222mini_project;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

import com.example.p2g2t222mini_project.databinding.FragmentD12Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD20Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;

import org.w3c.dom.Text;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D20Fragment extends Fragment {

    private FragmentD20Binding binding;
    private TextView rollText20;
    private ImageView D20static;
    private GifImageView D20gif;
    private double accelCurrentValue;
    private double accelPreviousValue;
    private TextView D20pagetext;
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

            D20pagetext.setText("yay it worked. Current accel:" + (int) accelCurrentValue);


            if (accelCurrentValue > 18 && ranRecently == false){
                ranRecently = true;
                binding.D20RollButton.setEnabled(false);
                String resetString = " ";
                rollText20.setText(resetString);
                D20gif.setVisibility(View.VISIBLE);
                D20static.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 20;
                        final int random1to20 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to20;
                        rollText20.setText(number.toString());
                        binding.D20RollButton.setEnabled(true);
                        D20gif.setVisibility(View.GONE);
                        D20static.setVisibility(View.VISIBLE);
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

        binding = FragmentD20Binding.inflate(inflater, container, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText20 = (TextView) getView().findViewById(R.id.D20RollText);
        D20static = (ImageView) getView().findViewById(R.id.D20Static);
        D20gif = (GifImageView) getView().findViewById(R.id.D20GIF);
        D20pagetext = (TextView) getView().findViewById(R.id.D20PageText);

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
                binding.D20RollButton.setEnabled(false);
                String resetString = " ";
                rollText20.setText(resetString);
                D20gif.setVisibility(View.VISIBLE);
                D20static.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 20;
                        final int random1to20 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to20;
                        rollText20.setText(number.toString());
                        binding.D20RollButton.setEnabled(true);
                        D20gif.setVisibility(View.GONE);
                        D20static.setVisibility(View.VISIBLE);
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