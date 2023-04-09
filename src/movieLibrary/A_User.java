package movieLibrary;

public abstract class A_User extends A_Person implements I_User {

	public String email;

	public String password;

	public A_User() {
		super();
	}

	public A_User(Long id, String name, String email, String password) {
		super(id, name);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean signIn(String email, String password) {
		if (this.email.equals(email) && this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public void getMovieDetails(String name) {
		Movie movie = findMovieByTitle(name);
		movie.printMovie();

	}

	public Movie findMovieByTitle(String name) {

		for (Movie movie : RepoGenerator.movies) {
			if (movie.getTitle().equalsIgnoreCase(name)) {
				return movie;
			}
		}
		return new Movie();
	}

	public Movie findMovieById(Long id) {

		for (Movie movie : RepoGenerator.movies) {
			if (movie.getId().equals(id)) {
				return movie;
			}
		}
		return new Movie();
	}

	public void listMovies() {
		for (Movie movie : RepoGenerator.movies) {
			movie.printMovie();
		}

	}

}
