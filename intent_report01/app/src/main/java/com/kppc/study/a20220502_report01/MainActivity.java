package com.kppc.study.a20220502_report01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView int_input01, int_input02;
    RadioGroup calculator_items;
    Button calculation_btn;
    ListView result_list;

    ArrayAdapter<String> adapter;
    ArrayList<String> stringArrayList;

    String integer01_str, integer02_str, state;
    int integer01, integer02, result;
    Intent intent;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result_str = data.getStringExtra("result");
                Log.d("TAG", "get_result_str:: " + result_str);
                Toast.makeText(MainActivity.this, result_str, Toast.LENGTH_SHORT).show();
                stringArrayList.add(result_str);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_id();
        stringArrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArrayList);
        result_list.setAdapter(adapter);

        calculation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, CalculationActivity.class);
                integer01_str = int_input01.getText().toString();
                integer02_str = int_input02.getText().toString();
                integer01 = Integer.parseInt(integer01_str);
                integer02 = Integer.parseInt(integer02_str);
                intent.putExtra("int01", integer01);
                intent.putExtra("int02", integer02);
                intent.putExtra("checkedId", calculator_items.getCheckedRadioButtonId());
//              TODO(메모) 다른 Activity에서 데이터를 받아올 경우 startActivity 가 아닌
//               startActivityForResult 를 이용해서 requestCode 를 지정해줘야 한다.
                startActivityForResult(intent, 1);
                state();

            }
        });


    }

    private void state() {
        switch (calculator_items.getCheckedRadioButtonId()) {
            case R.id.sum_item:
                state = "+";
                break;
            case R.id.minus_item:
                state = "-";
                break;
            case R.id.multi_item:
                state = "×";
                break;
            case R.id.division_item:
                state = "÷";
                break;
        }
        intent.putExtra("state", state);
    }


    private void init_id() {
        int_input01 = findViewById(R.id.int_input01);
        int_input02 = findViewById(R.id.int_input02);
        calculator_items = findViewById(R.id.calculator_items);
        calculation_btn = findViewById(R.id.calculation_btn);
        result_list = findViewById(R.id.result_list);

    }
}