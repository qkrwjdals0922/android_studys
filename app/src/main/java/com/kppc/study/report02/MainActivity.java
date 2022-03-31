package com.kppc.study.report02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup checked_grade;
    LinearLayout layout01;
    EditText input_school, input_major, input_name;
    CheckBox checked_student;
    Button action_student;
    String school, name, major, grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//      화면 가시화 유무 code001
        layout01.setVisibility(View.GONE);
        checked_student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d("checked_student::001: ", "layout:state:visible");
                    layout01.setVisibility(View.VISIBLE);
                } else {
                    Log.d("checked_student::001: ", "layout:state:gone");
                    layout01.setVisibility(View.GONE);
                }
            }
        });

        action_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                school = input_school.getText().toString();
                major = input_major.getText().toString();
                name = input_name.getText().toString();
//              grade 조건부 변수 지정 code002
                checked_grade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        grade = "";
                        switch (checkedId) {
                            case R.id.grade_radio1:
                                Log.d("checked_grade::002:", ":grade::first");
                                grade = getString(R.string.str_first_grade);
                                break;
                            case R.id.grade_radio2:
                                Log.d("checked_grade::002:", ":grade::second");
                                grade = getString(R.string.str_second_grade);
                                break;
                            case R.id.grade_radio3:
                                Log.d("checked_grade::002:", ":grade::three");
                                grade = getString(R.string.str_three_grade);
                                break;
                        }
                    }
                });
//              입력 유효성 체크 code400
                if (school.equals("")){
                    Log.d("check_null::401:", ":school::null");
                    Toast.makeText(getBaseContext(), "입력하세요", Toast.LENGTH_SHORT).show();
                    input_school.setError("학교 이름을 정확히 입력해주세요");
                }else if (major.equals("")){
                    Log.d("check_null::402:", ":major::null");
                    Toast.makeText(getBaseContext(), "입력하세요", Toast.LENGTH_SHORT).show();
                    input_major.setError("학과 이름을 정확히 입력해주세요");
                }else if (name.equals("")){
                    Log.d("check_null::403:", ":name::null");
                    Toast.makeText(getBaseContext(), "입력하세요", Toast.LENGTH_SHORT).show();
                    input_name.setError("이름을 정확히 입력해주세요");
                }else if (grade.equals("")){
                    Log.d("check_null::404:", ":grade:radio::ERROR::null");
                    Toast.makeText(getBaseContext(), "입력하세요", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getBaseContext(), "에러가 발생했습니다. 엔지니어에게 요청하세요", Toast.LENGTH_SHORT).show();
                }else {

                }


            }
        });


    }
    private void init() {
        checked_student = findViewById(R.id.check_student);
        input_school = findViewById(R.id.input_school_name);
        input_major = findViewById(R.id.input_major_name);
        input_name = findViewById(R.id.input_name);
        layout01 = findViewById(R.id.layout01);
        checked_grade = findViewById(R.id.grade_group);
        action_student = findViewById(R.id.btn);
    }
}