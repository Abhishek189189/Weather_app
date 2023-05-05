package com.weather.one.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.one.controller.Weather_Data2;
import com.weather.one.controller.file_db_mongo_2;
import com.fasterxml.jackson.databind.ObjectMapper;
@Repository
public class Get_data {
	
	@Autowired 
	file_db_mongo_2 fd;
	
	
	public String getData_ahd() {
		List<Weather_Data2> data = fd.findBynameRegex("Ahmedabad");
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Error processing data";
		}
	}
	
	public String getData_sur() {
		List<Weather_Data2> data = fd.findBynameRegex("Surat");
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Error processing data";
		}
	}
	
	public String getData_dwa() {
		List<Weather_Data2> data = fd.findBynameRegex("Dwarka");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Error processing data";
		}
	}
	
	
			


}
