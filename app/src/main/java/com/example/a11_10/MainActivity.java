package com.example.a11_10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);

        View.OnClickListener wspolnyListener = v -> {
            Button button = (Button) v;
            String cyfra = button.getText().toString();

            if (tvTitle.getText().toString().equals("0")) {
                tvTitle.setText(cyfra);
            } else {
                tvTitle.append(cyfra);
            }
        };

        int[] przyciski = {
                R.id.btn0, R.id.btn1, R.id.btn2,
                R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8,
                R.id.btn9
        };

        for (int id : przyciski) {
            findViewById(id).setOnClickListener(wspolnyListener);
        }
    }
}


