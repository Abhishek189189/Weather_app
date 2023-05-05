import { Component, OnInit } from '@angular/core';
import { WeatherService } from './services/weather.service';
import { WeatherData } from 'src/models/weather.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {



  constructor(private http: HttpClient) {

  }
  // weatherData?: WeatherData;
  ngOnInit(): void {
    // Call the function once on initialization
    this.getdata_ahd();

    this.getdata_sur();
    this.getdata_dwa();
    this.show_data_ahd();
    this.show_data_sur();
    this.show_data_dwa();
    // Call the function every 2 hours using setInterval
    // setInterval(() => {
    //   this.getdata_ahd();
    //   this.getdata_sur();
    //   this.getdata_dwa();
    // }, 2 * 60 * 60 * 1000);

    // setInterval(() => {
    //   this.getdata();
    // }, 2 );// 2 hours * 60 minutes/hour * 60 seconds/minute * 1000 milliseconds/second
  }
  title = 'weatherapi';

  //for ahmedabad
  cityname = undefined
  currentTemperature = undefined
  minimumTemperature = undefined
  maximumTemperature = undefined
  windSpeed = undefined
  humidityLevel = undefined
  region = undefined
  country = undefined
  localtime = undefined
  lastUpdated = undefined
  weatherData_ahd: any[] = [];


  //for surat
  cityname2 = undefined
  currentTemperature2 = undefined
  minimumTemperature2 = undefined
  maximumTemperature2 = undefined
  windSpeed2 = undefined
  humidityLevel2 = undefined
  region2 = undefined
  country2 = undefined
  localtime2 = undefined
  lastUpdated2 = undefined
  weatherData_sur: any[] = [];

  //for dhwarka
  cityname3 = undefined
  currentTemperature3 = undefined
  minimumTemperature3 = undefined
  maximumTemperature3 = undefined
  windSpeed3 = undefined
  humidityLevel3 = undefined
  region3 = undefined
  country3 = undefined
  localtime3 = undefined
  lastUpdated3 = undefined
  weatherData_dwa: any[] = [];





  getdata_ahd() {
    this.http.get<any>('http://localhost:8080/api/weather/ahmedabad').subscribe(data => {
      const {
        location: { name, region, country, localtime },
        current: { last_updated, temp_c: temperature, humidity, wind_kph }
      } = data;
      console.log(name, region, country, localtime, last_updated, temperature, humidity);

      // Use the extracted variables here
      this.cityname = name;
      this.region = region;
      this.country = country;
      this.localtime = localtime;
      this.lastUpdated = last_updated;
      this.currentTemperature = temperature;
      this.humidityLevel = humidity;
      this.windSpeed = wind_kph;


      console.log(this.cityname);
      console.log(this.region);
      console.log(this.country);
      console.log(this.localtime);
      console.log(this.lastUpdated);
      console.log(this.currentTemperature);
      console.log(this.humidityLevel);
      console.log(this.windSpeed);


      // and so on
    });
  }


  getdata_sur() {
    this.http.get<any>('http://localhost:8080/api/weather/Surat').subscribe(data => {
      const {
        location: { name, region, country, localtime },
        current: { last_updated, temp_c: temperature, humidity, wind_kph }
      } = data;
      console.log(name, region, country, localtime, last_updated, temperature, humidity);

      // Use the extracted variables here
      this.cityname2 = name;
      this.region2 = region;
      this.country2 = country;
      this.localtime2 = localtime;
      this.lastUpdated2 = last_updated;
      this.currentTemperature2 = temperature;
      this.humidityLevel2 = humidity;
      this.windSpeed2 = wind_kph;


      console.log(this.cityname2);
      console.log(this.region2);
      console.log(this.country2);
      console.log(this.localtime2);
      console.log(this.lastUpdated2);
      console.log(this.currentTemperature2);
      console.log(this.humidityLevel2);
      console.log(this.windSpeed2);


      // and so on
    });
  }

  getdata_dwa() {
    this.http.get<any>('http://localhost:8080/api/weather/Dwarka').subscribe(data => {
      const {
        location: { name, region, country, localtime },
        current: { last_updated, temp_c: temperature, humidity, wind_kph }
      } = data;
      console.log(name, region, country, localtime, last_updated, temperature, humidity);

      // Use the extracted variables here
      this.cityname3 = name;
      this.region3 = region;
      this.country3 = country;
      this.localtime3 = localtime;
      this.lastUpdated3 = last_updated;
      this.currentTemperature3 = temperature;
      this.humidityLevel3 = humidity;
      this.windSpeed3 = wind_kph;


      console.log(this.cityname3);
      console.log(this.region3);
      console.log(this.country3);
      console.log(this.localtime3);
      console.log(this.lastUpdated3);
      console.log(this.currentTemperature3);
      console.log(this.humidityLevel3);
      console.log(this.windSpeed3);


      // and so on
    });
  }

  show_data_ahd() {
    this.http.get<any>('http://localhost:8080/api/getdata/ahmedabad').subscribe(data => {
      const weatherData = [];
      console.log("show_data_ahd")
      if (Array.isArray(data) && data.length > 0) {
        for (const weather of data) {
          const {
            localtime,
            lastupdated,
            temperature,
            humidity,
            wind_kph
          } = weather;

          weatherData.push({
            localtime,
            last_updated: lastupdated,
            temperature,
            humidity,
            wind_kph
          });
        }

        this.weatherData_ahd = weatherData;
        console.log("api", this.weatherData_ahd);
      } else {
        console.error("Invalid data format:", data);
      }
    });
  }












  show_data_sur() {
    this.http.get<any>('http://localhost:8080/api/getdata/Surat').subscribe(data => {
      const weatherData = [];
      console.log("show_data_sur")
      if (Array.isArray(data) && data.length > 0) {
        for (const weather of data) {
          const {
            localtime,
            lastupdated,
            temperature,
            humidity,
            wind_kph
          } = weather;

          weatherData.push({
            localtime,
            last_updated: lastupdated,
            temperature,
            humidity,
            wind_kph
          });
        }

        this.weatherData_sur = weatherData;
        console.log("api", this.weatherData_ahd);
      } else {
        console.error("Invalid data format:", data);
      }
    });
  }


  show_data_dwa() {
    this.http.get<any>('http://localhost:8080/api/getdata/Dwarka').subscribe(data => {
      const weatherData = [];
      console.log("show_data_dwa")
      if (Array.isArray(data) && data.length > 0) {
        for (const weather of data) {
          const {
            localtime,
            lastupdated,
            temperature,
            humidity,
            wind_kph
          } = weather;

          weatherData.push({
            localtime,
            last_updated: lastupdated,
            temperature,
            humidity,
            wind_kph
          });
        }

        this.weatherData_dwa = weatherData;
        console.log("api", this.weatherData_dwa);
      } else {
        console.error("Invalid data format:", data);
      }
    });
  }


}

