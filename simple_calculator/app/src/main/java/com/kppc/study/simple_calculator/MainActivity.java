package com.kppc.study.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int get_num1, get_num2, result_result;
    float flo_info;
    String num_date1, num_date2, result_into;
    EditText edit_num1, edit_num2;
    TextView result;
    Button btn_sum, btn_minus, btn_multiply, btn_into, btn_remainder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_date1 = edit_num1.getText().toString();
                num_date2 = edit_num2.getText().toString();
                if(!num_date1.equals("") || !num_date2.equals("")){
                    get_num1 = Integer.parseInt(num_date1);
                    get_num2 = Integer.parseInt(num_date2);
                    result_result = get_num1 + get_num2;
                    result.setText(get_num1 + "+" + get_num2 + "=" + result_result);
                } else {
                    Toast.makeText(getBaseContext(), "숫자 2개를 모두 입력 해 주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_date1 = edit_num1.getText().toString();
                num_date2 = edit_num2.getText().toString();
                if(!num_date1.equals("") || !num_date2.equals("")){
                    get_num1 = Integer.parseInt(num_date1);
                    get_num2 = Integer.parseInt(num_date2);
                    result_result = get_num1 - get_num2;
                    result.setText(get_num1 + "-" + get_num2 + "=" + result_result);
                } else {
                    Toast.makeText(getBaseContext(), "숫자 2개를 모두 입력 해 주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_date1 = edit_num1.getText().toString();
                num_date2 = edit_num2.getText().toString();
                if(!num_date1.equals("") || !num_date2.equals("")){
                    get_num1 = Integer.parseInt(num_date1);
                    get_num2 = Integer.parseInt(num_date2);
                    result_result = get_num1 * get_num2;
                    result.setText(get_num1 + "X" + get_num2 + "=" + result_result);
                } else {
                    Toast.makeText(getBaseContext(), "숫자 2개를 모두 입력 해 주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_date1 = edit_num1.getText().toString();
                num_date2 = edit_num2.getText().toString();
                if(num_date1.equals("") || num_date2.equals("")){
                    Toast.makeText(getBaseContext(), "숫자 2개를 모두 입력 해 주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }else if(num_date1.equals("0") || num_date2.equals("0")) {
                    Toast.makeText(getBaseContext(), "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    get_num1 = Integer.parseInt(num_date1);
                    get_num2 = Integer.parseInt(num_date2);
                    flo_info = (float) get_num1/ get_num2;
                    result_into = String.format("%.2f", flo_info) ;
                    result.setText(get_num1 + "÷" + get_num2 + "=" + result_into);
                }
            }
        });

        btn_remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_date1 = edit_num1.getText().toString();
                num_date2 = edit_num2.getText().toString();
                if(num_date1.equals("") || num_date2.equals("")){
                    Toast.makeText(getBaseContext(), "숫자 2개를 모두 입력 해 주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                } else if(num_date1.equals("0") || num_date2.equals("0")){
                    Toast.makeText(getBaseContext(), "0으로는 나머지를 구할 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    get_num1 = Integer.parseInt(num_date1);
                    get_num2 = Integer.parseInt(num_date2);
                    result_result = get_num1 % get_num2;
                    result.setText(get_num1 + "%" + get_num2 + "=" + result_result);
                }
            }
        });


    }

    private void init(){
        result = findViewById(R.id.result);

        edit_num1 = (EditText) findViewById(R.id.number1);
        edit_num2 = (EditText) findViewById(R.id.number2);

        btn_sum = (Button) findViewById(R.id.btn_sum);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_into = (Button) findViewById(R.id.btn_into);
        btn_remainder = (Button) findViewById(R.id.btn_remainder);
    }
}