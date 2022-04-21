package com.student.kppc.a20220419_report02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    List<String> list;
    ArrayAdapter<String> adapter;
    ArrayAdapter<CharSequence> characterArrayAdapter;
    int type = 0;
    String[] str_array = new String[]{"일요일(SUN)", "월요일(MON)", "화요일(TUE)", "수요일(WED)", "목요일(THU)", "금요일(FRI)", "토요일(SAT)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_id();
        arrayList = new ArrayList<>();
        list = new ArrayList<>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_array);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(MainActivity.this);
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                type = 1;
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_array);
                break;
            case R.id.item2:
                type = 2;
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.list_item2));
                break;
            case R.id.item3:
                type = 3;
                list.add("일요일");
                list.add("월요일");
                list.add("화요일");
                list.add("수요일");
                list.add("목요일");
                list.add("금요일");
                list.add("토요일");
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
                break;
            case R.id.item4:
                type = 4;
                characterArrayAdapter = ArrayAdapter.createFromResource(this, R.array.list_item1, android.R.layout.simple_list_item_1);
                break;
            default:
        }
        if (!(type==4)){
            listView.setAdapter(adapter);
        }else {
            listView.setAdapter(characterArrayAdapter);
        }
        return super.onOptionsItemSelected(item);
    }

    private void get_id() {
        listView = findViewById(android.R.id.list);
    }
}