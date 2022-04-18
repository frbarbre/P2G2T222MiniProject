package com.example.p2g2t222mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD4Binding;

public class D4Fragment extends Fragment {

    private FragmentD4Binding binding;

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}