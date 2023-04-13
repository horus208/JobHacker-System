package mappers;

import entities.Country;

import java.util.List;

public class CountryMapper implements Mapper<Country>{
    @Override
    public Country map(List<String> args)
    {
        try {
            String code  = args.get(0);
            String name = args.get(1);
            String continent = args.get(2);
            double surfaceArea = Double.parseDouble(args.get(3));
            double population = Double.parseDouble(args.get(4));
            double gnp =  Double.parseDouble(args.get(5));
            int capital = Integer.parseInt(args.get(6));
            return new Country(code,name,continent,surfaceArea,population,gnp,capital);

        }
        catch (Exception e)
        {
            return new Country("null","null","null",0,0,0,-1);
        }

    }
}
