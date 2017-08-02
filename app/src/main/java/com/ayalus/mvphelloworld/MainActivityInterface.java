package com.ayalus.mvphelloworld;

import android.widget.RelativeLayout;

import org.json.JSONException;

/**
 * Created by Ayalus on 7/26/17.
 */

//important for MVP
interface MainActivityInterface {

     interface Presenter {
        void logString(String stringToLog) throws JSONException;
        void changeBackgroundColor(RelativeLayout layout,int color);
    }

     interface View {
        void showToast(String stringToast);
        void buttonOnePressed();
        void buttonTwoPressed();
    }
}
