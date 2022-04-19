package com.example.p2g2t222mini_project;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD12Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD20Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;

import java.util.Random;

public class D20Fragment extends Fragment {

    private FragmentD20Binding binding;
    private TextView rollText20;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD20Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText20 = (TextView) getView().findViewById(R.id.D20RollText);

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

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 20;
                        final int random1to20 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to20;
                        rollText20.setText(number.toString());
                        binding.D20RollButton.setEnabled(true);
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