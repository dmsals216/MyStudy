package com.example.goem.customview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class DrawActivity extends AppCompatActivity {
    FrameLayout stage;
    DrawView draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        stage = (FrameLayout) findViewById(R.id.stage);
        draw = new DrawView(this);
        stage.addView(draw);

        findViewById(R.id.btn_blue).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                draw.setPaintColor(Color.BLUE);
            }
        });
        findViewById(R.id.btn_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw.setPaintColor(Color.RED);
            }
        });
    }
}
