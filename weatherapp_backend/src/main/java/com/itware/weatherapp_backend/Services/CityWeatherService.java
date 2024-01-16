package com.itware.weatherapp_backend.Services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itware.weatherapp_backend.Entities.CityWeather;
import com.itware.weatherapp_backend.Repositories.CityWeatherRepository;


@Service
public class CityWeatherService {
  
  private final CityWeatherRepository cityWeatherRepository;
  private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
  private static final String API_KEY = "2b986aead4d3682a2eb8b8f8359831a7";

  public CityWeatherService(CityWeatherRepository cityWeatherRepository) {
    this.cityWeatherRepository = cityWeatherRepository;
  }

  public CityWeather create(CityWeather cityWeather) {
    String encodedCityName = encodeCityName(cityWeather.getCityname());
    String url = buildApiUrl(encodedCityName);
    try{
      JsonNode jsonObject = getJsonObjectFromApi(url);
      double kelvinTemperature = jsonObject.get("main").get("temp").asDouble();
      cityWeather.setCityname(cityWeather.getCityname().toUpperCase());
      cityWeather.setTemperature(kelvinToCelsius(kelvinTemperature));
      cityWeather.setTime(new Timestamp(new Date().getTime()));
      return cityWeatherRepository.save(cityWeather);
    }catch(Exception error){
      throw new RuntimeException("Error creating city weather: " + error.getMessage(), error);
    }  
  }

  public void update(CityWeather cityWeather) {
    cityWeatherRepository.save(cityWeather);  
  }

  public void remove(CityWeather cityWeather) {
    cityWeatherRepository.delete(cityWeather);
  }

  public CityWeather findById(Integer id) {
    return cityWeatherRepository.findById(id).orElse(null);
  }

  public List<CityWeather> findAll() {
    List<CityWeather> cityweathers = cityWeatherRepository.findAll();
    Collections.reverse(cityweathers);
    return cityweathers;
  }
  
  private String encodeCityName(String cityName) {
    try {
      return URLEncoder.encode(cityName, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException error) {
      throw new RuntimeException("Error encoding city name: " + error.getMessage(), error);
    }
  }

  private JsonNode getJsonObjectFromApi(String url) {
    try {
      RestTemplate restTemplate = new RestTemplate();
      String result = restTemplate.getForObject(url, String.class);
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readTree(result);
    } catch (Exception error){
      throw new RuntimeException("Error getting json object from api: " + error.getMessage(), error);
    }
  }

  private double kelvinToCelsius(double temperature) {
    double celsius = temperature - 273.15;
    return (double) Math.round(celsius);
  }

  private String buildApiUrl(String encodedCityName) {
    return API_URL + "?q=" + encodedCityName + "&appid=" + API_KEY;
  }
}
