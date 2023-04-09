package movieLibrary;

public class AdminUser extends A_User implements I_User {

	private static Long idGenerator = 1L;

	public AdminUser(String name, String email, String password) {

		super(idGenerator++, name, email, password);
	}

	@Override
	public void printPersonDetail() {

		System.out.println("Admin User ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println();
	}

	@Override
	public void signUp(String name, String email, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void signOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showMenu() {

		System.out.println("1. List Movies");
		System.out.println("2. Find Movie");
		System.out.println("3. List Directors");
		System.out.println("4. List Stars");
		System.out.println("5. Add Movie");
		System.out.println("6. Add Director");
		System.out.println("7. Add Star");
		System.out.println("8. Delete Movie by ID");
		System.out.println("9. Delete Movie by Title");

	}

	public void listUsers() {

		for (A_User user : RepoGenerator.users) {
			if (user instanceof AdminUser adminUser) {
				adminUser.printPersonDetail();
			} else if (user instanceof RegularUser regularUser) {
				regularUser.printPersonDetail();
			}
		}
	}

	public void addMovie(Movie movie) {
		RepoGenerator.movies.add(movie);

	}

	public void deleteMovie(Movie movie) {
		RepoGenerator.movies.remove(movie);
	}

	public void deleteMovieByTitle(String movieName) {

		Movie movie = findMovieByTitle(movieName);
		if (!movie.equals(null)) {
			deleteMovie(movie);
		} else {
			System.out.println("No such movie to be deleted!");
		}
	}

	public void deleteMovieById(Long id) {

		Movie movie = findMovieById(id);
		if (!movie.equals(null)) {
			System.out.println("*** The movie " + movie.getTitle() + " has been deleted ***");
			deleteMovie(movie);

		} else {
			System.out.println("No such movie to be deleted!");
		}
	}

	public Director setDirector(String name) {

		for (Director director : RepoGenerator.directors) {
			if (director.getName().equalsIgnoreCase(name)) {
				return director;
			}
		}
		Director director = new Director(name);
		RepoGenerator.directors.add(director);
		return director;
	}

	public Star setStar(String name) {

		for (Star star : RepoGenerator.stars) {
			if (star.getName().equalsIgnoreCase(name)) {
				return star;
			}
		}

		Star star = new Star(name);
		RepoGenerator.stars.add(star);
		return star;
	}

}
