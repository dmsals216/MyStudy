package com.example.goem.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by GoEM on 2017-09-18.
 */

public class DrawView extends View {
    ArrayList<Paint> paint;
    ArrayList<Path> currentPath;

    public DrawView(Context context) {
        super(context);
        paint = new ArrayList<>();
        currentPath = new ArrayList<>();
        Paint paintImsi = new Paint();
        paintImsi.setColor(Color.RED);
        paintImsi.setStyle(Paint.Style.STROKE);
        paintImsi.setStrokeWidth(5f);
        paint.add(paintImsi);
        Path path = new Path();
        currentPath.add(path);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i < currentPath.size(); i++) {
            canvas.drawPath(currentPath.get(i), paint.get(i));
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath.get(currentPath.size() - 1).moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                currentPath.get(currentPath.size() - 1).lineTo(event.getX(), event.getY());
                break;
        }

        invalidate();
        return true;
    }

    public void setPaintColor(int color) {
        Paint paintImsi = new Paint();
        paintImsi.setColor(color);
        paintImsi.setStyle(Paint.Style.STROKE);
        paintImsi.setStrokeWidth(5f);
        paint.add(paintImsi);
        Path path = new Path();
        currentPath.add(path);

    }
}
