package com.example.goem.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

/**
 * Created by GoEM on 2017-09-18.
 */

public class AniButton extends AppCompatButton implements View.OnTouchListener{
    String animation;

    public AniButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // attrs.xml에 정의된 속성을 가져온다.
        TypedArray typed = context.obtainStyledAttributes(attrs, R.styleable.AniButton);
        // 해당 이름으로 정의된 속성의 개수를 가져온다.;
        int size = typed.getIndexCount();
        // 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
        for(int i = 0; i < size; i++) {
            // 현재 배열에 있는 속성 아이디 가져오기
            int curerent_attr = typed.getIndex(i);
            switch (curerent_attr) {
                case R.styleable.AniButton_animation :
                    animation = typed.getString(curerent_attr);
            }
        }
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            runAnimation();
        }

        return false;
    }

    public void runAnimation() {
        ObjectAnimator aniX = ObjectAnimator.ofFloat(this, "scaleX", 1.2f, 1.0f);
        ObjectAnimator aniY = ObjectAnimator.ofFloat(this, "scaleY", 1.2f, 1.0f);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(aniX, aniY);
        aniSet.setDuration(3000);
        aniSet.start();
    }
}
