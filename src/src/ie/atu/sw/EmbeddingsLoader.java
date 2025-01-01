package ie.atu.sw;

//imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmbeddingsLoader {

    // Method to load word embeddings from a file
    public Map<String, double[]> loadEmbeddings(String filePath) throws IOException {

        // Create a map to store the embeddings
        Map<String, double[]> embeddings = new HashMap<>();


        // Read the file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read each line in the file
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line by commas
                String[] tokens = line.split(",\\s*");

                // Ensure the line has the correct format
                if (tokens.length < 2) {
                    continue; // Skip malformed lines
                }

                //First token taken as word
                String word = tokens[0];

                // take the rest of the tokens as the vector
                double[] vector = new double[tokens.length - 1];
                for (int i = 1; i < tokens.length; i++) {
                    vector[i - 1] = Double.parseDouble(tokens[i]);
                }

                // Add the word and its vector to the map
                embeddings.put(word, vector);
            }
        }

        // Return the map of embeddings
        return embeddings;
    }

    //method for printing word embeddings for debugging (ensuring they are loaded correctly)
    public void printEmbeddings(Map<String, double[]> embeddings) {
        System.out.println("Word Embeddings:");
        embeddings.forEach((word, vector) -> {
            System.out.print(word + ": ");
            for (double value : vector) {
                System.out.print(value + " ");
            }
            System.out.println();
        });
    }

}
