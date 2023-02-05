package com.example.facebook_login_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    MaterialButton loginButton;
    TextInputEditText email, password;
    TextInputLayout textViewEmail, textViewPassword;
    String adminEmail = "admin";
    String adminPassword = "admin";
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPasword);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewPassword = findViewById(R.id.textViewPassword);

        if (Objects.requireNonNull(email.getText()).toString().equals(adminEmail)
                && Objects.requireNonNull(password.getText()).toString().equals(adminPassword)) {
            //Initial intent
            Intent iLogin = new Intent();
            iLogin.setClass(LoginActivity.this, HomeActivity.class);

            String userName = Arrays.toString(email.getText().toString().split("@"));
            iLogin.putExtra("userName", userName);
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            startActivity(iLogin);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong credential", Toast.LENGTH_SHORT).show();
            textViewEmail.setVisibility(View.VISIBLE);
            textViewEmail.setBackgroundColor(Color.RED);
            counter--;
            if (counter == 0) {
                loginButton.setEnabled(false);
            }
        }
    }
}