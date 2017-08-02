package com.ayalus.mvphelloworld;

import android.util.Log;
import android.widget.RelativeLayout;

import static android.content.ContentValues.TAG;

/**
 * Created by Ayalus on 7/26/17.
 */

//important for MVP
public class MainActivityPresenter implements MainActivityInterface.Presenter{

    private MainActivityInterface.View mView;
    private int colorVar = 300;

    public MainActivityPresenter(MainActivityInterface.View loginView) {
        this.mView = loginView;
    }

    @Override
    public void logString(String stringToLog) {
        mView.showToast("test showToast button pressed: ");
        Log.v(TAG, "String to be logged out is: "+stringToLog);
    }

    @Override
    public void changeBackgroundColor(RelativeLayout layout,int color) {
        colorVar -= 5000;
        color += colorVar;
        Log.v(TAG, "color+colorVar: "+color);
        layout.setBackgroundColor(color);
    }
}
