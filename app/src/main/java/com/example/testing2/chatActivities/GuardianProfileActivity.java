package com.example.testing2.chatActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testing2.R;
import com.example.testing2.databinding.ActivityActiveChatBinding;
import com.example.testing2.databinding.ActivityGuardianProfileBinding;

public class GuardianProfileActivity extends AppCompatActivity {

    private ActivityGuardianProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        binding = ActivityGuardianProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivateButtonControls();
        SetListeners();
    }

    private void ActivateButtonControls(){
        BackButton();
    }

    private void BackButton() {
        //clicking on the sign in button in signup activity -> calls the signIn class
        binding.userIconBackButton.setOnClickListener( m-> onBackPressed());
    }

    private void SetListeners(){
        //set has guardian == true
        binding.setAsGuardianButton.setOnClickListener(m->{
            ConfigurationFile.guardianSelected = true;
            ShowToast("Preference Saved");
        });
    }
    private void ShowToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}