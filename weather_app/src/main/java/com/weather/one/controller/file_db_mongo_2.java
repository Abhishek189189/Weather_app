package com.weather.one.controller;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface file_db_mongo_2 extends MongoRepository<Weather_Data2, String> {

	List<Weather_Data2> findBynameRegex(String nameRegex);

}
