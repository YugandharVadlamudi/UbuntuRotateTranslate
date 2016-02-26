package com.example.kiran.ubunturotatetranslate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Kiran on 26-11-2015.
 */
public class slidedown extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slidedown);
        final View view = (View) findViewById(R.id.iv_spotify_logo);
//        Animation a= AnimationUtils.loadAnimation(this,R.anim.scale);
        final int width = this.getResources().getDisplayMetrics().widthPixels;
        final int height = this.getResources().getDisplayMetrics().heightPixels;
        //     view.startAnimation(a);
        ScaleAnimation anim = new ScaleAnimation(1, (width / 10), 1, (height / 10), 1, 1);
        anim.setDuration(10000);
        view.setAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
//                Toast.makeText(getApplicationContext(), Integer.toString(view.getHeight()), Toast.LENGTH_SHORT).show();
                view.setLayoutParams(new LinearLayout.LayoutParams(width, (height / 2)));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

}
