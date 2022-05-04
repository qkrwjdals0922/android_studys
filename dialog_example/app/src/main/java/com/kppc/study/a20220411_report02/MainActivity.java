package com.kppc.study.a20220411_report02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alert_onClick(View view) {
        alert_ex("alert");
    }

    public void input_onClick(View view) {
        alert_ex("input");
    }

    public void list_onClick(View view) {
        alert_ex("list");
    }

    public void alert_ex(String type){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        switch (type) {
//TODO(type) 알림 다이얼그램 버튼 클릭시
            case "alert":
                builder.setIcon(R.drawable.ic_warning).setTitle("알림").setMessage("이번주 레포트는 Dialog입니다.");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "확인했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
//TODO(type) 입력 다이얼그램 버튼 클릭시
            case "input":
                final EditText input = new EditText(this);
                builder.setTitle("이름 입력").setView(input);
                
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                         if (input.getText().toString().equals("")){
                             Toast.makeText(MainActivity.this, "입력해주세요.", Toast.LENGTH_SHORT).show();
                         } else {
                             Toast.makeText(MainActivity.this, "입력한 값은 " + input.getText().toString() + " 입니다.", Toast.LENGTH_SHORT).show();
                         }
                        
                    }
                });
                builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                break;
//TODO(type) 리스트 다이얼그램 버튼 클릭시
            case "list":
                CharSequence[] grade = {"1학년", "2학년", "3학년", "4학년"};
                builder.setTitle("몇 학년 입니까?");
                final int[] b = {-1};
                builder.setSingleChoiceItems(R.array.grade, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b[0] = i;
                    }
                });
                builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (b[0] == -1){
                            Toast.makeText(MainActivity.this, "학년을 입력해주세요" , Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "선택한 학년 : " + grade[b[0]], Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}