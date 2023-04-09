package movieLibrary;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner scan;

	public static void main(String[] args) {
		RepoGenerator.movieRepo();

		int choice = 0;
		scan = new Scanner(System.in);

		System.out.println("-----------------------------------------------------------");
		System.out.println("!!!FOR TESTING PURPOSES, PLEASE FIND THE USER INFO BELOW!!!");
		System.out.println("-----------------------------------------------------------");
		for (A_User user : RepoGenerator.users) {
			if (user instanceof AdminUser adminUser) {
				adminUser.printPersonDetail();
			} else if (user instanceof RegularUser regularUser) {
				regularUser.printPersonDetail();
			}
		}
		System.out.println("***********************************************************");
		System.out.println();
		
		boolean credentials = false;
		do {

			System.out.print("Enter email: ");
			String email = scan.next();
			System.out.print("Enter password: ");
			String password = scan.next();
			System.out.println();

			for (A_User user : RepoGenerator.users) {
				if (!user.signIn(email, password)) {
					continue;
				} else {
					credentials = true;
					System.out.println("*** WELCOME " + user.getName() + " ***");

					do {
						System.out.println();
						if (user instanceof RegularUser regularUser) {
							regularUser.showMenu();

						} else if (user instanceof AdminUser adminUser) {
							adminUser.showMenu();
						}
						System.out.println("*** -1 to exit ***");

						isValidNumber();
						choice = scan.nextInt();
						scan.nextLine();

						switch (choice) {
						case 1 -> {
							user.listMovies();
						}
						case 2 -> {
							System.out.println("Enter Movie Title: ");
							String movieTitle = scan.nextLine();
							user.getMovieDetails(movieTitle);
						}
						case 3 -> {
							for (A_Person person : RepoGenerator.directors) {
								person.printPersonDetail();
							}
						}
						case 4 -> {
							for (A_Person person : RepoGenerator.stars) {
								person.printPersonDetail();
							}
						}
						case 5 -> {
							AdminUser adminUser = (AdminUser) user;
							addMovie(adminUser);
						}
						case 6 -> {
							System.out.println("Enter Director Name: ");
							String name = scan.nextLine();
							AdminUser adminUser = (AdminUser) user;
							adminUser.setDirector(name);
						}
						case 7 -> {
							System.out.println("Enter Star Name: ");
							String name = scan.nextLine();
							AdminUser adminUser = (AdminUser) user;
							adminUser.setStar(name);
						}
						case 8 -> {
							System.out.println("Enter Movie ID to be Deleted: ");
							long id = scan.nextInt();
							scan.nextLine();
							AdminUser adminUser = (AdminUser) user;
							adminUser.deleteMovieById(id);
						}
						case 9 -> {
							System.out.println("Enter Movie Title to be Deleted: ");
							String title = scan.nextLine();
							AdminUser adminUser = (AdminUser) user;
							adminUser.deleteMovieByTitle(title);
						}
						default -> {
							if (choice == -1) {
								System.out.println("Bye Bye " + user.getName());
							} else {
								System.out.println("Enter a valid choice or -1 to exit");
							}
						}
						}
					} while (choice != -1);
				}
			}

		} while (terminateProgram(credentials));
	}

	static void isValidNumber() {

		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Please enter a valid number: ");
		}
	}

	static boolean terminateProgram(boolean credentials) {
		if (!credentials) {
			System.out.println("No such user or wrong password!");
			System.out.println("*******************************");
		}

		System.out.println(
				"Do you want to terminate the progam? " + "\nY to terminate, N to continue with another user.");
		String terminate = scan.next();
		scan.nextLine();

		if (terminate.equals("Y") || terminate.equals("y")) {
			System.out.println("Bye Bye!");
			return false;
		} else {
			return true;
		}
	}

	static boolean addMoreStars() {

		System.out.println("Do you want to add one more star? --> Y/N");

		String terminate = scan.next();
		scan.nextLine();

		if (terminate.equals("Y") || terminate.equals("y")) {
			return true;
		} else {
			return false;
		}
	}

	static void addMovie(AdminUser adminUser) {

		System.out.println("Enter Movie Title: ");
		String title = scan.nextLine();

		System.out.println("Enter Genre: ");
		String genre = scan.nextLine();

		System.out.println("Enter Release Year: ");
		int releaseYear = scan.nextInt();
		scan.nextLine();

		System.out.println("Enter Director: ");
		String directorName = scan.nextLine();
		Director director = adminUser.setDirector(directorName);

		System.out.println("Enter Description: ");
		String description = scan.nextLine();

		List<Star> stars = new ArrayList<>();
		do {
			System.out.println("Enter Stars: ");
			String starName = scan.nextLine();
			Star star = adminUser.setStar(starName);
			if(!stars.contains(star)) {
				stars.add(star);
			}
		} while (addMoreStars());

		Movie movie = new Movie(title, genre, Year.of(releaseYear), director, description, stars);
		adminUser.addMovie(movie);
		director.setMoviesDirected(movie);
		for (Star star : stars) {
			star.setMoviesTookPart(movie);
		}

		System.out.println("*** Details of the movie you've added ***");
		adminUser.getMovieDetails(title);
	}
}
