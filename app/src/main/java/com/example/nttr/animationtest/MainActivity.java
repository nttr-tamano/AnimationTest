package com.example.nttr.animationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation animation;
    Animation animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 設定
        animation = AnimationUtils.loadAnimation(this,R.anim.motion);
        animation.setFillAfter(true);   //終了後を保持
        animation.setFillEnabled(true);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.motion2);
        animation2.setFillAfter(true);   //終了後を保持
        animation2.setFillEnabled(true);

        TextView tv = (TextView) findViewById(R.id.textview);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // アニメーション
                // http://techbooster.org/android/ui/2018/
                // https://qiita.com/kazy/items/0ef55e1d750a49a9192f

                // xmlの加速とかの定義
                // http://www.adakoda.com/adakoda/2011/08/android-38.html

                // 透過（まだ試していない）
                // https://stackoverflow.com/questions/6796139/fade-in-fade-out-android-animation-in-java

                //Tweenアニメーションの適用
                ImageView img = (ImageView) findViewById(R.id.imgAnime1);

                //Animation animation= AnimationUtils.loadAnimation(this,R.anim.motion);
                img.startAnimation(animation);

                // スリープ
                // https://sites.google.com/site/technoute/android/java/sleep
                try {
                    Thread.sleep(1500); //1.5秒Sleepする
                } catch (InterruptedException e) {
                }

                img.startAnimation(animation2);

            }
        });

    }
}
