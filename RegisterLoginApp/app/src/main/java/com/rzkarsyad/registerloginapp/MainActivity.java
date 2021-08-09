package com.rzkarsyad.registerloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SessionManager sessionManager;
    TextView tvName, tvUsername;
    String name, username;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        tvName = findViewById(R.id.tvMainName);
        tvUsername = findViewById(R.id.tvMainUsername);
        btn_logout = findViewById(R.id.btnLogout);

        btn_logout.setOnClickListener(this);

        name = sessionManager.getUserDetail().get(SessionManager.NAME);
        username = sessionManager.getUserDetail().get(SessionManager.USERNAME);

        tvName.setText(name);
        tvUsername.setText(username);

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogout:
                sessionManager.logoutSession();
                moveToLogin();
        }
    }
}