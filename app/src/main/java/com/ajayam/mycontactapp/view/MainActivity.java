package com.ajayam.mycontactapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ajayam.mycontactapp.utils.ViewPagerMassangerApp;
import com.ajayam.mycontactapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewPagerMassangerApp adapter = new ViewPagerMassangerApp(getSupportFragmentManager());
        binding.viewPager.setAdapter(adapter);
        binding.tabView.setupWithViewPager(binding.viewPager);
    }
}