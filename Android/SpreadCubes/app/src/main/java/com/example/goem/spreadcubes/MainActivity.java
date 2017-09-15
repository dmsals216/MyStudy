package com.example.goem.spreadcubes;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_spread, btn_pink, btn_blue, btn_yellow, btn_purple;
    int check = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_spread = (Button) findViewById(R.id.btn_Spread);
        btn_pink = (Button) findViewById(R.id.btn_pink);
        btn_blue = (Button) findViewById(R.id.btn_blue);
        btn_yellow = (Button) findViewById(R.id.btn_yellow);
        btn_purple = (Button) findViewById(R.id.btn_purple);

    }




    public void clickButton(View v) {
        if(check == 1) {
            setAnimator(btn_blue);
            setAnimator(btn_pink);
            setAnimator(btn_purple);
            setAnimator(btn_yellow);
            check = 2;
            btn_spread.setText("combine");
        }else if(check == 2) {
            setAnimator(btn_blue);
            setAnimator(btn_pink);
            setAnimator(btn_purple);
            setAnimator(btn_yellow);
            check = 1;
            btn_spread.setText("spread");
        }
    }

    private void setAnimator(Button b) {
        float x = 0;
        float y = 0;
        int rot;
        if(check == 1) {
            if (b.getId() == btn_purple.getId()) {
                x = 300;
                y = 300;
            } else if (b.getId() == btn_pink.getId()) {
                x = 300;
                y = -300;
            } else if (b.getId() == btn_blue.getId()) {
                x = -300;
                y = 300;
            } else {
                x = -300;
                y = -300;
            }
            rot = 1800;
        }else {
            rot = 0;
        }
        ObjectAnimator aniX = ObjectAnimator.ofFloat(b, "translationX", x);
        ObjectAnimator aniY = ObjectAnimator.ofFloat(b, "translationY", y);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(b, "rotation", rot);
        rotation.setDuration(3000);
        aniX.setDuration(2000);
        aniY.setDuration(2000);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(aniY, aniX, rotation);
        aniSet.setInterpolator(new AccelerateInterpolator());
        aniSet.start();
    }
}
