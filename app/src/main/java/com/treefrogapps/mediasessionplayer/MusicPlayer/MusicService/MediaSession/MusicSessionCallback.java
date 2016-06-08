package com.treefrogapps.mediasessionplayer.MusicPlayer.MusicService.MediaSession;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;

/**
 * Media Session Callback
 */
public class MusicSessionCallback extends MediaSessionCompat.Callback {


    @Override
    public boolean onMediaButtonEvent(Intent mediaButtonEvent) {

        // TODO = Handle media button events - pass to receiver
        return true;
    }
}
