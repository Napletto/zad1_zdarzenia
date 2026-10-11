package com.example.a11_10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    double firstNumber = 0;
    String operation = "";
    boolean newNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);

        View.OnClickListener numberListener = v -> {
            Button button = (Button) v;
            String symbol = button.getText().toString();
            String current = tvTitle.getText().toString();

            if (newNumber) {
                tvTitle.setText(symbol.equals(",") ? "0," : symbol);
                newNumber = false;
            } else if (symbol.equals(",") && current.contains(",")) {
                return;
            } else if (current.length() < 10) {
                if (current.equals("0") && !symbol.equals(",")) {
                    tvTitle.setText(symbol);
                } else {
                    tvTitle.append(symbol);
                }
            }
        };

        int[] numberButtons = {
                R.id.btn0, R.id.btn1, R.id.btn2,
                R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8,
                R.id.btn9, R.id.btnComma
        };

        for (int id : numberButtons) {
            findViewById(id).setOnClickListener(numberListener);
        }

        View.OnClickListener operationListener = v -> {
            firstNumber = readNumber();

            if (v.getId() == R.id.btnAdd) {
                operation = "+";
            } else if (v.getId() == R.id.btnSub) {
                operation = "-";
            } else if (v.getId() == R.id.btnMul) {
                operation = "*";
            } else if (v.getId() == R.id.btnDiv) {
                operation = "/";
            }

            newNumber = true;
        };

        findViewById(R.id.btnAdd).setOnClickListener(operationListener);
        findViewById(R.id.btnSub).setOnClickListener(operationListener);
        findViewById(R.id.btnMul).setOnClickListener(operationListener);
        findViewById(R.id.btnDiv).setOnClickListener(operationListener);

        findViewById(R.id.btnEquals).setOnClickListener(v -> {
            double secondNumber = readNumber();
            double result;

            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) {
                        Toast.makeText(this,
                                "Nie można dzielić przez zero",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = firstNumber / secondNumber;
                    break;
                default:
                    return;
            }

            if (result == (long) result) {
                tvTitle.setText(String.valueOf((long) result));
            } else {
                tvTitle.setText(
                        String.valueOf(result).replace(".", ",")
                );
            }

            operation = "";
            newNumber = true;
        });

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            tvTitle.setText("0");
            firstNumber = 0;
            operation = "";
            newNumber = true;
        });
    }

    private double readNumber() {
        try {
            return Double.parseDouble(
                    tvTitle.getText().toString().replace(",", ".")
            );
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}


