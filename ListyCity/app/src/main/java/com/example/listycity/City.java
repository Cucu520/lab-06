package com.example.listycity;

public class City implements Comparable<City> {
    private String cityName;
    private String provinceName;

    public City(String cityName, String provinceName) {
        this.cityName = cityName;
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    @Override
    public int compareTo(City other) {
        return this.cityName.compareTo(other.cityName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return cityName.equals(city.cityName) &&
                provinceName.equals(city.provinceName);
    }

    @Override
    public int hashCode() {
        return cityName.hashCode() + provinceName.hashCode();
    }
}
