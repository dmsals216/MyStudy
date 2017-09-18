package com.example.goem.paint_first;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by GoEM on 2017-09-18.
 */

public class ValuesForPaint extends Path{
    int color;
    int seekbarNum;

    public ValuesForPaint() {
        color = Color.BLACK;
        seekbarNum = 0;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSeekbarNum() {
        return seekbarNum;
    }

    public void setSeekbarNum(int seekbarNum) {
        this.seekbarNum = seekbarNum;
    }
}
