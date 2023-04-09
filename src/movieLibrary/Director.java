package movieLibrary;

import java.util.ArrayList;
import java.util.List;

public class Director extends A_Person {

	private static Long idGenerator = 1L;
	List<Movie> moviesDirected = new ArrayList<>();

	public Director(String name) {
		super(idGenerator++, name);
	}

	public List<Movie> getMoviesDirected() {
		return moviesDirected;
	}

	public void setMoviesDirected(Movie movie) {
		this.moviesDirected.add(movie);
	}

	public void setMoviesDirected(List<Movie> moviesDirected) {
		this.moviesDirected = moviesDirected;
	}

	@Override
	public void printPersonDetail() {

		System.out.println("------------------------------------");
		System.out.println("*** " + name.toUpperCase() + " directed " + moviesDirected.size() + " movie(s) ***");
		System.out.println("------------------------------------");

		for (Movie movie : moviesDirected) {
			movie.printMovie();
		}

		System.out.println();
	}

}
