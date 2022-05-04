package com.kppc.study.a20220404_report02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar seek_cm, seek_kg;
    ImageButton btn_plus, btn_minus;
    Button btn_bmi;
    TextView str_cm, str_kg, str_bmi, str_result;

    float data_cm = 0.0f;
    float data_kg = 0.0f;
    float bmi_result = 0.0f;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        seek_cm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                data_cm = (progress * 0.5f) * 0.5f;
                str_cm.setText(String.format("%.0f cm", data_cm));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress += 1;
                if (progress >= 600) {
                    progress = 600;
                    Toast.makeText(getBaseContext(), "더이상 증가할 수 없음", Toast.LENGTH_SHORT).show();
                }
                seek_kg.setProgress(progress);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress -= 1;
                if (progress <= 0) {
                    progress = 0;
                    Toast.makeText(getBaseContext(), "더이상 감소할 수 없음", Toast.LENGTH_SHORT).show();
                }
                seek_kg.setProgress(progress);
            }
        });

        seek_kg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                data_kg = (progress * 0.5f) * 0.5f;
                str_kg.setText(String.format("%.0f kg", data_kg));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi_calculator(data_cm / 100, data_kg);
            }
        });
    }

    private void bmi_calculator(float cm, float kg) {
        bmi_result = kg / (cm * cm);
        str_bmi.setText(String.format("%.2f", bmi_result));

        if (bmi_result < 18.5f) {
            str_result.setText("결과: 저체중");
        } else if (bmi_result <= 22.9f || bmi_result <= 18.5f) {
            str_result.setText("결과: 정상체");
        } else if (bmi_result <= 24.9f || bmi_result <= 23.0f) {
            str_result.setText("결과: 과체중");
        } else {
            str_result.setText("결과: 비만");
        }
    }

    private void init() {
        seek_cm = findViewById(R.id.seek_cm);
        seek_kg = findViewById(R.id.seek_kg);
        btn_plus = findViewById(R.id.plus_btn);
        btn_minus = findViewById(R.id.minus_btn);
        btn_bmi = findViewById(R.id.bmi_btn);
        str_cm = findViewById(R.id.cm_str);
        str_kg = findViewById(R.id.kg_str);
        str_bmi = findViewById(R.id.bmi_str);
        str_result = findViewById(R.id.result_str);
    }
}