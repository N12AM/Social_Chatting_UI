package com.example.testing2.chatActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.testing2.R;
import com.example.testing2.databinding.ActivityActiveChatBinding;
import com.example.testing2.databinding.ActivityChatHomeViewBinding;

public class ActiveChatActivity extends AppCompatActivity {

    private ActivityActiveChatBinding binding;


    // custom class to define variables that can be accessed by any class
    private ConfigurationFile CustomConfigurationFile;

    private int MessageSentCount = 0;
    private int sleepAmount = 400;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        binding = ActivityActiveChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ActivateButtonControls();
        StartConversation();
    }

    private void ActivateButtonControls(){
        BackButton();
        AddGuardianButton();
        ChangeGuardianButton();
        ToggleAddOrChangeGuardianButton();
    }

    private void StartConversation() {
        //don't start chat if guardian not selected
        if(!ConfigurationFile.guardianSelected){
            binding.messageSendButton.setOnClickListener(m-> {
                    ShowToast("Guardian Not selected");
            });
            return;
        }
        PeekMessageTextBar();
        binding.messageSendButton.setOnClickListener(m-> {
            try {
                SimulateConversation();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
    private void ShowToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void PeekMessageTextBar(){
        if(MessageSentCount < 5){
            binding.charBarText.setText(ConfigurationFile.messageSentArray[MessageSentCount]);
        }
    }
    private void SimulateConversation() throws InterruptedException {
        if(MessageSentCount >= 5){
            return;
        }
        if(MessageSentCount == 0){
            Conversation0();
        }
        else if(MessageSentCount == 1){
            Conversation1();
        }
        else if(MessageSentCount == 2){
            Conversation2();
        }
        else if(MessageSentCount == 3){
            Conversation3();
        }
        else if(MessageSentCount == 4){
            Conversation4();
        }

        MessageSentCount += 1;
    }

    private void Conversation0(){

            binding.messageSent0.setVisibility(View.VISIBLE);
            binding.messageSent1.setVisibility(View.INVISIBLE);
            binding.messageSent2.setVisibility(View.INVISIBLE);
            binding.messageSent3.setVisibility(View.INVISIBLE);
            binding.messageSent4.setVisibility(View.INVISIBLE);
            binding.messageSentText0.setText(ConfigurationFile.messageSentArray[MessageSentCount]);
            try {
                Thread.sleep(sleepAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                binding.messageReceived0.setVisibility(View.VISIBLE);
                binding.messageReceived1.setVisibility(View.INVISIBLE);
                binding.messageReceived2.setVisibility(View.INVISIBLE);
                binding.messageReceived3.setVisibility(View.INVISIBLE);
                binding.messageReceived4.setVisibility(View.INVISIBLE);
            binding.messageReceivedText0.setText(ConfigurationFile.messageReceivedArray[MessageSentCount]);
    }
    private void Conversation1(){
        binding.messageSent1.setVisibility(View.VISIBLE);
        binding.messageSent2.setVisibility(View.INVISIBLE);
        binding.messageSent3.setVisibility(View.INVISIBLE);
        binding.messageSent4.setVisibility(View.INVISIBLE);
            binding.messageSentText1.setText(ConfigurationFile.messageSentArray[MessageSentCount]);
            try {
                Thread.sleep(sleepAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                binding.messageReceived1.setVisibility(View.VISIBLE);
                binding.messageReceived2.setVisibility(View.INVISIBLE);
                binding.messageReceived3.setVisibility(View.INVISIBLE);
                binding.messageReceived4.setVisibility(View.INVISIBLE);
            binding.messageReceivedText1.setText(ConfigurationFile.messageReceivedArray[MessageSentCount]);
    }
    private void Conversation2(){
            binding.messageSent2.setVisibility(View.VISIBLE);
            binding.messageSent3.setVisibility(View.INVISIBLE);
            binding.messageSent4.setVisibility(View.INVISIBLE);

            binding.messageSentText2.setText(ConfigurationFile.messageSentArray[MessageSentCount]);
            try {
                Thread.sleep(sleepAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                binding.messageReceived2.setVisibility(View.VISIBLE);
                binding.messageReceived3.setVisibility(View.INVISIBLE);
                binding.messageReceived4.setVisibility(View.INVISIBLE);
            binding.messageReceivedText2.setText(ConfigurationFile.messageReceivedArray[MessageSentCount]);
    }

    private void Conversation3(){

            binding.messageSent3.setVisibility(View.VISIBLE);
            binding.messageSent4.setVisibility(View.INVISIBLE);

            binding.messageSentText3.setText(ConfigurationFile.messageSentArray[MessageSentCount]);
            try {
                Thread.sleep(sleepAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                binding.messageReceived3.setVisibility(View.VISIBLE);
                binding.messageReceived4.setVisibility(View.INVISIBLE);
            binding.messageReceivedText3.setText(ConfigurationFile.messageReceivedArray[MessageSentCount]);
    }

    private void Conversation4(){
            binding.messageSent4.setVisibility(View.VISIBLE);
            binding.messageSentText4.setText(ConfigurationFile.messageSentArray[MessageSentCount]);
            try {
                Thread.sleep(sleepAmount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            binding.messageReceived4.setVisibility(View.VISIBLE);
            binding.messageReceivedText4.setText(ConfigurationFile.messageReceivedArray[MessageSentCount]);
    }

    private void BackButton() {
        //clicking on the sign in button in signup activity -> calls the signIn class
        binding.userIconBackButton.setOnClickListener( m-> onBackPressed());
    }

    private void ToggleAddOrChangeGuardianButton(){

        if(ConfigurationFile.guardianSelected){
            binding.guardianSelectedMainFrame.setVisibility(View.VISIBLE);
            binding.guardianNotSelectedMainFrame.setVisibility(View.INVISIBLE);
        }
        else{
            binding.guardianSelectedMainFrame.setVisibility(View.INVISIBLE);
            binding.guardianNotSelectedMainFrame.setVisibility(View.VISIBLE);
        }
    }

    private void AddGuardianButton(){

        //check if the "guardian not selected frame is active
        if(binding.guardianNotSelectedMainFrame.getVisibility() == View.VISIBLE){

            //take user to guardian selector menu
            binding.addGuardianCheckBox.setOnClickListener( m->
                    startActivity(new Intent(getApplicationContext(), GuardianActivity.class)));
        }
    }

    private void ChangeGuardianButton(){

        //check if the "guardian selected frame is active
        if(binding.guardianSelectedMainFrame.getVisibility() == View.VISIBLE){

            //take user to guardian selector menu
            binding.changeGuardianCheckBox.setOnClickListener( m->
                    startActivity(new Intent(getApplicationContext(), GuardianActivity.class)));
        }
    }

}