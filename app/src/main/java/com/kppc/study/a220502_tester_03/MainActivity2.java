package com.kppc.study.a220502_tester_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    Button call, dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[] PERMISSIONS = {Manifest.permission.CALL_PHONE};
        ActivityCompat.requestPermissions(MainActivity2.this, PERMISSIONS, 100);
        init_id();
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01023131232"));
                startActivity(intent);
            }
        });
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01023131232"));
                startActivity(intent);
            }
        });

    }

    private  void init_id() {
        textView = findViewById(R.id.textView);
        call = findViewById(R.id.button);
        dial = findViewById(R.id.button2);
    }
}