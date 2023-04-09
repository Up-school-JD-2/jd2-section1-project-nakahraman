package movieLibrary;

import java.util.ArrayList;
import java.util.List;

public class Star extends A_Person {
	
	private static Long idGenerator = 1L;
	private List<Movie> moviesTookPart = new ArrayList<>();

	public Star() {
		
	}
	
	public Star(String name) {
		super(idGenerator++, name);
	}
	

	public List<Movie> getMoviesTookPart() {
		return moviesTookPart;
	}


	public void setMoviesTookPart(Movie movie) {
		if(!this.moviesTookPart.contains(movie)) {
			this.moviesTookPart.add(movie);
		}	
		
	}

	public void getMoviesOfStar() {
		for(Movie movie : RepoGenerator.movies) {
			for(Star star : movie.getStars()) {
				if(star.id.equals(this.id)) {
					if(!this.moviesTookPart.contains(movie)) {
						this.moviesTookPart.add(movie);
					}	
				}
			}
		}
	}

	@Override
	public void printPersonDetail() {	
		getMoviesOfStar();
		System.out.println("ID: " + id);	
		System.out.println("NAME: " + name);
		System.out.println("Took part in " + moviesTookPart.size() + " movie(s)");
		for(Movie movie : moviesTookPart) {
			System.out.println("-" + movie.getTitle());
		}
		System.out.println();
	}
	
}
