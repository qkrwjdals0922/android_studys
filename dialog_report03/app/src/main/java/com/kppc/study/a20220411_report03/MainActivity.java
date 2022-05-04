package com.kppc.study.a20220411_report03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressDialog spinner_dialog;
    ProgressDialog horizontal_dialog;
    Handler handler = new Handler();
    int progress_value = 0;

    EditText input_id, input_pwd;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void spinner_onclick(View view) {dialog_ex("spinner");}

    public void horizontal_onclick(View view) {dialog_ex("horizontal");}

    public void custom_onclick(View view) {dialog_ex("custom");}

    public void dialog_ex(String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        switch (type) {
            case "spinner":
                spinner_dialog = new ProgressDialog(MainActivity.this);
                spinner_dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                spinner_dialog.setMessage("잠시만 기다려주세요");
                spinner_dialog.setButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                spinner_dialog.show();
                break;
            case "horizontal":
//              재 시작시 progress 값을 0으로 초기화한다.
                progress_value = 0;
                horizontal_dialog = new ProgressDialog(MainActivity.this);
                horizontal_dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                horizontal_dialog.setMessage("잠시만 기다려주세요");
                horizontal_dialog.setMax(100);
                horizontal_dialog.setButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                horizontal_dialog.show();
//              앱 시작시, Thread 를 시작해서 Progressbar 를 증가시키기
//              Thread 내부에서 화면에 작업을 하려면 handler 를 사용해야한다.
                Thread thread = new Thread(new Runnable() {
                @Override
                public void run() { // THread로 작업할 내용을 구현
                    while (progress_value < 100) {
                        progress_value ++;

                        handler.post(new Runnable() {
                            @Override
                            public void run() { // 화면에 변경하는 작업을 구현
                                horizontal_dialog.setProgress(progress_value);
                            }
                        });
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            });
                thread.start();

                break;
            case "custom":
                Toast.makeText(this, "c_click", Toast.LENGTH_SHORT).show();
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.coustom_dialog_layout);
                dialog.show();
                EditText get_id = dialog.findViewById(R.id.get_input_id);
                EditText get_pwd = dialog.findViewById(R.id.get_input_pwd);

                dialog.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String str_id = get_id.getText().toString();
                        String str_pwd = get_pwd.getText().toString();
                        if (!(str_id.equals("") || str_pwd.equals(""))){
                            Toast.makeText(MainActivity.this, str_id + "/" + str_pwd, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else {
                            Toast.makeText(MainActivity.this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}