package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandling {

    //method that reads in a String that is the name of a file and returns the contents of the file as a String
    public static List<String> readFileAsWords(String fileName) throws IOException {
        // Read file contents as a String
        String content = Files.readString(Path.of(fileName));
        // Split the content into words by spaces and convert to a List
        return new ArrayList<>(Arrays.asList(content.split("\\s+")));
    }

}
