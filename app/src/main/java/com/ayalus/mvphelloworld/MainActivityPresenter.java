package com.ayalus.mvphelloworld;

import android.util.Log;
import android.widget.RelativeLayout;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;
import static com.ayalus.mvphelloworld.JsonModel.jsonString;

/**
 * Created by Ayalus on 7/26/17.
 */

public class MainActivityPresenter implements MainActivityInterface.Presenter{

    private MainActivityInterface.View mView;
    int colorVar = 300;



    public MainActivityPresenter(MainActivityInterface.View loginView) {
        this.mView = loginView;
    }


    @Override
    public void onResume() {
        Log.v(TAG, "onResume() CALLED...");
    }

    @Override
    public void logString(String stringToLog) {
        mView.showToast("test showToast button pressed: ");
        Log.v(TAG, "String to be logged out is: "+stringToLog);
    }


    @Override
    public void logStringJson() {
        JSONObject mainObject;
        try {
            mainObject = new JSONObject(jsonString);
            String  ip_address = mainObject.getString("ip");
            String  country_code = mainObject.getString("country_code");
            String  country_name = mainObject.getString("country_name");
            String  region_name = mainObject.getString("region_name");
            String  city = mainObject.getString("city");
            String  zip_code = mainObject.getString("zip_code");
            String  time_zone = mainObject.getString("time_zone");
            String  latitude = mainObject.getString("latitude");
            String  longitude = mainObject.getString("longitude");
            String  metro_code = mainObject.getString("metro_code");
            Log.v(TAG,"ip_address:"+ip_address+"|\n"+"country_code:"+country_code+"|\n"+"country_name:"+country_name+"|\n"+"region_name:"+region_name+"|\n"
                    +"city:"+city+"|\n"+"zip_code:"+zip_code+"|\n"+"time_zone:"+time_zone+"|\n"+"latitude:"+latitude+"|\n"+"longitude:"+longitude+"|\n"+"metro_code:"+metro_code+"|"
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void changeBackgroundColor(RelativeLayout layout,int color) {
        colorVar -= 5000;
        color += colorVar;
        Log.v(TAG, "color+colorVar: "+color);
        layout.setBackgroundColor(color);
    }

    @Override
    public void getAccuWeather() {
        Log.v(TAG, "getAccuWeather() called in Presentor");

    }
}
