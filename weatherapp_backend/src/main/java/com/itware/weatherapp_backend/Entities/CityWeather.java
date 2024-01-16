package com.itware.weatherapp_backend.Entities;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cityweather")
public class CityWeather implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "cityname", nullable = false)
  private String cityname;

  @Column(name = "temperature")
  private Double temperature;

  @Column(name = "time")
  private Timestamp time;

  @Override
  public String toString() {
    return "Cityweather{" +
            "id=" + id +
            ", cityname='" + cityname + '\'' +
            ", temperature=" + temperature +
            ", time=" + time +
            '}';
  }
}
