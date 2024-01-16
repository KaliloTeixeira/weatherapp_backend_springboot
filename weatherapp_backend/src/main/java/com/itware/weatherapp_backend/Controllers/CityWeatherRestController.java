package com.itware.weatherapp_backend.Controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itware.weatherapp_backend.Entities.CityWeather;
import com.itware.weatherapp_backend.Services.CityWeatherService;

@RestController
@CrossOrigin(origins = {"https://kaliloteixeira.github.io/", "http://localhost:4200/"}, maxAge = 3600)
@ResponseBody
@RequestMapping("/webresources/cityweather")
public class CityWeatherRestController {

  private final CityWeatherService cityWeatherService;
  private static final Logger LOGGER = Logger.getLogger(CityWeatherRestController.class.getName());


  public CityWeatherRestController(CityWeatherService cityWeatherService) {
    this.cityWeatherService = cityWeatherService;
  }

  @PostMapping("/")
  public ResponseEntity<String> createCityWeather(@RequestBody CityWeather cityWeather) {
    LOGGER.info("createCityWeather() - cityName - " + cityWeather.getCityname());
    try{
      this.cityWeatherService.create(cityWeather);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }catch(Exception error){
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCityWeather(@PathVariable Integer id, @RequestBody CityWeather cityWeather) {
    LOGGER.info("updateCityWeather() - cityName - " + cityWeather.getCityname());
    try{
      this.cityWeatherService.update(cityWeather);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }catch(Exception error){
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> removeCityWeather(@PathVariable Integer id) {
    LOGGER.info("removeCityWeather() - id: " + id);
    try{
      CityWeather cityWeather = this.cityWeatherService.findById(id);
      this.cityWeatherService.remove(cityWeather);
      return ResponseEntity.status(HttpStatus.OK).build();
    }catch(Exception error){
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("error removing cityweather - " + error.getMessage());
    }
  }

  @GetMapping("/all")
  public List<CityWeather> getAllCityWeather() {
    LOGGER.info("getAllCityWeather()");
    return this.cityWeatherService.findAll();
  }

}
