package ie.atu.sw;

public class Utils {

    // Method to display the menu
    public static void displayMenu() {
        System.out.println(ConsoleColour.WHITE);
        System.out.println("************************************************************");
        System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
        System.out.println("*                                                          *");
        System.out.println("*             Virtual Threaded Text Simplifier             *");
        System.out.println("*                                                          *");
        System.out.println("************************************************************\n");
        System.out.println("(1) Specify Embeddings File");
        System.out.println("(2) Specify Google 1000 File");
        System.out.println("(3) Specify an Output File (default: ./out.txt)");
        System.out.println("(4) Execute, Analyse and Report");
        System.out.println("(5) Optional Extras...");
        System.out.println("(?) Quit");
        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        System.out.print("Select Option [1-4]> ");
    }

    // Method to display a progress bar
    public static void displayProgressBar(int total, int delay) throws InterruptedException {
        System.out.print(ConsoleColour.YELLOW); // Change the colour of the console text
        for (int i = 0; i < total; i++) {       // Loop for a sequence of processing steps
            printProgress(i + 1, total);       // Update the progress meter after each step
            Thread.sleep(delay);               // Slows down the animation to make it visible
        }
    }

    // Progress bar logic
    private static void printProgress(int index, int total) {
        if (index > total) return;    // Out of range
        int size = 50;               // Must be less than console width
        char done = '█';             // Change to whatever you like.
        char todo = '░';             // Change to whatever you like.

        // Compute basic metrics for the meter
        int complete = (100 * index) / total;
        int completeLen = size * complete / 100;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append((i < completeLen) ? done : todo);
        }

        // Use "\r" to overwrite the current line and create the animation effect
        System.out.print("\r" + sb + "] " + complete + "%");

        // Move to a new line once the meter reaches 100%
        if (index == total) System.out.println();
    }
}

