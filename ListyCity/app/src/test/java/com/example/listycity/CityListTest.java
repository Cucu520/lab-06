package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    /** Helper method to create a mock city object. */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /** Helper method to create a mock CityList with one city added. */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }


    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City dup = mockCity();
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(dup);
        });
    }


    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        assertFalse(cityList.hasCity(new City("Calgary", "Alberta")));
    }


    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City toRemove = mockCity();
        assertTrue(cityList.hasCity(toRemove));
        cityList.delete(toRemove);
        assertFalse(cityList.hasCity(toRemove));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City notInList = new City("Vancouver", "British Columbia");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(notInList);
        });
    }


    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
    }


    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.add(charlottetown);
        // After sorting alphabetically, Charlottetown should come before Edmonton
        assertEquals(0, charlottetown.compareTo(cityList.getCities().get(0)));
        assertEquals(2, cityList.getCities().size());
    }
}
