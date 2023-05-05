package com.weather.one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;


@Service
public class WeatherService {

	
    @Autowired
    private RestTemplate restTemplate;

    
    public String getWeatherData(String city) {
  	
       String url = "http://api.weatherapi.com/v1/current.json?key=f7b1d4e6ac4c42c597970642232704&q=" + city + "&aqi=no";     
       HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<>(headers);
       ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
       headers.set("Accept", "application/json");
   
        return response.getBody();
        
        
    	

    }
    
    public String getdata_ahd()
    {
        String ahd_url ="http://api.weatherapi.com/v1/current.json?key=f7b1d4e6ac4c42c597970642232704&q=ahmedabad";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response1 = restTemplate.exchange(ahd_url, HttpMethod.GET, entity, String.class);
        headers.set("Accept", "application/json");
		return response1.getBody();
    	
    }
    
    public String getdata_sur()
    {
        String sur_url ="http://api.weatherapi.com/v1/current.json?key=f7b1d4e6ac4c42c597970642232704&q=Surat";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response2 = restTemplate.exchange(sur_url, HttpMethod.GET, entity, String.class);
        headers.set("Accept", "application/json");
        
        return response2.getBody();
    }
    
    public String getdata_dwa()
    {
        String dwa_url ="http://api.weatherapi.com/v1/current.json?key=f7b1d4e6ac4c42c597970642232704&q=Dwarka";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response3 = restTemplate.exchange(dwa_url, HttpMethod.GET, entity, String.class);
        headers.set("Accept", "application/json");
        
        return response3.getBody();
    }
    
    
    

}

