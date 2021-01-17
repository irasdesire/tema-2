package com.company;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

public class Observation {
    private String CityName;
    private String CountryCode;
    private String Weather;
    private String DetailedWeather;
    private float Temperature;
    private float FeelsLike;
    private float Humidity;
    private float WindSpeed;

    Observation(String query){
        JsonArray items = Json.parse(query).asObject().get("weather").asArray();
        for (JsonValue item : items) {
            Weather = item.asObject().getString("main", "Unknown");
            DetailedWeather = item.asObject().getString("description", "Unknown");
        }

        JsonObject wind = Json.parse(query).asObject().get("wind").asObject();
        WindSpeed= wind.getFloat("speed", 0);


        JsonObject country = Json.parse(query).asObject().get("sys").asObject();
        CountryCode = country.getString("country", "");

        CityName = Json.parse(query).asObject().get("name").toString();

        JsonObject temp = Json.parse(query).asObject().get("main").asObject();
        Temperature = temp.asObject().getFloat("temp", 0);
        FeelsLike = temp.asObject().getFloat("feels_like", 0);
        Humidity = temp.asObject().getFloat("humidity", 0);
        }

    public String getDetailedWeather() {
        return DetailedWeather;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public float getFeelsLike() {
        return FeelsLike;
    }

    public float getHumidity() {
        return Humidity;
    }

    public float getTemperature() {
        return Temperature;
    }

    public float getWindSpeed() {
        return WindSpeed;
    }

    public String getCityName() {
        return CityName;
    }

    public String getWeather() {
        return Weather;
    }

    public void PrintInteresting(){
        System.out.printf("City: %s\nCountry code: %s\n, Weather: %s, %s\n Temperature: %s\n,  Feels like: %s \n," +
                " Humidity: %s \n, Wind speed: %s\n,",getCityName(), getCountryCode(), getWeather(),
                getDetailedWeather(), getTemperature() - 273.15, getFeelsLike() - 273.15, getHumidity(), getWindSpeed());
    }
}

