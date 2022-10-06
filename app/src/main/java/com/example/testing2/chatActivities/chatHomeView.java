package com.example.testing2.chatActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.testing2.R;
import com.example.testing2.databinding.ActivityChatHomeViewBinding;


public class chatHomeView extends AppCompatActivity {

    private ActivityChatHomeViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chat_home_view);

        getSupportActionBar().hide();
        binding = ActivityChatHomeViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //here, always listen to the button click
        SetListeners0();
        SetListeners1();
        SetListeners2();
    }

    private void SetListeners0() {
        //clicking on the createAccount button in signIn activity -> calls the signUp class
        binding.chatUser0.setOnClickListener(m ->
                startActivity(new Intent(getApplicationContext(), ActiveChatActivity.class)));
    }
    private void SetListeners1() {
        //clicking on the createAccount button in signIn activity -> calls the signUp class
        binding.chatUser1.setOnClickListener(m ->
                startActivity(new Intent(getApplicationContext(), ActiveChatActivity.class)));
    }
    private void SetListeners2() {
        //clicking on the createAccount button in signIn activity -> calls the signUp class
        binding.chatUser2.setOnClickListener(m ->
                startActivity(new Intent(getApplicationContext(), ActiveChatActivity.class)));
    }
}