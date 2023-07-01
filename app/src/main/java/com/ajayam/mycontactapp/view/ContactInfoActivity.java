package com.ajayam.mycontactapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ajayam.mycontactapp.databinding.ActivityContactInfoBinding;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

public class ContactInfoActivity extends AppCompatActivity {

    ActivityContactInfoBinding binding;
    private String name;
    private String contact;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getIntentData();


       binding.btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent = new Intent(ContactInfoActivity.this, SendMessageActivity.class);
              // startActivity(intent);
                sendSMS();
            }
        });

    }

    private void sendSMS() {
        VonageClient client = VonageClient.builder().apiKey("6ae600e2").apiSecret("EhKa9zlxPMwFjJTx").build();

        TextMessage message = new TextMessage("Ajay Kumar",
                "917717788236",
                "A text message sent using the Vonage SMS API"
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }
    }

    private void getIntentData() {

        Intent intent = new Intent();
        intent = getIntent();
        if (intent.hasExtra("NAME")){
             name = intent.getStringExtra("NAME");
             contact = intent.getStringExtra("NUMBER");
             code = intent.getStringExtra("CODE");

            binding.tvContactName.setText(name);
            binding.tvContactNumber.setText(code+" "+contact);

        }



    }
}