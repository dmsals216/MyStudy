package com.example.goem.androidmemo.util;

import android.content.Context;
import android.graphics.Paint;

import com.example.goem.androidmemo.domain.Memo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by GoEM on 2017-09-20.
 */

public class FileUtil {

    public int getIndexNumber(Context context) {
        return context.getFilesDir().listFiles().length + 1;
    }

    public void createFile(Context context, Memo memo) throws Exception{
        String temp = memo.toString();
        String imsi = memo.getDatetime() + ".txt";
        FileOutputStream fos = fos = context.openFileOutput(imsi, Context.MODE_PRIVATE);
        fos.write(temp.getBytes());
        fos.close();
    }

    public ArrayList<Memo> getMemoList(Context context) throws Exception{
        ArrayList<Memo> list = new ArrayList<>();
        for(File item : context.getFilesDir().listFiles()) {
            String text = read(context, item.getName());
            Memo memo = new Memo(text);
            list.add(memo);

        }
        return list;
    }

    public String read(Context context, String filename) throws Exception{
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = context.openFileInput(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte buffer[] = new byte[1024];
        int count = 0;
        while( (count = bis.read(buffer)) != -1 ) {
            String data = new String(buffer, 0, count);
            sb.append(data);
        }
        bis.close();
        fis.close();
        return sb.toString();
    }

    public Memo getMemo(Context context, int no) throws Exception{
        ArrayList<Memo> list = new ArrayList<>();
        Memo memo = null;
        int check = 0;
        for(File item : context.getFilesDir().listFiles()) {
            if(check == no) {
                String text = read(context, item.getName());
                memo = new Memo(text);
                break;
            }
            check++;
        }
        return memo;
    }

}
