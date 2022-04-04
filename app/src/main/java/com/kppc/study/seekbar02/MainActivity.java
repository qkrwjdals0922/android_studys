package com.kppc.study.seekbar02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar get_red, get_blue, get_green;
    TextView str_red, str_blue, str_green, color;
    int red = 0, blue = 0, green = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        get_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                str_red.setText(String.format("%d(%h)", red, red));
                changeColorText(red, green, blue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        get_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                str_green.setText(String.format("%d(%h)", green, green));
                changeColorText(red, green, blue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        get_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                str_blue.setText(String.format("%d(%h)", blue, blue));
                changeColorText(red, green, blue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void changeColorText(int red, int green, int blue) {
        int rgb = Color.rgb(red, green, blue);
        String temp = String.format("%2H%2H%2H", red, green, blue);
        String code = temp.replaceAll(" ", "0");
        if (code.compareTo("800000") < 0) {
            color.setTextColor(Color.WHITE);
        }else {
            color.setTextColor(Color.BLACK);
        }
        color.setBackgroundColor(rgb);
        color.setText(code);
    }

    private void init() {
        get_red = findViewById(R.id.getRed);
        get_blue = findViewById(R.id.getBlue);
        get_green = findViewById(R.id.getGreen);
        str_red = findViewById(R.id.strRed);
        str_blue = findViewById(R.id.strBlue);
        str_green = findViewById(R.id.strGreen);
        color = findViewById(R.id.result);
    }
}