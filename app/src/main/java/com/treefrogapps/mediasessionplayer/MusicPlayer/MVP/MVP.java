package com.treefrogapps.mediasessionplayer.MusicPlayer.MVP;

import com.treefrogapps.mediasessionplayer.Common.Interfaces.IContextView;
import com.treefrogapps.mediasessionplayer.Common.Interfaces.IModelLifeCycleMethods;
import com.treefrogapps.mediasessionplayer.Common.Interfaces.IPresenterLifecycleMethods;

/**
 * MVP Interfaces
 */
public interface MVP {

        interface IView extends IContextView {

            void onClick(String item);
        }


        interface IPresenterView extends IPresenterLifecycleMethods<MVP.IView> {

            void showStuff(String stuff);
        }


        interface IPresenter extends IContextView {

            void doStuff(String somethingToDo);
        }


        interface IModel extends IModelLifeCycleMethods<IPresenter>{


            void doSomeBackEndStuff(String someStuff);
        }


}
