package ie.atu.sw;

public class Runner {

	public static void main(String[] args) throws Exception {

		// Display the menu
		Utils.displayMenu();

		// Display the progress bar
		int progressSize = 100;  // Total progress size
		int delay = 10;          // Delay in milliseconds for animation
		Utils.displayProgressBar(progressSize, delay);


	}
}
