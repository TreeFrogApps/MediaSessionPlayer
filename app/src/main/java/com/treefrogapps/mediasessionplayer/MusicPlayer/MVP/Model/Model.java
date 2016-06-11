package com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.Model;

import android.util.Log;

import com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.MVP;

import java.lang.ref.WeakReference;

/**
 * Model Layer
 */
public class Model implements MVP.IModel {

    private static final String TAG = Model.class.getSimpleName();

    private WeakReference<MVP.IPresenter> mPresenter;

    @Override
    public void onCreate(MVP.IPresenter iPresenter) {

        Log.d(TAG, "onCreate Called");
        mPresenter = new WeakReference<>(iPresenter);
    }

    @Override
    public void onDestroy() {

    }



    @Override
    public void doSomeBackEndStuff(String someStuff) {

    }
}
