package com.rzkarsyad.registerloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rzkarsyad.registerloginapp.api.ApiClient;
import com.rzkarsyad.registerloginapp.api.ApiInterface;
import com.rzkarsyad.registerloginapp.model.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etUsername, etPassword;
    TextView tvLogin;
    Button btnRegister;
    String name, username, password;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etRegisterName);
        etUsername = findViewById(R.id.etRegisterUsername);
        etPassword = findViewById(R.id.etRegisterPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        tvLogin = findViewById(R.id.tvHaveAnAccount);
        tvLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                name = etName.getText().toString();
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Kata sandi tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    register(name, username, password);
                }
                break;
            case R.id.tvHaveAnAccount:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void register(String name, String username, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Register> registerCall = apiInterface.registerResponse(name, username, password);
        registerCall.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}