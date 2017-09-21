package com.example.goem.androidmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.goem.androidmemo.domain.Memo;
import com.example.goem.androidmemo.util.FileUtil;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {
    private static final int WRITE_ACTIVITY = 10;

    ListView listView;
    FileUtil fileUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        fileUtil = new FileUtil();
        initView();
        setList();
    }

    private void setList() {
        ArrayList<Memo> list = new ArrayList<>();
        try {
            list = fileUtil.getMemoList(this);
        }catch(Exception e) {
            Toast.makeText(this, "에러 : " + e.toString(), Toast.LENGTH_SHORT).show();
        }
        ListAdapter listAdapter = new ListAdapter(this, list);
        listView.setAdapter(listAdapter);
    }

    public void goWriteActivity(View view) {
        Intent intent = new Intent(this, WriteActivity.class);
        startActivityForResult(intent, WRITE_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == WRITE_ACTIVITY) {
            if(resultCode == RESULT_OK) {
                setList();
            }
        }
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
    }
}
