package com.treefrogapps.mediasessionplayer.MusicPlayer.MusicService.AudioFocus;

/**
 * Callback interface for AudioFocusChange - implemented by MusicService
 */
public interface IAudioFocusCallback {

    void onFocusGain();

    void onFocusLostCanDuck();

    void onFocusLost();

    void onFocusFailed();
}
