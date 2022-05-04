package com.kppc.study.dialog_report01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    Button btn4, btn5, btn6;
    Button btn7, btn8, btn10, btn11;

    ProgressDialog progressDialog;
    ProgressDialog progressDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_id();
//TODO(목차) 선택형 다이어로그
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_foreground);
                builder.setTitle("공지사항");
                builder.setMessage("이 앱이 지금 종료됩니다.");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
//TODO(목차) 목록화 다이어로그
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence[] color = {"빨강", "파랑", "노랑", "검정", "초록"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("색상을 선택하세요");
                builder.setItems(color, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, color[i] + "를 선택하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
//TODO(목차) Radio버튼 활용한 다이어로그
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence[] food = {"짜장면", "짬뽕", "탕수육", "갈비탕", "라면"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyAlertDialog);
                builder.setTitle("오늘 점심 메뉴는?");
                builder.setSingleChoiceItems(food, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, food[i] + "를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("선택", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
//TODO(목차) HTML데이터 불러오는 다이어로그
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strHTML = "<b><font color='#ff0000'>HTML 컨텐츠 팝업</font></b>입니다." +
                        "<br>HTML이 제대로 표현되나요?";
                Spanned oHtml = Html.fromHtml(strHTML);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("HTML Dialog 예제");
                builder.setMessage(oHtml);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
//TODO(목차) 날짜 선택 다이어로그
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String msg = year + "년";
                        msg += (month + 1) + "월";
                        msg += day + "일";
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                };

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, 0, dateSetListener, year, month, day);
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog.show();
            }
        });
//TODO(목차) 시간 선택 다이어로그
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(MainActivity.this, i + "시" + i1 + "분", Toast.LENGTH_SHORT).show();
                    }
                };
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this,0, timeSetListener, 0, 0, false);
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog.show();
            }
        });
//TODO(목차) Progress 다이어로그
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog= new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("잠시만 기다려주세요");

                progressDialog.show();


            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog1= new ProgressDialog(MainActivity.this);
                progressDialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog1.setMessage("잠시만 기다려주세요");
                progressDialog1.setMax(100);
                progressDialog1.setProgress(10);
                progressDialog1.show();
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progressDialog != null){
                    progressDialog.dismiss();
                }
            }
        });
    }

    private void get_id() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
    }
}