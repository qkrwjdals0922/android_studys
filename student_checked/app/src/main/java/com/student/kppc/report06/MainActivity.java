package com.student.kppc.report06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText get_score;
    RadioGroup radioGroup;
    RadioButton radio1, radio2, radio3;
    TextView score_str, grade_str;

    String score_result, grade_result;
    int score_int, grade_int;
    String rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_btn1:
                        score_result = get_score.getText().toString();
                        score_int = Integer.parseInt(score_result);
                        checked_score1(score_int);
                        score_str.setText("점수: "+score_result);
                        grade_str.setText("평점: "+rank);
                        break;
                    case R.id.radio_btn2:
                        score_result = get_score.getText().toString();
                        score_int = Integer.parseInt(score_result);
                        checked_score2(score_int);
                        score_str.setText("점수: "+score_result);
                        grade_str.setText("평점: "+rank);
                        break;
                    case R.id.radio_btn3:
                        score_result = get_score.getText().toString();
                        score_int = Integer.parseInt(score_result);
                        checked_score3(score_int);
                        score_str.setText("점수: "+score_result);
                        grade_str.setText("평점: "+rank);
                        break;
                }
            }
        });

    }

//  수우미양가로 체크하는 함수
    private void checked_score1(int score){
        if (score >= 90){
            rank = "수";
        }else if (score >= 80 || score >= 89){
            rank = "우";
        }else if (score >= 70 || score >= 79){
            rank = "미";
        }else if (score >= 60 || score >= 69){
            rank = "양";
        } else {
            rank = "가";
        }

    }
//  ABCDEF로 체크하는 함수
    private void checked_score2(int score){
        if (score >= 90){
            rank = "A";
        }else if (score >= 80 || score >= 89){
            rank = "B";
        }else if (score >= 70 || score >= 79){
            rank = "C";
        } else if (score >= 60 || score >= 69){
            rank = "D";
        } else {
            rank = "F";
        }

    }
//  A+A0로 체크하는 함수
    private void checked_score3(int score){
        if (score >= 95){
            rank = "A⁺";
        }else if (score >= 90 || score >= 94){
            rank = "A°";
        }else if (score >= 85 || score >= 89){
            rank = "B⁺";
        }else if (score >= 80 || score >= 84){
            rank = "B°";
        }else if (score >= 75 || score >= 79){
            rank = "C⁺";
        }else if (score >= 70 || score >= 74){
            rank = "C°";
        } else if (score >= 65 || score >= 69){
            rank = "D⁺";
        } else if (score >= 60 || score >= 64){
            rank = "D°";
        } else {
            rank = "F";
        }

    }

    private void init() {
        get_score = findViewById(R.id.getResult);
        radioGroup = findViewById(R.id.radio_group);
        radio1 = findViewById(R.id.radio_btn1);
        radio2 = findViewById(R.id.radio_btn2);
        radio3 = findViewById(R.id.radio_btn3);
        score_str = findViewById(R.id.score_text);
        grade_str = findViewById(R.id.grade_text);
    }
}