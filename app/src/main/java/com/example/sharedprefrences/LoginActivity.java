package com.example.sharedprefrences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedprefrences.helper.SharedPref;

public class LoginActivity extends AppCompatActivity {
    Button mBtnLogin;
    EditText nama, password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBtnLogin = findViewById(R.id.bt_login);
        nama = findViewById(R.id.et_nama);
        password = findViewById(R.id.et_pass);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getInstance(LoginActivity.this).setLogin(true);

                String namakey = nama.getText().toString();
                String passwordkey = password.getText().toString();

                if (namakey.equals("admin") && passwordkey.equals("admin123")){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username dan assword anda salah")
                            .setNegativeButton("Retry",null).create().show();
                }

            }
        });
    }
}
