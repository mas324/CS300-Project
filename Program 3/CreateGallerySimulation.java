import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateGallerySimulation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SenateGallery gallery = new SenateGallery();
		String date = "";
		int minutes = -1;

		do {
			try {
				System.out.print("Please enter the Month Day and Year of the simulation: ");
				date = input.nextLine();
				// date = "December 13";
				System.out.print("Please enter the length of the simulation in minutes >0: ");
				minutes = input.nextInt();
				// minutes = 1000;
				if (minutes < 1)
					System.out.print("Minutes must be more than 0\n\n");
			} catch (InputMismatchException e) {
				System.out.printf("%nThere was an error: %s%n", e);
				input.nextLine();
				minutes = -1;
			}
		} while (minutes < 1);

		input.close();
		gallery.setDate(date);
		gallery.initializeSenateGallery();
		gallery.runSenateGallerySmimulation(minutes);
		gallery.outputStatistics();
	}
}
