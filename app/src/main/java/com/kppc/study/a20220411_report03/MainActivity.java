package com.kppc.study.a20220411_report03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressDialog spinner_dialog;
    ProgressDialog horizontal_dialog;
    Handler handler = new Handler();
    int progress_value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void spinner_onclick(View view) {
        dialog_ex("spinner");
    }

    public void horizontal_onclick(View view) {
        dialog_ex("horizontal");

    }

    public void custom_onclick(View view) {

    }

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
                horizontal_dialog = new ProgressDialog(MainActivity.this);
                horizontal_dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                horizontal_dialog.setMessage("잠시만 기다려주세요");
                horizontal_dialog.setMax(100);
                horizontal_dialog.show();

                while (progress_value < 100) {
                    progress_value++;
                }
                break;
            case "custom":
                Toast.makeText(this, "c_click", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}