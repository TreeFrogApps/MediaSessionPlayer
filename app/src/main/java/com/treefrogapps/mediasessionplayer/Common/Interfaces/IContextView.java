package com.treefrogapps.mediasessionplayer.Common.Interfaces;

import android.content.Context;
import android.support.v4.app.LoaderManager;


public interface IContextView {

    Context getActivityContext();

    Context getAppContext();

    LoaderManager getLoader();

}
