package com.example.goem.paint_first;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by GoEM on 2017-09-18.
 */

public class CustomView extends View {
    ArrayList<ValuesForPaint> pathList;

    Paint paint;

    int strokeSize = 0;
    int paintColor = Color.BLACK;

    public CustomView(Context context) {
        super(context);
        pathList = new ArrayList<>();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        createPath();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pathList.get(pathList.size() - 1).moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                pathList.get(pathList.size() - 1).lineTo(event.getX(), event.getY());
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < pathList.size(); i++) {
            Paint p = new Paint();
            p.setColor(pathList.get(i).getColor());
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(pathList.get(i).getSeekbarNum() + 20);
            canvas.drawPath(pathList.get(i), p);
        }
        super.onDraw(canvas);
    }

    public void setColor(int color) {
        createPath();
        paintColor = color;
        pathList.get(pathList.size() - 1).setColor(color);
        pathList.get(pathList.size() - 1).setSeekbarNum(strokeSize);
    }

    public void setStrokeSize(int size) {
        createPath();
        strokeSize = size;
        pathList.get(pathList.size() - 1).setColor(paintColor);
        pathList.get(pathList.size() - 1).setSeekbarNum(size);
    }

    private void createPath() {
        pathList.add(new ValuesForPaint());
    }

}
