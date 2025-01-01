package ie.atu.sw;

//imports
import java.io.File;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws Exception {

		//Making Scanner for user input
		Scanner input = new Scanner(System.in);
		FileHandling fileHandling = new FileHandling();
		EmbeddingsLoader embeddingsLoader = new EmbeddingsLoader();

		// Display the menu
		Utils.displayMenu();

		// Display the progress bar
		int progressSize = 100;  // Total progress size
		int delay = 10;          // Delay in milliseconds for animation
		Utils.displayProgressBar(progressSize, delay);

		//taking in a String input from the user
		System.out.print("\n\nEnter the name of the text file you want us to change: ");
		String text_file = input.nextLine();

		//Move text_file to correct directory
		String filePath = "src/src/ie/atu/sw/Resources/" + text_file;
		System.out.println("Reading from file: " + text_file);

		//calling Filehandling method that prints out each word in the file
		fileHandling.printingFileWords(filePath);

		embeddingsLoader.printEmbeddings(embeddingsLoader.loadEmbeddings("src/src/ie/atu/sw/Resources/embeddings.txt"));


	}

	//Methods




}
