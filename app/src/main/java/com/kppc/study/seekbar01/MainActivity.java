package com.kppc.study.seekbar01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    Button btn;
    TextView tv1, tv2;
    float radius = 0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//             seek바의 데이터를 int값으로 받아옴
               radius = (progress * 0.5f) + 0.5f;
               tv1.setText("원의 반지름: "+radius+"cm");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radius <= 0) {
                    Toast.makeText(getBaseContext(), "입력 해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    float area = (float) Math.PI * radius * radius;
                    tv2.setText("원의 면적은: "+area+"cm2");
                }
            }
        });

    }

    private void init() {
        seekBar = findViewById(R.id.seekbar);
        btn = findViewById(R.id.btn);
        tv1 = findViewById(R.id.textview1);
        tv2 = findViewById(R.id.textview2);
    }
}