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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            for (String word : googleWords) {
                // Check if the word has embeddings
                if (embeddings.containsKey(word)) {
                    // Write the word and its embeddings
                    writer.write(word + ", ");
                    double[] vector = embeddings.get(word);
                    for (int i = 0; i < vector.length; i++) {
                        writer.write(String.valueOf(vector[i]));
                        if (i < vector.length - 1) {
                            writer.write(", ");
                        }
                    }
                    writer.newLine();
                } else {
                    // Optional: Log missing embeddings
                    writer.write(word + " - No Embedding Found");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}//class end