package com.example.goem.paint_first;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    FrameLayout stage;
    CustomView customView;
    int process = 0;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stage = (FrameLayout) findViewById(R.id.stage);
        customView = new CustomView(this);
        stage.addView(customView);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        findViewById(R.id.btn_black).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.setColor(Color.BLACK);
            }
        });
        findViewById(R.id.btn_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.setColor(Color.RED);
            }
        });
        findViewById(R.id.btn_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.setColor(Color.BLUE);
            }
        });
        findViewById(R.id.btn_yello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.setColor(Color.YELLOW);
            }
        });

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.process = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        customView.setStrokeSize(process);
    }
}
