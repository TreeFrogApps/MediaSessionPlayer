package com.treefrogapps.mediasessionplayer.MusicPlayer.MusicService.AudioFocus;

import android.content.Context;
import android.media.AudioManager;

/**
 * Audio Focus Change Class - handle changes to Audio Focus
 */
public class AudioFocusChange implements AudioManager.OnAudioFocusChangeListener {

    private IAudioFocusCallback mIAudioFocusCallback;
    private AudioManager mAudioManager;

    public AudioFocusChange(Context context, IAudioFocusCallback iAudioFocusCallback){

        this.mIAudioFocusCallback = iAudioFocusCallback;
        this.mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public boolean requestAudioFocus(){
        return AudioManager.AUDIOFOCUS_REQUEST_GRANTED == mAudioManager.requestAudioFocus(this,
                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
    }

    public boolean abandonAudioFocus(){
        return AudioManager.AUDIOFOCUS_REQUEST_GRANTED == mAudioManager.abandonAudioFocus(this);
    }



    @Override
    public void onAudioFocusChange(int focusChange) {

        switch (focusChange){

            case AudioManager.AUDIOFOCUS_GAIN: // 1
                mIAudioFocusCallback.onFocusGain();
                break;

            case AudioManager.AUDIOFOCUS_LOSS: // -1
                mIAudioFocusCallback.onFocusLost();
                break;

            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT: //  -2
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK: // -3
                mIAudioFocusCallback.onFocusLostCanDuck();
                break;

            case AudioManager.AUDIOFOCUS_REQUEST_FAILED: // 0
                mIAudioFocusCallback.onFocusFailed();
                break;

            default: break;
        }

    }
}
