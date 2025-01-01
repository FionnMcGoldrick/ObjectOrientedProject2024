package ie.atu.sw;

//imports
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws Exception {

		//Making Scanner for user input
		Scanner input = new Scanner(System.in);


		// Display the menu
		Utils.displayMenu();

		// Display the progress bar
		int progressSize = 100;  // Total progress size
		int delay = 10;          // Delay in milliseconds for animation
		Utils.displayProgressBar(progressSize, delay);

		//taking in a String input from the user
		System.out.print("\n\nEnter the name of the text file you want us to change: ");
		String text_file = input.nextLine();

		System.out.println("Reading from file: " + text_file);

		try {
			// Read file as a list of words
			List<String> words = FileHandling.readFileAsWords(text_file);
			System.out.println("Words in File:");

			// Print each word
			for (String word : words) {
				System.out.println(word + " ");
			}
		} catch (Exception e) {
			System.err.println("Error reading file: " + e.getMessage());
		}


	}


}
