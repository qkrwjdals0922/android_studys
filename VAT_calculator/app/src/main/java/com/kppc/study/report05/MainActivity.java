package com.kppc.study.report05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input_num;
    RadioGroup checked_btn;
    Button cou_btn;
    TextView result01, result02;

    String get_num, set_result01, set_result02;
    int i_num;
    float i_result01, i_result02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        cou_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_num = input_num.getText().toString();

                checked_btn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        i_num = Integer.parseInt(get_num);
                        switch (checkedId) {
                            case R.id.radio1:
                                i_result01 = i_num % 10;
                                Log.d("code:101:", "버림버튼의 계산 결과" + i_result01);
                                break;
                            case R.id.radio2:
                                i_result01 = i_num % 10;
                                Log.d("code:102:", "버림버튼의 계산 결과" + i_result01);
                                break;
                            case R.id.radio3:
                                i_result01 = i_num % 10;
                                Log.d("code:103:", "버림버튼의 계산 결과" + i_result01);
                                break;
                            default:
                                i_result01 = 0;
                                Log.d("code:104:", "버림버튼의 계산 결과" + i_result01);
                                break;
                        }
                    }
                });
                Log.d("code:001:", "get_num 은 "+get_num);
                if (!(get_num == null)) {
                    Log.d("code:002:", "i_num 은 "+i_num);
                } else {
                    Log.e("code:404:", "EditText 에 값이 없습니다.");
                    Toast.makeText(getBaseContext(), "판매 금액을 정확히 입력해 주시기 바랍니다.", Toast.LENGTH_SHORT).show();
                }

                result01.setText("가격:"+i_result01+"원");
            }
        });


    }

    private void init() {
        input_num = findViewById(R.id.input_num);
        checked_btn = findViewById(R.id.radio_go);
        cou_btn = findViewById(R.id.cou_btn);
        result01 = findViewById(R.id.result_01);
        result02 = findViewById(R.id.result_02);
    }
}