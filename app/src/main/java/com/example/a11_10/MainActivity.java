package com.example.a11_10;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);

        findViewById(R.id.btn1).setOnClickListener(v -> dodajCyfre("1"));
        findViewById(R.id.btn2).setOnClickListener(v -> dodajCyfre("2"));
        findViewById(R.id.btn3).setOnClickListener(v -> dodajCyfre("3"));
    }

    private void dodajCyfre(String cyfra) {
        if (tvTitle.getText().toString().equals("0")) {
            tvTitle.setText(cyfra);
        } else {
            tvTitle.append(cyfra);
        }
    }
}

