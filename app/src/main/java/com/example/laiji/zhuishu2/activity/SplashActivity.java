package com.example.laiji.zhuishu2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.laiji.zhuishu2.R;
import com.example.laiji.zhuishu2.widget.SkipVIew;

public class SplashActivity extends AppCompatActivity {

    private SkipVIew mSkipVIew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSkipVIew = (SkipVIew) findViewById(R.id.skipview);
        mSkipVIew.setOnSkipListener(new SkipVIew.OnSkipListener() {
            @Override
            public void onSkip() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mSkipVIew.start();
    }
}
