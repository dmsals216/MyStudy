package com.example.goem.androidmemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.goem.androidmemo.domain.Memo;
import com.example.goem.androidmemo.util.FileUtil;

public class WriteActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;
    FileUtil fileUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        fileUtil = new FileUtil();
        initView();
    }

    private void addList() {
        Memo memo = new Memo();
        memo.setNo(fileUtil.getIndexNumber(this));
        memo.setAuthor(editAuthor.getText() + "");
        memo.setTitle(editTitle.getText() + "");
        memo.setContent(editContent.getText() + "");
        memo.setDatetime(System.currentTimeMillis());
        try {
            fileUtil.createFile(this, memo);
            setResult(RESULT_OK);
        }catch(Exception e) {
            Toast.makeText(this, "에러 : " + e.toString(),Toast.LENGTH_SHORT);
        }
    }

    public void pushPostButton(View view) {
        addList();
        finish();
    }

    private void initView() {
        editTitle = (EditText) findViewById(R.id.editTitle);
        editAuthor = (EditText) findViewById(R.id.editAuthor);
        editContent = (EditText) findViewById(R.id.editContent);
    }
}
