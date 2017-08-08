package com.ayalus.mvphelloworld;

import android.util.Log;
import android.widget.RelativeLayout;

import com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.AccuWeatherForecastResponseObj;
import com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.AccuWeatherServerApi;
import com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.Constants;
import com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.DataRecieveEventAccuWeatherForecast;
import com.ayalus.mvphelloworld.bus.BusProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Subscribe;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;
import static com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.Constants.API_KEY;
import static com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.Constants.BROOKLYN_LOCATION_CODE;
import static com.ayalus.mvphelloworld.JsonModel.jsonString;

/**
 * Created by Ayalus on 7/26/17.
 */

public class MainActivityPresenter implements MainActivityInterface.Presenter{

    private MainActivityInterface.View mView;
    int colorVar = 300;

    //for AccuWetherAPI call
    private AccuWeatherForecastResponseObj forecastObject;
    private AccuWeatherServerApi AccuWeatherServerApi; //get weather info
    private Gson mGson;



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
        mGson = new GsonBuilder()
                .setDateFormat(Constants.TIME_FORMAT)
                .create();

        try {
            BusProvider.getInstance().register(this);
        }
        catch (RuntimeException e){
            Log.v(TAG, "RuntimeException: " + e.toString());
        }

        AccuWeatherServerApi = new AccuWeatherServerApi(API_KEY, GsonConverterFactory.create(mGson));

        AccuWeatherServerApi.getQueryDataCurrent(BROOKLYN_LOCATION_CODE);
    }

    //    ON-DATA-RECEIVED: AccuWeather 5 day forecast
    @Subscribe
    public void onDataReceived(DataRecieveEventAccuWeatherForecast eventForecastWeatherReceived){
        Log.v(TAG, "onDataReceived CURRENT:::::::::::::");
        try{
            DataRecieveEventAccuWeatherForecast eventData = (DataRecieveEventAccuWeatherForecast)eventForecastWeatherReceived;
            Log.v(TAG, "eventForecastWeatherReceived------CURRENT::::::::::::: " + eventForecastWeatherReceived.getmOpenWeatherMapApiResponse().toString());

            forecastObject = eventData.getmOpenWeatherMapApiResponse();
            if(forecastObject != null) {
                Log.v(TAG, "ApiResponse: IS POPULATED...............DataRecieveEventAccuWeatherForecast");
//                mView.showToast(forecastObject.toString());
                mView.showWeatherInfo(forecastObject);
            }else {
                Log.v(TAG, "ApiResponse: IS EMPTY...............DataRecieveEventAccuWeatherForecast");
            }
        }
        catch (Exception e) {
            Log.e(TAG, "DataRecieveEventAccuWeatherForecast VLE Error2:  " + e.toString());
        }
    }
}
