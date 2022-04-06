package com.student.kppc.temperature_report;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar seek_celsius, seek_fahrenheit;
    RadioGroup group_trans;
    RadioButton cel_fah, fah_cel;
    Button btn_trans, btn_init;
    TextView str_result, num_cel, num_fah;
    float float_cel = 0.0f, float_fah = 0.0f;
    float result_cel = 0.0f, result_fah= 0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        seek_celsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float_cel = (i * 0.5f) * 0.5f;
                num_cel.setText(String.format("(%.2f)ºC", float_cel));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seek_fahrenheit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float_fah = (i * 0.5f) * 0.5f;
                num_fah.setText(String.format("(%.2f)ºC", float_fah));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                group_trans.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.btn_cel_fah:
                                result_fah = (float) ((float_cel * 1.8) + 32);
                                result_cel = float_cel;
                                break;
                            case R.id.btn_fah_cel:
                                result_cel = (float) ((float_fah - 32) / 1.8);
                                result_fah = float_fah;
                                break;
                        }
                    }
                });
                str_result.setText(String.format("섭씨온도: %.2f ºC, 화씨온도: %.2f ºF", result_cel, result_fah));
            }
        });
        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float_cel = 0.0f;
                float_fah = 0.0f;
                result_cel = 0.0f;
                result_fah = 0.0f;
                seek_celsius.setProgress(0);
                seek_fahrenheit.setProgress(0);
                cel_fah.setChecked(false);
                fah_cel.setChecked(false);

            }
        });
    }
    private void seek_System(SeekBar celsius, SeekBar fahrenheit) {

    }


    private void init() {
        seek_celsius = findViewById(R.id.seek_celsius);
        seek_fahrenheit = findViewById(R.id.seek_fahrenheit);
        group_trans = findViewById(R.id.group_trans);
        cel_fah = findViewById(R.id.btn_cel_fah);
        fah_cel = findViewById(R.id.btn_fah_cel);
        btn_trans = findViewById(R.id.btn_trans);
        btn_init = findViewById(R.id.btn_init);
        num_cel = findViewById(R.id. num_cel);
        num_fah = findViewById(R.id. num_fah);
        str_result = findViewById(R.id.str_result);
    }
}