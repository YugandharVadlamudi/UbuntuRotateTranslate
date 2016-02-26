package com.example.kiran.ubunturotatetranslate;

import android.animation.Animator;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity  {
    ImageView iv_ubuntu;
    Animator.AnimatorListener al_changeimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_ubuntu = (ImageView) findViewById(R.id.iv_ubuntu_logo);
        final Animation a_rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        a_rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(getApplicationContext(),"123",Toast.LENGTH_SHORT).show();
//                a_rotate.start();
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Animation a_translate=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                iv_ubuntu.setAnimation(a_translate);
//                iv_ubuntu.setImageResource(R.drawable.spotify_icon);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(getApplicationContext(),"animation repeat",Toast.LENGTH_SHORT).show();
//                iv_ubuntu.setImageResource(R.drawable.spotify_icon);
            }
        });
        iv_ubuntu.setAnimation(a_rotate);
    }
}