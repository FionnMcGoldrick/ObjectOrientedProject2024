package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

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


    public void writeGoogleWordsWithEmbeddings(String outputFilePath, List<String> googleWords, Map<String, double[]> embeddings) {

        // Create a StringBuilder to hold the file's new content
        StringBuilder content = new StringBuilder();

        // Check each word and add it to the content only if it has embeddings
        for (String word : googleWords) {
            if (embeddings.containsKey(word)) {
                // Build the word and embeddings line
                content.append(word).append(", ");
                double[] vector = embeddings.get(word);
                for (int i = 0; i < vector.length; i++) {
                    content.append(vector[i]);
                    if (i < vector.length - 1) {
                        content.append(", ");
                    }
                }
                content.append(System.lineSeparator()); // Add a new line
            }
        }

        // Write the complete content to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(content.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


}//class end