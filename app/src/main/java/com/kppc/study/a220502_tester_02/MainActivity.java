package com.kppc.study.a220502_tester_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button, button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        button.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent();
                //TODO 다른 프로젝트(앱)의 패키지명과 엑티비티가 속해있는 패키지명을 불러와서 Action을 연결해주면 다른 프로젝트로 연결될 수 있다.
                intent.setClassName("com.kppc.study.a220502_tester_01", "com.kppc.study.a220502_tester_01.MainActivity");
                intent.setAction("custom.APPSTART");
                startActivity(intent);
                break;
            case R.id.button3:
                //TODO 폐키지의 위치가 어디인지 모르는것을 암시적이라 한다.
                intent = new Intent("com.kppc.other");
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent("com.example2.other");
                intent.putExtra("message", "경복대 화이팅!");
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(this, "엑티비티가 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button5:
                intent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                startActivity(intent);
                break;
        }
    }
}