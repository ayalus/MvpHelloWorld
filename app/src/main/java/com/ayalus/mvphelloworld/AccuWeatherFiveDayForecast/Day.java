package com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Day{

	@SerializedName("IconPhrase")
	private String iconPhrase;

	@SerializedName("Icon")
	private int icon;

	public void setIconPhrase(String iconPhrase){
		this.iconPhrase = iconPhrase;
	}

	public String getIconPhrase(){
		return iconPhrase;
	}

	public void setIcon(int icon){
		this.icon = icon;
	}

	public int getIcon(){
		return icon;
	}

	@Override
 	public String toString(){
		return 
			"Day{" + 
			"iconPhrase = '" + iconPhrase + '\'' + 
			",icon = '" + icon + '\'' + 
			"}";
		}
}