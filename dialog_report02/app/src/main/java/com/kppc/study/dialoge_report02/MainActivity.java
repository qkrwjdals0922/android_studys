package com.kppc.study.dialoge_report02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher_background).setTitle("공지 사항").setMessage("이 메시지는 반드시 읽어야 합니다.");
        builder.setPositiveButton("닫기", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void radio_onclick(View view) {
        String[] Android = {"젤라빈", "핏켓", "롤리팝"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.ic_launcher_background).setTitle("좋아하는 안드로이드 버전은? ");
        builder.setSingleChoiceItems(Android, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, Android[i]+"가 선택되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("선택", null);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void check_onclick(View view) {
        boolean[] select = {false, false, false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("좋아하는 음식은?");
        builder.setMultiChoiceItems(R.array.foods, select, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                select[i] = b;
            }
        });

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String[] food = getResources().getStringArray(R.array.foods);
                String result ="";
                for (int j = 0; j < select.length; j++) {
                    if (select[j]){
                        result += food[j] + " ";
                    }
                }
                result = result.trim();
//              공백을 찾아서 ,로 바꿔주는 수식
                result = result.replaceAll(" ", ", ");
                if (result.equals("")){
                    result = "없음";
                }
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onclick2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.app.AlertDialog.THEME_HOLO_LIGHT);
        builder.setIcon(R.drawable.ic_launcher_background).setTitle("공지 사항").setMessage("이 메시지는 반드시 읽어야 합니다.");
        builder.setPositiveButton("닫기", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}