package com.kppc.study.a20220404_report01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result_bmi, result_str, str_cm, str_kg;
    SeekBar seek_kg, seek_cm;

    float data_kg = 0.0f, data_cm = 0.0f, bmi_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        seek_kg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                data_kg = (progress * 0.5f) * 0.5f;
                str_kg.setText(String.format("%.1f cm",data_kg));
                bmi_calculator(data_cm / 100, data_kg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seek_cm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                data_cm = (progress * 0.5f) * 0.5f;
                str_cm.setText(String.format("%.1f cm",data_cm));
                bmi_calculator(data_cm / 100 , data_kg);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void bmi_calculator(float cm, float kg) {
       bmi_result =  kg / (cm * cm);
       result_bmi.setText(String.format("%.2f", bmi_result));

       if (bmi_result < 18.5f){
            result_str.setText("당신은 저체중입니다.");
       } else if(bmi_result <= 22.9f || bmi_result <= 18.5f){
           result_str.setText("당신은 정상체중입니다..");
       } else if (bmi_result <= 24.9f || bmi_result <= 23.0f){
           result_str.setText("당신은 과체중입니다.");
       }else {
           result_str.setText("당신은 비만입니다.");
       }
    }

    private void init() {
        seek_kg = findViewById(R.id.seek_rate_kg);
        str_kg = findViewById(R.id.str_rate_kg);
        seek_cm = findViewById(R.id.seek_rate_cm);
        str_cm = findViewById(R.id.str_rate_cm);
        result_bmi = findViewById(R.id.result_bmi);
        result_str = findViewById(R.id.result_str);
    }
}