package com.treefrogapps.mediasessionplayer.Common.Classes;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.treefrogapps.mediasessionplayer.Common.Interfaces.IContextView;
import com.treefrogapps.mediasessionplayer.Common.Interfaces.IPresenterLifecycleMethods;

/**
 * Generic Activity Class - initialises a new Retained Fragment Manager for Each Activity
 */
public abstract class GenericActivity<IView, IPresenterView,
        Presenter extends IPresenterLifecycleMethods<IView>>
        extends AppCompatActivity implements IContextView {

    public static final String TAG = GenericActivity.class.getSimpleName();

    private RetainedFragmentManager mRetainedManager =
            new RetainedFragmentManager(getSupportFragmentManager());

    private Presenter mPresenter;


    public void onCreate(IView iView, Class<Presenter> presenterClass){


        if(mRetainedManager.firstLaunch()){
            try {
                createPresenter(iView, presenterClass);
            } catch (IllegalAccessException e) {
                Log.d(TAG, "Access Exception - " + e);
            } catch (InstantiationException e) {
                Log.d(TAG, "Instantiation Exception - " + e);
            }
        } else {
            retrievePresenter(iView);
        }
    }


    public void createPresenter(IView iView, Class<Presenter> presenterClass)
            throws IllegalAccessException, InstantiationException {

        mPresenter = presenterClass.newInstance();
        mRetainedManager.putObject(RetainedFragmentManager.RETAINED_TAG, mPresenter);
        mPresenter.onCreate(iView);
    }

    public void retrievePresenter(IView iView){

        mPresenter = mRetainedManager.getObject(RetainedFragmentManager.RETAINED_TAG);
        mPresenter.onConfigChange(iView);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public LoaderManager getLoader() {
        return getSupportLoaderManager();
    }


    @SuppressWarnings("unchecked")
    public IPresenterView getPresenter(){
        return (IPresenterView) mPresenter;
    }
}
