package com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast;

import android.util.Log;

import com.ayalus.mvphelloworld.bus.BusProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ayalus on 8/7/17.
 */

public class AccuWeatherServerApi {

    private final String TAG = "AccuWeatherServerApi";

    private AccuWeatherInterface mInterface;
//    private Gson mGson;
//    private String locationKey = "";
    private String apiKey = "";


    public AccuWeatherServerApi(String apiKey, Converter.Factory converter){
        init(apiKey,converter);
    }

    public void init( String apiKey, Converter.Factory converter){
        this.apiKey = apiKey;
        Retrofit retrofit;

        if(converter != null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ACCUWEATHER_BASE_URL)
                    .addConverterFactory(converter)
                    .build();
        }
        else{
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ACCUWEATHER_BASE_URL)
                    .build();
        }
        mInterface = retrofit.create(AccuWeatherInterface.class);
    }




    public void getQueryDataCurrent(String locationKey) {
        Call<AccuWeatherForecastResponseObj> call = mInterface.getQueryFiveDayForecast(locationKey,apiKey);
        call.enqueue(new Callback<AccuWeatherForecastResponseObj>() {

            @Override
            public void onResponse(Call<AccuWeatherForecastResponseObj> call, Response<AccuWeatherForecastResponseObj> response) {
                if(Constants.DEBUG) {
                    if (response.body() != null) {
                        Log.d(TAG, "getData success--AccuWeather OBJ: " + response.body());
                    }else{
                        Log.d(TAG, "getData--AccuWeather OBJ: NULL");
                    }
                }
                BusProvider.getInstance().post(new DataRecieveEventAccuWeatherForecast(response.body()));
            }

            @Override
            public void onFailure(Call<AccuWeatherForecastResponseObj> call, Throwable error) {
                if(Constants.DEBUG)
                    Log.v(TAG, "getData failure--AccuWeather OBJ FAILED- ERROR: " + error.toString() );
                BusProvider.getInstance().post(new DataRecieveEventAccuWeatherForecast(error.toString()));
            }
        });
    }
}
