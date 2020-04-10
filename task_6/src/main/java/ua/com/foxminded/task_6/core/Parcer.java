package ua.com.foxminded.task_6.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Parcer {

    public List<Racer> parceRacers (File abbreviations, File start, File end) {
        List<Racer> racers = new ArrayList<>();
        Map<String, LocalDateTime> startMap = getRacersTime(start);
        Map<String, LocalDateTime> endMap = getRacersTime(end);

        try(Stream<String> fileReader = Files.lines(Paths.get(abbreviations.getAbsolutePath()))) {
            fileReader.forEach(line -> racers.add(new Racer(
                    line.substring(0,3),
                    line.substring(4, line.indexOf('_',4)),
                    line.substring(line.indexOf('_', 4) + 1),
                    Duration.between(
                            startMap.get(line.substring(0, 3)),
                            endMap.get(line.substring(0, 3))).toMillis())));
        }catch(IOException e) {
            System.out.println(e.toString());
        }

        return racers;
    }

    private Map<String, LocalDateTime> getRacersTime (File racersTime) {
        Map<String, LocalDateTime> racersData = new HashMap<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        try(Stream<String> fileReader = Files.lines(Paths.get(racersTime.getAbsolutePath()))) {
            fileReader.forEach(line -> racersData.put(
                    line.substring(0, 3),LocalDateTime.parse(line.substring(3), dateFormatter)));
        }catch(IOException e) {
            System.out.println(e.toString());
        }
        return racersData;
    }
}
