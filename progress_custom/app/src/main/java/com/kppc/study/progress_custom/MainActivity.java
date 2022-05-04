package com.kppc.study.progress_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView str_rate1, str_rate2;
        ProgressBar progress_rate1, progress_rate2;
        SeekBar seek_rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        seek_rate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_rate1.setProgress(progress);
                progress_rate2.setProgress(progress);
                str_rate1.setText(String.format("%d %%", progress));
                str_rate2.setText(String.format("%d %%", progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void init() {
        str_rate1 = findViewById(R.id.str_rate);
        str_rate2 = findViewById(R.id.str_rate2);
        progress_rate1 = findViewById(R.id.progress_rate);
        progress_rate2 = findViewById(R.id.progress_rate2);
        seek_rate = findViewById(R.id.seek_rate);
    }
}