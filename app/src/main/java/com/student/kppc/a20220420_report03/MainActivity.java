package com.student.kppc.a20220420_report03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.icu.util.Freezable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Fruit> FruitArrayList = new ArrayList<>();
        spinner = findViewById(R.id.spinner);

        Fruit hint = new Fruit();
        hint.setText("과일을 고르세요");
        hint.setColor(Color.BLACK);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hint.setColor(Color.RED);
                if (!FruitArrayList.get(i).getText().equals("과일을 고르세요")) {
                    Toast.makeText(MainActivity.this, FruitArrayList.get(i).getText() + "는 맛있다.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        FruitArrayList.add(hint);

        Fruit apple = new Fruit();
        list_add("사과", apple, FruitArrayList);

        Fruit StrawBerry = new Fruit();
        list_add("딸기", StrawBerry, FruitArrayList);

        Fruit WaterMelon = new Fruit();
        list_add("수박", WaterMelon, FruitArrayList);

        Fruit Banana = new Fruit();
        list_add("바나나", Banana, FruitArrayList);

        Fruit Persimmon = new Fruit();
        list_add("감", Persimmon, FruitArrayList);

        Fruit Peach = new Fruit();
        list_add("복숭아", Peach, FruitArrayList);

        Fruit plum = new Fruit();
        list_add("자두", plum, FruitArrayList);

        spinner_adapter spinnerAdapter = new spinner_adapter(this, FruitArrayList);
        spinner.setAdapter(spinnerAdapter);

    }

    private void list_add(String fruit_str, Fruit 야발, List<Fruit> list) {
        야발.setText(fruit_str);
        야발.setColor(Color.BLACK);
        list.add(야발);
    }

    public static class Fruit {
        private int Color;
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getColor() {
            return Color;
        }

        public void setColor(int color) {
            Color = color;
        }
    }

    public static class spinner_adapter extends BaseAdapter {
        private Context context;
        private List<Fruit> getSets;

        public spinner_adapter(Context context, List<Fruit> getSets) {
            this.context = context;
            this.getSets = getSets;
        }

        @Override
        public int getCount() {
            return getSets != null ? getSets.size() : 0;
        }

        @Override
        public Object getItem(int i) {
            return getSets.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View rootView = LayoutInflater.from(context).
                    inflate(R.layout.dropdawn_item, viewGroup, false);

            TextView text = rootView.findViewById(R.id.text);
            text.setText(getSets.get(i).getText());
            text.setTextColor(getSets.get(i).getColor());
            text.setTextSize(20);


            return rootView;
        }
    }
}