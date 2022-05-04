package com.kppc.study.a20220502_report01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {
    Intent intent;
    TextView view_result;
    Button return_btn;
    String state;
    int integer01;
    int integer02;
    int calculator_items;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        intent = getIntent();
        state = intent.getStringExtra("state");
        integer01 = intent.getIntExtra("int01", 0);
        integer02 = intent.getIntExtra("int02", 0);
        calculator_items = intent.getIntExtra("checkedId", 0);
        view_result = findViewById(R.id.view_result);
        return_btn = findViewById(R.id.return_btn);

        switch (calculator_items) {
            case R.id.sum_item:
                result = integer01 + integer02;
                state = "+";
                break;
            case R.id.minus_item:
                result = integer01 - integer02;
                state = "-";
                break;
            case R.id.multi_item:
                result = integer01 * integer02;
                state = "×";
                break;
            case R.id.division_item:
                result = integer01 / integer02;
                state = "÷";
                break;

        }
        String result_str =(String)(integer01 + state + integer02 + "=" + result);
        view_result.setText(result_str);


        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, intent);
                intent.putExtra("result_state", state);
                intent.putExtra("result", result_str);
                Log.d("TAG","state::" + state);
                Log.d("TAG","result_str::" + result_str);
                finish();
            }
        });
    }
}