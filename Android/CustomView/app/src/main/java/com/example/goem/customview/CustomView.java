package com.example.goem.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by GoEM on 2017-09-18.
 */

public class CustomView extends View {

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //사각형 그리기
        Paint paint = new Paint(); //물감
        paint.setColor(Color.MAGENTA);

        canvas.drawRect(100, 100, 200, 200, paint);
    }
}
