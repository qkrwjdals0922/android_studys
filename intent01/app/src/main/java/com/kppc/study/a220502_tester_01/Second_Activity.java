package com.kppc.study.a220502_tester_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
    Button back_btn;
    TextView get_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("SecondActivity");
        get_text = findViewById(R.id.getText);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        get_text.setText(message);
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("message", "감사합니다.");
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}