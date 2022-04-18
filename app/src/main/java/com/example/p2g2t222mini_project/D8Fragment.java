package com.example.p2g2t222mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD8Binding;

public class D8Fragment extends Fragment {

    private FragmentD8Binding binding;

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

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}