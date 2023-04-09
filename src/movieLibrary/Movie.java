package movieLibrary;

import java.time.Year;
import java.util.List;

public class Movie {

	private static Long idGenerator = 1L;
	private Long id;
	private String title;
	private String genre;
	private Year relaseYear;
	private Director director;
	private List<Star> stars;
	private String description;

	public Movie() {

	}

	public Movie(String title, String genre, Year releaseYear, Director director, String description,
			List<Star> stars) {

		super();
		this.id = idGenerator++;
		this.title = title;
		this.genre = genre;
		this.relaseYear = releaseYear;
		this.director = director;
		this.description = description;
		this.stars = stars;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Year getRelaseYear() {
		return relaseYear;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public void setStars(Star star) {
		this.stars.add(star);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Star> getStars() {
		return stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

	public void printMovie() {

		System.out.println("ID: " + id);
		System.out.println("TITLE: " + title);
		System.out.println("GENRE: " + genre);
		System.out.println("YEAR: " + relaseYear);
		System.out.println("DIRECTOR: " + director.getName());
		System.out.println("DESCRIPTION: " + description);
		System.out.println("Stars:");
		for (Star star : stars) {
			System.out.println("-" + star.getName());
		}
		System.out.println();
	}

}
