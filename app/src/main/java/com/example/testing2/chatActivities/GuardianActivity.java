package com.example.testing2.chatActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.testing2.R;
import com.example.testing2.databinding.ActivityActiveChatBinding;
import com.example.testing2.databinding.ActivityGuardianBinding;

public class GuardianActivity extends AppCompatActivity {

    private ActivityGuardianBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        binding = ActivityGuardianBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivateButtonControls();
    }

    private void ActivateButtonControls(){
        BackButton();
        Guardian0();
    }

    private void BackButton() {
        //clicking on the sign in button in signup activity -> calls the signIn class
        binding.userIconBackButton.setOnClickListener( m-> onBackPressed());
    }
    private void Guardian0(){
        binding.guardianContactActiveFrame.setOnClickListener(m->
                startActivity(new Intent(getApplicationContext(), GuardianProfileActivity.class)));
    }
}