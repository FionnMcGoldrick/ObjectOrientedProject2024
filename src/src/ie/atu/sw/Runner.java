package ie.atu.sw;

import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Map;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws Exception {

		// Making Scanner for user input
		Scanner input = new Scanner(System.in);
		FileHandling fileHandling = new FileHandling();
		EmbeddingsLoader embeddingsLoader = new EmbeddingsLoader();
		GoogleWords googleWords = new GoogleWords();

		// Variables
		String text_file = "";
		String googleFile = "";
		String output_file = "";

		// Constant variable for the directory
		final String DIRECTORY = "src/src/ie/atu/sw/Resources/";

		while (true) {
			// Display the menu
			Utils.displayMenu();

			// Display the progress bar
			int progressSize = 100; // Total progress size
			int delay = 10; // Delay in milliseconds for animation
			Utils.displayProgressBar(progressSize, delay);

			// Menu choice input in switch statement
			System.out.print("\n\nEnter the number of the option you want to choose: ");
			int choice = input.nextInt();
			input.nextLine(); // Consume the newline character

			// Switch statement for menu choice
			switch (choice) {
				case 1:
					// Taking in a String input from the user
					System.out.print("\n\nEnter the name of the text file you want us to change: ");
					text_file = input.nextLine();
					System.out.println("File selected: " + text_file);
					break;

				case 2:
					System.out.print("Enter the name of the Google 1000 file: ");
					googleFile = input.nextLine();
					System.out.println("File selected: " + googleFile);
					break;

				case 3:
					System.out.print("Enter the name of the output file (default: ./out.txt): ");
					output_file = input.nextLine();
					System.out.println("Output file selected: " + output_file);
					break;

				case 4:
					System.out.println("You chose option 4: Compare the words in the text file to the words in the embeddings file");
					break;

				case 5:
					System.out.println("You chose option 5: Add embeddings to the Google words and write them to a new file");
					// Exit the loop and program when the user selects option 5
					System.out.println("Exiting the program. Goodbye!");
					input.close();
					return;

				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 5.");
					break;
			}

			// Perform actions outside the switch based on the current file and embeddings setup
			if (!text_file.isEmpty() && !googleFile.isEmpty() && !output_file.isEmpty()) {
				// Correct path handling
				String filePath = Paths.get(DIRECTORY, text_file).toString();
				String googleFilePath = Paths.get(DIRECTORY, googleFile).toString();
				String outputFilePath = Paths.get(DIRECTORY, output_file).toString();
				String embeddingsFilePath = Paths.get(DIRECTORY, "embeddings.txt").toString();

				System.out.println("Reading from file: " + filePath);

				// Calling FileHandling method that prints out each word in the file
				fileHandling.printingFileWords(filePath);

				// Load embeddings from file and store in a variable
				Map<String, double[]> embeddings = embeddingsLoader.loadEmbeddings(embeddingsFilePath);

				// Load google words from file and store in a variable
				List<String> googleWordsList = googleWords.loadGoogleWords(googleFilePath);

				// Calling FileHandling method that will add embeddings to the google words
				fileHandling.writeGoogleWordsWithEmbeddings(outputFilePath, googleWordsList, embeddings);
			}
		}
	}
}
