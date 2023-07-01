package com.ajayam.mycontactapp.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajayam.mycontactapp.databinding.FragmentMessagesBinding;


public class MessagesFragment extends Fragment {


    FragmentMessagesBinding binding;

    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = binding.inflate(inflater, container, false);




        return binding.getRoot();
    }
}