package com.weather.one.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection="weather_data_updated")
public class Weather_Data2 {
	
	public String name;
	public String region;
	public String country;
	public String localtime;
	public String lastupdated;
	public double temperature;
	public double humidity;
	public double wind_kph;
	public double getWind_kph() {
		return wind_kph;
	}
	public void setWind_kph(double wind_kph) {
		this.wind_kph = wind_kph;
	}
	public Weather_Data2(String name, String region, String country, String localtime, String lastupdated,
			double temperature, double humidity, double wind_kph) {
		super();
		this.name = name;
		this.region = region;
		this.country = country;
		this.localtime = localtime;
		this.lastupdated = lastupdated;
		this.temperature = temperature;
		this.humidity = humidity;
		this.wind_kph = wind_kph;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocaltime() {
		return localtime;
	}
	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}
	public String getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	
	
	public Weather_Data2() {
		super();
	}
	public Weather_Data2(String name, String region, String country, String localtime, String lastupdated,
			double temperature, double humidity) {
		this.name = name;
		this.region = region;
		this.country = country;
		this.localtime = localtime;
		this.lastupdated = lastupdated;
		this.temperature = temperature;
		this.humidity = humidity;
	}
	@Override
	public String toString() {
		return "Weather_Data2 [name=" + name + ", region=" + region + ", country=" + country + ", localtime="
				+ localtime + ", lastupdated=" + lastupdated + ", temperature=" + temperature + ", humidity=" + humidity
				+ ", wind_kph=" + wind_kph + "]";
	}
	
	
	
	

}
