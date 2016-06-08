package com.treefrogapps.mediasessionplayer.Common.Classes;

import android.util.Log;

import com.treefrogapps.mediasessionplayer.Common.Interfaces.IModelLifeCycleMethods;

/**
 * Generic Presenter class
 */
public abstract class GenericPresenter<IPresenter, IModel,
        Model extends IModelLifeCycleMethods<IPresenter>> {

    private static final String TAG = GenericPresenter.class.getSimpleName();

    private Model mModel;

    public void onCreate(IPresenter iPresenter, Class<Model> model){

        try {
            mModel = model.newInstance();
            mModel.onCreate(iPresenter);
        }  catch (IllegalAccessException e) {
            Log.d(TAG, "Access Exception - " + e);
        } catch (InstantiationException e) {
            Log.d(TAG, "Instantiation Exception - " + e);
        }

    }

    @SuppressWarnings("unchecked")
    public IModel getModel(){
        return (IModel) mModel;
    }
}
