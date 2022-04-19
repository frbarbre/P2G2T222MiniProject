package com.example.p2g2t222mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;

import java.util.Random;

public class D4Fragment extends Fragment {

    private FragmentD4Binding binding;
    private TextView rollText4;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD4Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText4 = (TextView) getView().findViewById(R.id.D4RollText);

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
                final int min = 1;
                final int max = 4;
                final int random1to4 = new Random().nextInt((max - min) +1) +min;
                Integer number = random1to4;
                rollText4.setText(number.toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}