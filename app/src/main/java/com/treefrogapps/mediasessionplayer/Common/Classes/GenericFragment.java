package com.treefrogapps.mediasessionplayer.Common.Classes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Generic Fragment class
 */
public abstract class GenericFragment<IFragmentListener> extends Fragment {

    private View mRootView;
    private IFragmentListener mIFragmentListener;


    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof GenericActivity){
            mIFragmentListener = (IFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " Must Implement a FragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutView(), container, false);
        return mRootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if(mIFragmentListener != null){
            mIFragmentListener = null;
        }
    }



    public abstract int getLayoutView();

    public View getRootView(){
        return mRootView;
    }

    public IFragmentListener getIFragmentListener(){
        return mIFragmentListener;
    }



}
