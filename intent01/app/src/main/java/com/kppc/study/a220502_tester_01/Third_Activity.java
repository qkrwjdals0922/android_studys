package com.kppc.study.a220502_tester_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Third_Activity extends AppCompatActivity {

    Button back_btn;
    TextView text01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("ThirdActivity");
        text01 =findViewById(R.id.getText1);
        Intent intent = getIntent();
        String temp = intent.getStringExtra("message");
        text01.setText(temp);

        back_btn = findViewById(R.id.back_btn_third);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("age", 12);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}