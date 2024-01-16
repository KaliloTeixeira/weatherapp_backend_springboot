package com.itware.weatherapp_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itware.weatherapp_backend.Entities.CityWeather;

public interface CityWeatherRepository extends JpaRepository<CityWeather, Integer> {
  
}
