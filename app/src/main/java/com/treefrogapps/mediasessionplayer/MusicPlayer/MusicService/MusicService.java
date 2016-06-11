package com.treefrogapps.mediasessionplayer.MusicPlayer.MusicService;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

import com.treefrogapps.mediasessionplayer.MusicPlayer.MusicService.AudioFocus.IAudioFocusCallback;

/**
 * Main Music Service
 */

public class MusicService extends Service
        implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener,
        IAudioFocusCallback {

    private static final String TAG = MusicService.class.getSimpleName();

    private MediaSessionCompat mMediaSessionCompat;
    private PlaybackStateCompat mPlaybackStateCompat;
    private MediaPlayer mMediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate Called");

        initialiseMediaPlayer();
    }

    private void initialiseMediaPlayer() {

        if(mMediaPlayer == null) {

            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setOnCompletionListener(this);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return START_NOT_STICKY;
    }


    @Override
    public void onPrepared(MediaPlayer mp) {

    }


    @Override
    public void onCompletion(MediaPlayer mp) {

    }


    @Override
    public void onFocusGain() {

    }

    @Override
    public void onFocusLostCanDuck() {

    }

    @Override
    public void onFocusLost() {

    }

    @Override
    public void onFocusFailed() {

    }

}


