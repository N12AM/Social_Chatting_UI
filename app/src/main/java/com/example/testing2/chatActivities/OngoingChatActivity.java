package com.example.testing2.chatActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testing2.R;
import com.example.testing2.databinding.ActivityChatHomeViewBinding;
import com.example.testing2.databinding.ActivityOngoingChatBinding;

public class OngoingChatActivity extends AppCompatActivity {

    private ActivityOngoingChatBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ongoing_chat);

        getSupportActionBar().hide();
        binding = ActivityOngoingChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SetListeners();
    }
    private void SetListeners() {
        //clicking on the sign in button in signup activity -> calls the signIn class
        binding.userIconBackButton.setOnClickListener( m-> onBackPressed());
    }
}