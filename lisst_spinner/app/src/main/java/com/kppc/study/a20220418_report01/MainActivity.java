package com.kppc.study.a20220418_report01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button input_btn, delete_btn, result_btn;
    EditText get_str;
    TextView empty_str;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    String data_str;

    int list_value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_id();

        listView.setEmptyView(empty_str);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arrayList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

//      입력버튼 클릭
        input_data();
//      삭제버튼 클릭
        edit_reset();
//      결과 출력 버튼 클릭
        view_result();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.checked_all:
                checked_all();
                break;
            case R.id.unchecked_all:
                unchecked_all();
                break;
            case R.id.exit:
                exit();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //  EditText 입력 버튼
    private void input_data() {
        input_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_str = get_str.getText().toString();
                if (!data_str.equals("")) {
                    arrayList.add(data_str);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    //  EditText 삭제 버튼
    private void edit_reset() {
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_str.setText("");
            }
        });
    }

    //  결과 버튼
    private void view_result() {
        final int[] checked_value = {};
        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(arrayList.size() == 0)) {

                    //listview 의 테마인 simple_list_item_multiple_choice 의 체크박스에서 체크상태를 받아오기위해 SparseBooleanArray 를 사용한다.
                    SparseBooleanArray booleanArray = listView.getCheckedItemPositions();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (booleanArray.get(i)) {
                            //StringBuilder 의 append 를 이용하여 booleanArray 에서 받아온 checkedState 를문자열로 변환함과 동시에 하나의 문자열로 이어준다.
                            sb.append(arrayList.get(i) + "\n");
                        }
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("선택한 회원 목록").setMessage(sb.toString()).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            Log.d("report01::dialog", "click");
                        }
                    }).setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int j) {
                            Log.d("report01::dialog", "remove");
                            //listview 의 테마인 simple_list_item_multiple_choice 의 체크박스에서 체크상태를 받아오기위해 SparseBooleanArray 를 사용한다.
                            SparseBooleanArray booleanArray = listView.getCheckedItemPositions();
                            int count = adapter.getCount();
                            for (int i = count - 1; i >= 0; i--) {
                                if (booleanArray.get(i)) {
                                    arrayList.remove(i);
                                }
                            }
                            // 모든 선택 상태 초기화
                            listView.clearChoices();
                            adapter.notifyDataSetChanged();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    Toast.makeText(MainActivity.this, "데이터를 입력해주심둥", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //  전체선택
    private void checked_all() {
        for (int i = 0; i < arrayList.size(); i++) {
            listView.setItemChecked(i, true);
        }
    }

    //  전체해제
    private void unchecked_all() {
        for (int i = 0; i < arrayList.size(); i++) {
            listView.setItemChecked(i, false);
        }
    }

    //  앱 종료
    private void exit() {
        finish();
    }

    //  id값 불러오는 함수
    private void get_id() {
        input_btn = findViewById(R.id.input);
        delete_btn = findViewById(R.id.delete);
        result_btn = findViewById(R.id.result_btn);
        get_str = findViewById(R.id.get_name);
        empty_str = findViewById(android.R.id.empty);
        listView = findViewById(android.R.id.list);
    }
}