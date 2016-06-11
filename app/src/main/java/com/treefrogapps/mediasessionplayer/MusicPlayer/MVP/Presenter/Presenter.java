package com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.Presenter;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.util.Log;

import com.treefrogapps.mediasessionplayer.Common.Classes.GenericPresenter;
import com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.MVP;
import com.treefrogapps.mediasessionplayer.MusicPlayer.MVP.Model.Model;

import java.lang.ref.WeakReference;

/**
 * Concrete Implementation of the Presenter
 */
public class Presenter extends GenericPresenter<MVP.IPresenter, MVP.IModel, Model>
        implements MVP.IPresenter, MVP.IPresenterView {

    private static final String TAG = Presenter.class.getSimpleName();

    private WeakReference<MVP.IView> mIView;

    @Override
    public void onCreate(MVP.IView iView) {
        Log.d(TAG, "onCreate Called");
        this.mIView = new WeakReference<>(iView);
        super.onCreate(this, Model.class);
    }

    @Override
    public void onConfigChange(MVP.IView iView) {
        Log.d(TAG, "onConfiguration Called");
        this.mIView = new WeakReference<>(iView);
    }

    @Override
    public void onDestroy(boolean isShuttingDown) {
        Log.d(TAG, "onDestroy Called");

    }



    @Override
    public void doStuff(String somethingToDo) {

    }

    @Override
    public void showStuff(String stuff) {

    }



    /**
     * Contexts
     */
    @Override
    public Context getActivityContext() {
        return mIView.get().getActivityContext();
    }

    @Override
    public Context getAppContext() {
        return mIView.get().getAppContext();
    }

    @Override
    public LoaderManager getLoader() {
        return mIView.get().getLoader();
    }
}
