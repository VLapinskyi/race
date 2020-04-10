package ua.com.foxminded.task_6.main;

import java.io.File;
import java.io.IOException;

import ua.com.foxminded.task_6.core.FileReader;
import ua.com.foxminded.task_6.core.Formatter;
import ua.com.foxminded.task_6.core.Parcer;

public class Launch {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader();
        Parcer race = new Parcer();
        File abbreviations = reader.readFile("abbreviations.txt");
        File start = reader.readFile("start.log");
        File end = reader.readFile("end.log");
        Formatter formatter = new Formatter();

        System.out.println(formatter.format(race.parceRacers(abbreviations, start, end)));

    }

}
