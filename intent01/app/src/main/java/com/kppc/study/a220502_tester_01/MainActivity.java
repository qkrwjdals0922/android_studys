package com.kppc.study.a220502_tester_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button button;
    TextView textView;
    int state = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String message = data.getStringExtra("message");
                textView.setText(message);
            }
        }else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                //TODO getIntExtra 는 받아오는 키 값 외에도 기본값(defaultValue)를 정의해줘야 한다.
                int age = data.getIntExtra("age", 0);
                textView.setText(age + "살");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_id();
        setTitle("Main Activity");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_item1:
                        intent = new Intent(MainActivity.this, Second_Activity.class);
                        intent.putExtra("message", "안녕하세요");
                        startActivityForResult(intent, 1);
                        break;
                    case R.id.radio_item2:
                        intent = new Intent(MainActivity.this, Third_Activity.class);
                        intent.putExtra("message", "몇살이지요?");
                        startActivityForResult(intent, 2);
                        break;
                }
            }
        });
    }

    private void init_id() {
        radioGroup = findViewById(R.id.group_radio);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.text_view01);
    }
}