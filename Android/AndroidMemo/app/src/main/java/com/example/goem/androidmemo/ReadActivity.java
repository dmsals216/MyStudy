package com.example.goem.androidmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.goem.androidmemo.domain.Memo;
import com.example.goem.androidmemo.util.FileUtil;

import java.text.SimpleDateFormat;

public class ReadActivity extends AppCompatActivity {
    FileUtil fileUtil = new FileUtil();
    private TextView readTitle;
    private TextView readDate;
    private TextView readAuthor;
    private TextView readContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);


        initView();
        setReadView();
    }

    private void initView() {
        readTitle = (TextView) findViewById(R.id.readTitle);
        readDate = (TextView) findViewById(R.id.readDate);
        readAuthor = (TextView) findViewById(R.id.readAuthor);
        readContent = (TextView) findViewById(R.id.readContent);
    }

    private void setReadView() {
        Intent intent = getIntent();
        int no = Integer.parseInt(intent.getStringExtra("no")) - 1;
        try {
            Memo memo = fileUtil.getMemo(this, no);
            readTitle.setText(memo.getTitle());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
            String result = sdf.format(memo.getDatetime());
            readDate.setText(result);
            readAuthor.setText(memo.getAuthor());
            readContent.setText(memo.getContent());
        }catch(Exception e) {
            Toast.makeText(this, "에러 : " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
