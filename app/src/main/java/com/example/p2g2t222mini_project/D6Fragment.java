package com.example.p2g2t222mini_project;

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

import com.example.p2g2t222mini_project.databinding.FragmentD6Binding;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D6Fragment extends Fragment {

    private FragmentD6Binding binding;
    private TextView rollText6;
    private GifImageView D6Gif;
    private ImageView D6Static;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD6Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText6 = (TextView) getView().findViewById(R.id.D6RollText);
        D6Gif = (GifImageView) getView().findViewById(R.id.D6GIF);
        D6Static = (ImageView) getView().findViewById(R.id.D6Static);

        binding.D6ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d8Fragment);
            }
        });

        binding.D6ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_D4Fragment);
            }
        });

        binding.D6ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_D10Fragment);
            }
        });

        binding.D6ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d12Fragment);
            }
        });

        binding.D6ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d20Fragment);
            }
        });

        binding.D6ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D6Fragment.this)
                        .navigate(R.id.action_d6Fragment_to_d100Fragment);
            }
        });

        binding.D6RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.D6RollButton.setEnabled(false);
                String resetString = " ";
                rollText6.setText(resetString);
                D6Gif.setVisibility(View.VISIBLE);
                D6Static.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 6;
                        final int random1to6 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to6;
                        rollText6.setText(number.toString());
                        binding.D6RollButton.setEnabled(true);
                        D6Gif.setVisibility(View.GONE);
                        D6Static.setVisibility(View.VISIBLE);
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