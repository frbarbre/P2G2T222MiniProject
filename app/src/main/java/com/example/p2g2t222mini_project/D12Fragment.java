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

import com.example.p2g2t222mini_project.databinding.FragmentD12Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class D12Fragment extends Fragment {

    private FragmentD12Binding binding;
    private TextView rollText12;
    private ImageView D12static;
    private GifImageView D12gif;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD12Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollText12 = (TextView) getView().findViewById(R.id.D12RollText);
        D12gif = (GifImageView) getView().findViewById(R.id.D12GIF);
        D12static = (ImageView) getView().findViewById(R.id.D12Static);

        binding.D12ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_D4Fragment);
            }
        });

        binding.D12ButtonD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d6Fragment);
            }
        });

        binding.D12ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d8Fragment);
            }
        });

        binding.D12ButtonD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_D10Fragment);
            }
        });

        binding.D12ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d20Fragment);
            }
        });

        binding.D12ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D12Fragment.this)
                        .navigate(R.id.action_d12Fragment_to_d100Fragment);
            }
        });

        binding.D12RollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.D12RollButton.setEnabled(false);
                String resetString = " ";
                rollText12.setText(resetString);
                D12gif.setVisibility(View.VISIBLE);
                D12static.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final int min = 1;
                        final int max = 12;
                        final int random1to12 = new Random().nextInt((max - min) +1) +min;
                        Integer number = random1to12;
                        rollText12.setText(number.toString());
                        binding.D12RollButton.setEnabled(true);
                        D12gif.setVisibility(View.GONE);
                        D12static.setVisibility(View.VISIBLE);
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