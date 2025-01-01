package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandling {

    //method that reads in a String that is the name of a file and returns the contents of the file as a String
    public List<String> readFileAsWords(String fileName) throws IOException {
        // Read file contents as a String
        String content = Files.readString(Path.of(fileName));
        // Split the content into words by spaces and convert to a List
        return new ArrayList<>(Arrays.asList(content.split("\\s+")));
    }

    public void printingFileWords(String filePath) {
        try {
            // Read file as a list of words
            List<String> words = readFileAsWords(filePath);
            System.out.println("Words in File:");

            // Print each word
            for (String word : words) {
                System.out.print(word + " ");
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    //method that takes each word in the file and compares it to each word of the embeddings
    public void compareWordsToEmbeddings(List<String> words, List<String> embeddings) {

        // Compare each word in the file to each word in the embeddings
        for (String word : words) {

            // Check if the word is in the embeddings
            if (embeddings.contains(word)) {
                System.out.println("Word '" + word + "' found in embeddings");
            } else {
                System.out.println("Word '" + word + "' not found in embeddings");
            }
        }
    }



}
