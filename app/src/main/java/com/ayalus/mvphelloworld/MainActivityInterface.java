package com.ayalus.mvphelloworld;

import android.widget.RelativeLayout;

import com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.AccuWeatherForecastResponseObj;

import org.json.JSONException;

/**
 * Created by Ayalus on 7/26/17.
 */

interface MainActivityInterface {

     interface Presenter {
        void onResume();
        void logString(String stringToLog) throws JSONException;
        void changeBackgroundColor(RelativeLayout layout,int color);
        void logStringJson();
        void getAccuWeather();
    }

     interface View {
        void showToast(String stringToast);
        void buttonPressed();
        void buttonTwoPressed();
        void showWeatherInfo(AccuWeatherForecastResponseObj weatherObject);
    }
}
