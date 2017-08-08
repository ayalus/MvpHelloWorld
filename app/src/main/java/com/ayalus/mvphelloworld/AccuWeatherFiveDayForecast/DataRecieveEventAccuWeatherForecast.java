package com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast;

/**
 * Created by Ayalus on 8/7/17.
 */

public class DataRecieveEventAccuWeatherForecast {

    private AccuWeatherForecastResponseObj forecastResponseObj ;

    private String mError;

    public DataRecieveEventAccuWeatherForecast(String error) {
        mError = error;
    }

    public DataRecieveEventAccuWeatherForecast(AccuWeatherForecastResponseObj response) throws ClassCastException{
        forecastResponseObj = response;
    }

    public AccuWeatherForecastResponseObj getmOpenWeatherMapApiResponse(){
        return forecastResponseObj;
    }

    public String getError() {
        return mError;
    }
}
