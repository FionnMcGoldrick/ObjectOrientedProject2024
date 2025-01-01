package ie.atu.sw;

//imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleWords {

    //method that loads in 1000 google words from a file
    public List<String> loadGoogleWords(String filePath) throws IOException {

        // Create a list of Strings to store the google words
        List<String> googleWords = new ArrayList<>();

        // Read the file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read each line in the file
            String line;

            while ((line = br.readLine()) != null) {
                // Add the word to the list
                googleWords.add(line);
            }
        }

        //prints out the google words
        System.out.println("Google Words:");
        for (String word : googleWords) {
            System.out.print(word + " ");
         }

        // Return the list of google words
        return googleWords;
    }
}
