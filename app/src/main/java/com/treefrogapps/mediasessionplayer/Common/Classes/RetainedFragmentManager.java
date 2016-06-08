package com.treefrogapps.mediasessionplayer.Common.Classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Retained Fragment Manager
 */
public class RetainedFragmentManager {

    public static final String RETAINED_TAG = "RETAINED_FRAGMENT_TAG";

    private RetainedFragment mRetainedFragment;
    private WeakReference<FragmentManager> mFragmentManager;

    public RetainedFragmentManager(FragmentManager fragmentManager){
        this.mFragmentManager = new WeakReference<>(fragmentManager);
    }

    public boolean firstLaunch(){

        mRetainedFragment = (RetainedFragment) mFragmentManager.get().findFragmentByTag(RETAINED_TAG);

        if(mRetainedFragment == null){

            mRetainedFragment = new RetainedFragment();
            mFragmentManager.get().beginTransaction().add(mRetainedFragment, RETAINED_TAG).commit();
            return true;

        } else {
            return false;
        }
    }

    public void putObject(String key, Object value){
        mRetainedFragment.putObjeect(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(String key){
        return (T) mRetainedFragment.getObject(key);
    }

    public static class RetainedFragment extends Fragment {

        public HashMap<String, Object> mRetainedMap = new HashMap<>();

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setRetainInstance(true);
        }

        public void putObjeect(String key, Object value){
            mRetainedMap.put(key, value);
        }

        @SuppressWarnings("unchecked")
        public  <T> T  getObject(String key){
            return (T) mRetainedMap.get(key);
        }
    }
}
