package com.treefrogapps.mediasessionplayer.Common.Interfaces;

/**
 *  IFragment Listener class - for communicating back to hosting activity from fragment
 */
public interface IFragmentListener {


    void sendMessageFragmentToActivity(String message);
}
