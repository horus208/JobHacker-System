package services;

import entities.City;
import entities.Country;

import java.util.*;
import java.util.stream.Collectors;

public class AnalysisService {



    public Map<String, Optional<City>> mostPopulatedCityInCountry(List<City> cities)
    {
      return  cities .stream()
                .collect(
                        Collectors.groupingBy(
                                City::getCountryCode,
                                Collectors.maxBy(Comparator.comparing(City::getPopulation))
                        )
                );
    }
    public Map<String,Optional<City>> mostPopulatedCityInContinent(List<City> cities, List<Country> countries)
    {
        var countryContinentMap = countries.stream()
                .collect(Collectors.toMap(Country::getCode,Country::getContinent));



       return   cities
               .stream()
                .collect(
                        Collectors.groupingBy
                        (
                            city -> countryContinentMap.get(city.getCountryCode())== null ? "nan" :countryContinentMap.get(city.getCountryCode())
                            ,Collectors.maxBy(Comparator.comparing(City::getPopulation))
                        )
                );




    }

    public Optional<City> highestPopulatedCapital(List<City> cities, List<Country> countries)
    {
        var capitals = countries.stream().map(Country::getCapital).collect(Collectors.toSet());
        return cities.stream().filter(city ->capitals.contains(city.getId())).max(Comparator.comparing(City::getPopulation));

    }




}
