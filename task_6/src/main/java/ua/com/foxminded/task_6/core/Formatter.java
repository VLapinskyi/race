package ua.com.foxminded.task_6.core;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Formatter {

    public String format(List<Racer> racers) {
        List<Racer> racersPlaces = racers.stream().sorted((racer1, racer2) -> racer1.getRaceResult().compareTo(racer2.getRaceResult()))
                .collect(Collectors.toList());
        int maxLenghtRacerName = getMaxStringLenght(racersPlaces.stream().map(racer -> racer.getName())) + 1;
        int maxLenghtTeamName = getMaxStringLenght(racersPlaces.stream().map(racer -> racer.getTeam()));

        StringJoiner scoreBoard = new StringJoiner("\n");
        racersPlaces.stream().forEach(racer -> {
            int racerPlace = racersPlaces.indexOf(racer) + 1;
            int whitespacesAfterName = -1 * (maxLenghtRacerName - Integer.toString(racersPlaces.indexOf(racer) + 1).length());
            int whitespacesAfterTeam = -1 * maxLenghtTeamName;
            long minutesResult = racer.getRaceResult()/1000/60;
            long secondsResult = racer.getRaceResult()/1000%60;
            long milisecondsResult = racer.getRaceResult()%1000;

            scoreBoard.add(String.format("%d. %" + whitespacesAfterName + "s | %" + whitespacesAfterTeam + "s | %d:%02d.%03d",
                    racerPlace, racer.getName(), racer.getTeam(), minutesResult, secondsResult, milisecondsResult));

            if (racerPlace == 15) {
                String separatorLine = scoreBoard.toString().substring(0, scoreBoard.toString().indexOf("\n"))
                        .replaceAll(".", "-"); scoreBoard.add(separatorLine); }

        });

        return scoreBoard.toString();
    }

    private int getMaxStringLenght (Stream<String> streamText) {
        return streamText.max((racer1, racer2) -> Integer.valueOf(racer1.length())
                .compareTo(Integer.valueOf(racer2.length()))).get().length();
    }
}
