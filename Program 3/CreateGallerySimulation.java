import java.util.Scanner;

public class CreateGallerySimulation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the Month Day and Year of the simulation: ");
		SenateGallery gallery = new SenateGallery(input.nextLine());
		gallery.initializeSenateGallery();
		System.out.print("Please enter the length of the simulation in minutes: ");
		gallery.runSenateGallerySimulation(input.nextInt());
		input.close();
		gallery.ouputStatistics();
	}
}
