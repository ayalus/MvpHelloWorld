package com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ayalus on 8/4/17.
 */

public interface AccuWeatherInterface {

  //AccuWeather 5 day forecast full URL  http://dataservice.accuweather.com/forecasts/v1/daily/5day/334651?apikey=COUjidt71pZkQYiLoeuHNAKwL8eJpLgA

  //from Documentation: http://dataservice.accuweather.com/forecasts/v1/daily/5day/{locationKey}

    @GET("{locationKey}")
    Call<AccuWeatherForecastResponseObj> getQueryFiveDayForecast(@Path("locationKey") String locationKey, @Query("apikey") String apiKey);



    //FULL URL: http://api.openweathermap.org/data/2.5/weather?APPID=48ff6173f05da5be3affe88b0d21e373&lat=40.7143&lon=-74.006
//    @GET(Constants.DAILY_WEATHER)
//    Call<VOpenWeatherMapObj> getQueryCurrent(@Query(Constants.OPENWEATHERMAP_APPID) String appId, @Query(Constants.LAT) String lat, @Query(Constants.LON) String lon);
}
