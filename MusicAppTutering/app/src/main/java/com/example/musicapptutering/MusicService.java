package com.example.musicapptutering;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private static final String TAG = MusicService.class.getSimpleName();
    private MediaPlayer mMediaPlayer;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
        mMediaPlayer = MediaPlayer.create(this,R.raw.sample);
        if(mMediaPlayer != null){
            mMediaPlayer.setLooping(true);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mMediaPlayer != null){
            Log.d(TAG,"onStartCommand-music start");
            mMediaPlayer.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy"); //Destroy에서는 안쪽에 로그를 출력
        if(mMediaPlayer != null){
            Log.d(TAG,"onDestroy = Music Stop");
            mMediaPlayer.stop();
        }
        super.onDestroy();
    }
}

