package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CityList {
    private ArrayList<City> cities = new ArrayList<>();

    /** Add a new city to the list. Throws exception if city already exists. */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in list");
        }
        cities.add(city);
        Collections.sort(cities);
    }

    /** Delete a city from the list. Throws exception if city not found. */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in list");
        }
        cities.remove(city);
    }

    /** Check if a city exists in the list. */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /** Return total number of cities in the list. */
    public int countCities() {
        return cities.size();
    }

    /** Return a sorted list of cities. */
    public ArrayList<City> getCities() {
        ArrayList<City> sortedList = new ArrayList<>(cities);
        Collections.sort(sortedList, Comparator.naturalOrder());
        return sortedList;
    }
}
