package com.example.demo_app;

import android.os.Bundle;
import android.widget.Toast;

import com.example.demo_app.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(view -> {
            String email = binding.userEdt.getText().toString().trim();
            String password = binding.passEdt.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (isValidCredentials(email, password)) {
                Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean isValidCredentials(String email, String password) {
        String sampleEmail = "user@example.com";
        String samplePassword = "123456";

        return email.equals(sampleEmail) && password.equals(samplePassword);
    }
}
