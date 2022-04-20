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

import com.example.p2g2t222mini_project.databinding.FragmentD8Binding;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifImageView;

public class D8Fragment extends Fragment {

    private FragmentD8Binding binding;
    private TextView rollText8;
    private GifImageView D8Gif;
    private ImageView D8Static;

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
        D8Gif = (GifImageView) getView().findViewById(R.id.D8Gif);
        D8Static = (ImageView) getView().findViewById(R.id.D8StaticDie);

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}