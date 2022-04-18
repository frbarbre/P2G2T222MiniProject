package com.example.p2g2t222mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.p2g2t222mini_project.databinding.FragmentD10Binding;
import com.example.p2g2t222mini_project.databinding.FragmentD10Binding;

public class D10Fragment extends Fragment {

    private FragmentD10Binding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentD10Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.D10ButtonD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_D4Fragment);
            }
        });

            binding.D10ButtonD6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(D10Fragment.this)
                            .navigate(R.id.action_D10Fragment_to_d6Fragment);
                }
            });

        binding.D10ButtonD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d8Fragment);
            }
        });

        binding.D10ButtonD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d12Fragment);
            }
        });

        binding.D10ButtonD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d20Fragment);
            }
        });

        binding.D10ButtonD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(D10Fragment.this)
                        .navigate(R.id.action_D10Fragment_to_d100Fragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}