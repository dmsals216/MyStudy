package com.example.goem.androidmemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.goem.androidmemo.domain.Memo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by GoEM on 2017-09-20.
 */

public class ListAdapter extends BaseAdapter {
    ArrayList<Memo> list;
    Context context;

    public ListAdapter(Context context, ArrayList<Memo> list) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(convertView == null){ // 뷰가 최초 생성될경우
            // 1. 뷰 생성
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            // 2. 홀더생성
            holder = new Holder(convertView);
            // 3. 뷰에 홀더를 붙인다
            convertView.setTag(holder);
        }else{ // 뷰가 두번째 호출되면 (즉 한화면이 넘어가면)
            // 1. 뷰에 붙인 홀더를 꺼낸다
            holder = (Holder) convertView.getTag();
        }
        Memo memo = list.get(position);

        holder.setNo(memo.getNo());
        holder.setTitle(memo.getTitle());
        holder.setDate(memo.getDatetime());
        return convertView;
    }
}

class Holder {
    private TextView textNo;
    private TextView textTitle;
    private TextView textDate;

    public Holder(View view) {
        textNo = (TextView) view.findViewById(R.id.textNo);
        textTitle = (TextView) view.findViewById(R.id.readTitle);
        textDate = (TextView) view.findViewById(R.id.textDate);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReadActivity.class);
                intent.putExtra("no", textNo.getText());
                view.getContext().startActivity(intent);
            }
        });
    }
    public void setNo(int no) {
        textNo.setText(no + "");
    }
    public void setTitle(String title) {
        textTitle.setText(title);
    }
    public void setDate(Long datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
        String result = sdf.format(datetime);
        textDate.setText(result);
    }
}
