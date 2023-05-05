package com.weather.one.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.weather.one.repo.Get_data;
import com.weather.one.service.WeatherService;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class MyController {
	
	    @Autowired
	    WeatherService weatherService;
	    
	 
	    
	    @Autowired
	    file_db_mongo_2 file_db_2;
	    
	    @Autowired
	    Get_data gt;
	    
	    @GetMapping("test")
	    public String test()
	    {
	    	return "Test Api";
	    }

	    @GetMapping("/weather/{city}")
	    public String getWeatherData(@PathVariable String city) 
	    {

	    	ObjectMapper mapper = new ObjectMapper();
	    	try {
	    		
	    		
	    	    JsonNode rootNode = mapper.readTree(weatherService.getWeatherData(city));
	    	    JsonNode locationNode = rootNode.get("location");
	    	    JsonNode current = rootNode.get("current");
	    	    double temperature = current.get("temp_c").asDouble();
	    	    double humidity = current.get("humidity").asDouble();
	    	    String name = locationNode.get("name").asText();
	    	    String region = locationNode.get("region").asText();
	    	    String country = locationNode.get("country").asText();
	    	    String localtime = locationNode.get("localtime").asText();
	    	    String lastUpdated = current.get("last_updated").asText();
	    	    double windspeed = current.get("wind_kph").asDouble();
	    	    Weather_Data2 dtx = new Weather_Data2(name, region, country, localtime, lastUpdated, temperature, humidity,windspeed);
//	    	    file_db_2.save(dtx);
	    	    
	    	    
	    	 
	    	} catch (JsonMappingException e) {
	    	    // TODO Auto-generated catch block
	    	    e.printStackTrace();
	    	} catch (JsonProcessingException e) {
	    	    // TODO Auto-generated catch block
	    	    e.printStackTrace();
	    	}

	    	System.out.println(weatherService.getWeatherData(city));
	    	return weatherService.getWeatherData(city);


	    }
	    
	    
	    
//	    @GetMapping("/weather/{city}")
	    public String storeWeatherData(@PathVariable String city) 
	    {

	    	ObjectMapper mapper = new ObjectMapper();
	    	try {
	    		
	    		
	    	    JsonNode rootNode = mapper.readTree(weatherService.getWeatherData(city));
	    	    JsonNode locationNode = rootNode.get("location");
	    	    JsonNode current = rootNode.get("current");
	    	    double temperature = current.get("temp_c").asDouble();
	    	    double humidity = current.get("humidity").asDouble();
	    	    String name = locationNode.get("name").asText();
	    	    String region = locationNode.get("region").asText();
	    	    String country = locationNode.get("country").asText();
	    	    String localtime = locationNode.get("localtime").asText();
	    	    String lastUpdated = current.get("last_updated").asText();
	    	    double windspeed = current.get("wind_kph").asDouble();
	    	    Weather_Data2 dtx = new Weather_Data2(name, region, country, localtime, lastUpdated, temperature, humidity,windspeed);
	    	    file_db_2.save(dtx);
	    	    
	    	    
	    	 
	    	} catch (JsonMappingException e) {
	    	    // TODO Auto-generated catch block
	    	    e.printStackTrace();
	    	} catch (JsonProcessingException e) {
	    	    // TODO Auto-generated catch block
	    	    e.printStackTrace();
	    	}

	    	System.out.println(weatherService.getWeatherData(city));
	    	return weatherService.getWeatherData(city);


	    }
	    
	    @GetMapping("/getdata/ahmedabad")
	    public String getData_ahd()
	    {
	    	return gt.getData_ahd();
	    }
	    
	    @GetMapping("/getdata/Surat")
	    public String getData_sur()
	    {
	    	return gt.getData_sur();
	    }
	    
	    @GetMapping("/getdata/Dwarka")
	    public String getData_dwa()
	    {
	    	return gt.getData_dwa();
	    }
	    
	    
	    
	    
	    
	    
	    
		@Scheduled(cron = "0 0 */2 * * *") 
		public void scheduleWeatherData() {
			String[] cities = {"ahmedabad", "Surat", "Dwarka"}; 
			for(String city : cities) {
				System.out.println("Api called per two hours by scheduler ");
				storeWeatherData(city); 
			}
		}
	    
	  
	    
	    
	    
	    
	    

}



