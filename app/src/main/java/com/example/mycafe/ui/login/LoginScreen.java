package com.example.mycafe.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mycafe.MainActivity;
import com.example.mycafe.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity implements LoginDialogFragment.loginListener {

    private ActivityLoginScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Dialog_login
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogLogin();
            }
        });

    }

    public void openDialogLogin() {
        DialogFragment newFragment = new LoginDialogFragment();
        newFragment.show(getSupportFragmentManager(), "Signin");
    }

    @Override
    public void appleTexts(String username, String password) {
        if(username.equals("furkid") && password.equals("123")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "帳密有誤", Toast.LENGTH_SHORT).show();
        }
    }
}