package services;

import mappers.Mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReadingHandler
{

    public static<T> List<T> handle(String filePath, String delimiter , Mapper<T> mapper) throws IOException {

        Optional<List<String>> lines =    readLines(filePath);
        if(lines.isEmpty())
            throw new IOException("wrong file Path");

       return lines.get().stream()
               .map(line ->ReadingHandler.parseLine(line,delimiter))
               .filter(Optional::isPresent)
               .map(args -> mapper.map(args.get()))
               .toList();



    }

    private static Optional<List<String>> readLines(String filePath)
    {
        try {
            List<String> linesList = Files.lines(Paths.get(filePath)).toList();
            return Optional.of(linesList);

        }
        catch (Exception e)
        {
            return Optional.empty();
        }

    }

    private static Optional<List<String>> parseLine(String line,String delimiter)
    {
        if(line==null||line.isEmpty()||delimiter==null||delimiter.isEmpty())
            return Optional.empty();
       return Optional.of(Arrays.stream(line.split(delimiter)).toList());
    }
}


