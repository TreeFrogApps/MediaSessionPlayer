package com.treefrogapps.mediasessionplayer.Common.Interfaces;


public interface IPresenterLifecycleMethods<ViewInterface> {

    void onCreate(ViewInterface viewInterface);

    void onConfigChange(ViewInterface viewInterface);

    void onDestroy(boolean isShuttingDown);
}
