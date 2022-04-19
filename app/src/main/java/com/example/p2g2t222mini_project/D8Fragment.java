package com.example.p2g2t222mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD8Binding;

import java.util.Random;

public class D8Fragment extends Fragment {

    private FragmentD8Binding binding;
    private TextView rollText8;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD8Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText8 = (TextView) getView().findViewById(R.id.D8RollText);

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
                final int min = 1;
                final int max = 8;
                final int random1to8 = new Random().nextInt((max - min) +1) +min;
                Integer number = random1to8;
                rollText8.setText(number.toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}