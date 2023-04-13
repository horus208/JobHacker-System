import entities.City;
import entities.Country;
import mappers.CityMapper;
import mappers.CountryMapper;
import services.AnalysisService;
import services.ReadingHandler;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        AnalysisService analysisService = new AnalysisService();
        List<Country> countries;
        List<City> cities;


             countries = ReadingHandler.handle(
                    "D:\\JobHacker-System\\week_03\\streams_task\\src\\main\\resources\\Countries.csv",",",
                    new CountryMapper());

             cities = ReadingHandler.handle(
                    "D:\\JobHacker-System\\week_03\\streams_task\\src\\main\\resources\\Cities.csv",",",
                    new CityMapper());

           var question1 =  analysisService.mostPopulatedCityInCountry(cities);
           var question2 = analysisService.mostPopulatedCityInContinent(cities,countries);
           var question3 = analysisService.highestPopulatedCapital(cities,countries);

           System.out.println("------------- most populated city in each country -------------");
           question1.forEach((k,v)-> System.out.println(k + " ---> "+v.get()));
           System.out.println("====================================================================");

        System.out.println("------------- most populated city in each continent -------------");
        question2.forEach((k,v)-> System.out.println(k + " ---> "+v.get()));
        System.out.println("====================================================================");

        System.out.println("------------- most populated capital city -------------");
        System.out.println(question3.get());







    }
}
