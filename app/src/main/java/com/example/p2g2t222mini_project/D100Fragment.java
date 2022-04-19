package com.example.p2g2t222mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.os.Handler;

import com.example.p2g2t222mini_project.databinding.FragmentD100Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD10Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD10Binding;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class D100Fragment extends Fragment {

    private FragmentD100Binding binding;
    private TextView rollText100;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD100Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText100 = (TextView) getView().findViewById(R.id.D100RollText);

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

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 100;
                        final int random1to100 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to100;
                        rollText100.setText(number.toString());
                        binding.D100RollButton.setEnabled(true);
                    }
                },2000); //this is the delay before button is re-activated

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}