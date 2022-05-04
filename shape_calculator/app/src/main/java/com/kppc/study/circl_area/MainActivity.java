package com.kppc.study.circl_area;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//  s = 정사각형, c = 원, cr = 반지름, r = 빨간색, w = 가로
    EditText input_ra;
    Button btn;
    TextView result_s, result_c, result_r;
    String get_c, str_s, str_c, str_r;
    float flo_s, flo_c, flo_r;
    int int_w, int_cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_c = input_ra.getText().toString();
                if (get_c.equals("")){
                    Toast.makeText(getBaseContext(), "입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    int_cr = Integer.parseInt(get_c);
                    //정사각형 면적 구하기
                    int_w =  int_cr * 2; //가로길이
                    flo_s = int_w * int_w;
                    str_s = String.format("%.2f", flo_s);
                    result_s.setText("정사각형의 면적: " + str_s + "㎠");
                    //원의 면적 구하기
                    flo_c = int_cr * int_cr * 3.14f;
                    str_c = String.format("%.2f", flo_c);
                    result_c.setText("원의 면적: " + str_c + "㎠");
                    //빨간면의 면적
                    flo_r = flo_s - flo_c;
                    str_r = String.format("%.2f", flo_r);
                    result_r.setText("빨간 부분의 면적: " + str_r + "㎠");
                }
            }
        });

    }
//  findViewById 전용 함수
    private void init() {
        //원의 반지름 받는 값
        input_ra = findViewById(R.id.input_radius);
        //계산하기 버튼
        btn = findViewById(R.id.btn);
        //정사각형 면적 결과값
        result_s = findViewById(R.id.result_square);
        //원의 면적 결과값
        result_c = findViewById(R.id.result_circular);
        //빨간 부분의 면적 결과값
        result_r = findViewById(R.id.result_red);
    }
}