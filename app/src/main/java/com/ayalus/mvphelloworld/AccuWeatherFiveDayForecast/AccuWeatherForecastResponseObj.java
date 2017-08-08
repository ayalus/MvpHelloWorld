package com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AccuWeatherForecastResponseObj{

	@SerializedName("Headline")
	private Headline headline;

	@SerializedName("DailyForecasts")
	private List<DailyForecastsItem> dailyForecasts;

	public void setHeadline(Headline headline){
		this.headline = headline;
	}

	public Headline getHeadline(){
		return headline;
	}

	public void setDailyForecasts(List<DailyForecastsItem> dailyForecasts){
		this.dailyForecasts = dailyForecasts;
	}

	public List<DailyForecastsItem> getDailyForecasts(){
		return dailyForecasts;
	}

	@Override
 	public String toString(){
		return 
			"AccuWeatherForecastResponseObj{" + 
			"headline = '" + headline + '\'' + 
			",dailyForecasts = '" + dailyForecasts + '\'' + 
			"}";
		}
}