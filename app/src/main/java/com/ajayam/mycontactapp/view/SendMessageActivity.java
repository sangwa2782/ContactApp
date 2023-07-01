package com.ajayam.mycontactapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ajayam.mycontactapp.databinding.ActivitySendMessageBinding;

import java.util.Random;

public class SendMessageActivity extends AppCompatActivity {

    ActivitySendMessageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setOTP();

        binding.btSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    private void setOTP() {

            Random random = new Random();
            int otp = random.nextInt(900000) + 100000; // Generates a random number between 100000 and 999999
            binding.tvSendOtp.setText(String.valueOf(otp));

    }

}