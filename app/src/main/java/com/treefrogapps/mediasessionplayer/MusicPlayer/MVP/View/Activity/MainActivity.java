package com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.View.Activity;

import android.os.Bundle;
import android.util.Log;

import com.treefrogapps.mediasessionplayer.Common.Classes.GenericActivity;
import com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.MVP;
import com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.Presenter.Presenter;
import com.treefrogapps.mediasessionplayer.R;

public class MainActivity extends GenericActivity<MVP.IView, MVP.IPresenterView, Presenter>
        implements MVP.IView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate Called");
        super.onCreate(this, Presenter.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(!isChangingConfigurations()){
            getPresenter().onDestroy(true);
        }
    }

    @Override
    public void onClick(String item) {

    }


}
