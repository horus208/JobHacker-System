package mappers;

import entities.City;

import java.util.List;

public class CityMapper implements Mapper<City>{
    @Override
    public City map(List<String> args) {
        try {
             int id  = Integer.parseInt(args.get(0));
             String name = args.get(1);
             int population = Integer.parseInt(args.get(2));
             String countryCode = args.get(3);
             return new City(id,name,population,countryCode);

        }
        catch (Exception e)
        {
            return new City(-1,"null",-1,"null");
        }
    }
}
