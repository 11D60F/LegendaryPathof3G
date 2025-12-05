package com.example.legendarypathof3g;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private Button loginEnter;
    private EditText loginUsername;
    private EditText loginPassword;
    private Button registerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEnter = findViewById(R.id.bu_login_enter);
        loginUsername = findViewById(R.id.et_login_name);
        loginPassword = findViewById(R.id.et_login_password);
        registerTo = findViewById(R.id.bu_login_register);
        loginIn();
        registerIn();
    }

    private void loginIn() {
        loginEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifSuccess()) {
                    Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                    enterPage(MainActivity.class);
                } else {
                    Toast.makeText(LoginActivity.this, "登陆失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerIn() {
        registerTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPage(RegisterActivity.class);
            }
        });
    }

    private void enterPage(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();         //保证向下传递
    }

    private boolean ifSuccess() {
        String username = loginUsername.getText().toString();
        String userPassword = loginPassword.getText().toString();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");
        if(username.equals(name)&& userPassword.equals(password))
            return true;
        else return false;
    }
}