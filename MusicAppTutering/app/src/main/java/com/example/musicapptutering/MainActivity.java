package com.example.musicapptutering;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    
    Button mBtnStart;
    Button mBtnStop;
    LottieAnimationView mLottieAnim;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        Log.d(TAG,"onCreate");
        mBtnStart = findViewById(R.id.btn_start);
        mBtnStop = findViewById(R.id.btn_finish);
        
        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
        mLottieAnim = findViewById(R.id.lottie_anim);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_start) {
            Log.d(TAG, "onClick - btn_start");
            startMusicService();
            if (mLottieAnim != null) {
                mLottieAnim.playAnimation();
            }
        } else if (id == R.id.btn_finish) {
            Log.d(TAG, "onClick - btn_stop");
            stopMusicService();
            if (mLottieAnim != null) {
                mLottieAnim.pauseAnimation();
            }
        }
    }

    private void startMusicService(){
        Intent intent = new Intent(this,MusicService.class);
        startService(intent);
    }
    private void stopMusicService(){
        Intent intent = new Intent(this,MusicService.class);
        stopService(intent);
    }
}