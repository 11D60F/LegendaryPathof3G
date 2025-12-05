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

public class RegisterActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_password;
    private EditText editText_password_again;

    private Button registerID;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerID = findViewById(R.id.bu_register_register);
        back = findViewById(R.id.bu_register_back);
        editText_name = findViewById(R.id.et_register_name);
        editText_password = findViewById(R.id.et_register_password);
        editText_password_again = findViewById(R.id.et_register_password_again);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPage(LoginActivity.class);
            }
        });
        register();
    }

    private void register() {
        registerID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_name = editText_name.getText().toString();
                String text_password = editText_password.getText().toString();
                String text_password_again = editText_password_again.getText().toString();
                if(text_name.isEmpty() || text_password.isEmpty() || text_password_again.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "存在空项！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ifValid(text_password, text_password_again)) {
                    Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("name", text_name);
                    intent.putExtra("password", text_password);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean ifValid(String s1, String s2) {
        return s1.equals(s2);
    }

    private void enterPage(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();
    }
}