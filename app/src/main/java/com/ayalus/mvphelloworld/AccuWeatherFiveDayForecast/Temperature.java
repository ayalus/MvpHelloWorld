package com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Temperature{

	@SerializedName("Minimum")
	private Minimum minimum;

	@SerializedName("Maximum")
	private Maximum maximum;

	public void setMinimum(Minimum minimum){
		this.minimum = minimum;
	}

	public Minimum getMinimum(){
		return minimum;
	}

	public void setMaximum(Maximum maximum){
		this.maximum = maximum;
	}

	public Maximum getMaximum(){
		return maximum;
	}

	@Override
 	public String toString(){
		return 
			"Temperature{" + 
			"minimum = '" + minimum + '\'' + 
			",maximum = '" + maximum + '\'' + 
			"}";
		}
}