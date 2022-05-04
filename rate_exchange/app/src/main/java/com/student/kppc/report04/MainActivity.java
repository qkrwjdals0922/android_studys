package com.student.kppc.report04;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input_cm, input_kg;
    TextView result_value;
    Button btn;
    String result_cm, result_kg;
    float float_kg;
    float float_m, result_cmf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                result_cm = input_cm.getText().toString();
                result_kg = input_kg.getText().toString();
                if (result_kg.equals("")) {
                    input_kg.setError("kg를 정확히 입력해주세요");
                    Log.d("DATA_RESULT::001::", "integer_kg::" + float_kg);
                    Log.d("DATA_RESULT::001::", "float_cm::" + float_m);
                } else if (result_cm.equals("")) {
                    input_cm.setError("cm를 정확히 입력해주세요");
                    Log.d("DATA_RESULT::002::", "integer_kg::" + float_kg);
                    Log.d("DATA_RESULT::002::", "float_cm::" + float_m);

                } else {
                    float_kg = Float.parseFloat(result_kg);
                    float_m = Float.parseFloat(result_cm) / 100;
                    Log.d("DATA_RESULT::003::", "integer_kg::" + float_kg);
                    Log.d("DATA_RESULT::003::", "float_cm::" + float_m);

                    result_cmf = float_kg / (float_m * float_m);
                    Log.d("DATA_RESULT::004::", "result_cmf::" + result_cmf);

                    if (result_cmf < 16.0) {
                        result_value.setText(result_cmf + "-" + "체중 부족(심한 저체중)");
                    }else if(result_cmf >= 16 && result_cmf < 18.5){
                        result_value.setText(result_cmf + "-" + "체중 부족(저체중)");
                    }else if (result_cmf >= 18 && result_cmf < 25.0){
                        result_value.setText(result_cmf + "-" + "정상 체중");
                    }else if (result_cmf >= 25 && result_cmf < 30){
                        result_value.setText(result_cmf + "-" + "과체중");
                    }else if (result_cmf >=30){
                        result_value.setText(result_cmf + "-" + "비만");
                   }
                }
            }

        });


    }

    private void init() {
        input_cm = findViewById(R.id.input_cm);
        input_kg = findViewById(R.id.input_kg);
        result_value = findViewById(R.id.result_value);
        btn = findViewById(R.id.btn);
    }
}