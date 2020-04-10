package ua.com.foxminded.task_6.core;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class FileReader {
    public File readFile (String path) {
        String getPath = getClass().getClassLoader().getResource(path).getFile();
        try {
            getPath = URLDecoder.decode(getPath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.toString());
        }	
        return new File (getPath);
    }
}
