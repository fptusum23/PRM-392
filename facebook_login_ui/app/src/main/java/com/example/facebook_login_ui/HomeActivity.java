package com.example.facebook_login_ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {
    AppCompatTextView userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        MaterialButton finishButton = findViewById(R.id.finishButton);
        MaterialButton logoutButton = findViewById(R.id.logoutButton);

        userNameTextView = findViewById(R.id.userNameText);

        Intent iLogin = getIntent();
        String userName = iLogin.getStringExtra("userName");
        userNameTextView.setText(String.format("Well come %s", userName));
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
    }

}