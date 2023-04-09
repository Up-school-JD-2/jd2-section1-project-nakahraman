package movieLibrary;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class RepoGenerator {

	public static List<Star> stars = new ArrayList<>();
	public static List<Movie> movies = new ArrayList<>();
	public static List<Director> directors = new ArrayList<>();
	public static List<A_User> users = new ArrayList<>();

	public static void movieRepo() {

		users.add(new RegularUser("Ela", "ela@mail.com", "1"));
		users.add(new RegularUser("Zeynep", "zeynep@email.com", "1"));
		users.add(new AdminUser("Admin", "admin@mail.com", "1"));

		addDirectors(new Director(ConstantsPerson.JAMES_CAMERON));
		addDirectors(new Director(ConstantsPerson.QUENTIN_TARANTINO));
		addDirectors(new Director(ConstantsPerson.WOLFGANG_PETERSAN));

		addStars(new Star(ConstantsPerson.ARNOLD_SCHWARZENEGGER));
		addStars(new Star(ConstantsPerson.LINDA_HAMILTON));
		addStars(new Star(ConstantsPerson.EDWARD_FURLONG));
		addStars(new Star(ConstantsPerson.LEONARDO_DI_CAPRIO));
		addStars(new Star(ConstantsPerson.KATE_WINSLET));
		addStars(new Star(ConstantsPerson.BILLY_ZANE));
		addStars(new Star(ConstantsPerson.SAM_WORTHINGTON));
		addStars(new Star(ConstantsPerson.ZOE_SALDANA));
		addStars(new Star(ConstantsPerson.SIGOURNEY_WAEVER));
		addStars(new Star(ConstantsPerson.HARVEY_KEITEL));
		addStars(new Star(ConstantsPerson.TIM_ROTH));
		addStars(new Star(ConstantsPerson.MICHAEL_MADSEN));
		addStars(new Star(ConstantsPerson.UMA_THURMAN));
		addStars(new Star(ConstantsPerson.LUCI_LUI));
		addStars(new Star(ConstantsPerson.BRAD_PITT));
		addStars(new Star(ConstantsPerson.ERIC_BANA));
		addStars(new Star(ConstantsPerson.ORLANDO_BLOOM));

		// ------------James Cameron Movies--------------------------------------
		List<Star> starsTemp = new ArrayList<>();

		starsTemp.add(stars.get(0));
		starsTemp.add(stars.get(1));
		starsTemp.add(stars.get(2));
		addMovies(new Movie(ConstantsMovie.TERMINATOR_2_JUDGEMENT_DAY, Genre.SCIENCE_FICTION.name(), Year.of(1991),
				directors.get(0), ConstantsDescription.TERMINATOR_2_JUDGEMENT_DAY, starsTemp));

		directors.get(0).setMoviesDirected(movies.get(0));

		starsTemp = new ArrayList<>();
		starsTemp.add(stars.get(3));
		starsTemp.add(stars.get(4));
		starsTemp.add(stars.get(5));
		addMovies(new Movie(ConstantsMovie.TITANIC, Genre.ROMANCE.name(), Year.of(1997), directors.get(0),
				ConstantsDescription.TITANIC, starsTemp));

		directors.get(0).setMoviesDirected(movies.get(1));

		starsTemp = new ArrayList<>();
		starsTemp.add(stars.get(6));
		starsTemp.add(stars.get(7));
		starsTemp.add(stars.get(8));
		addMovies(new Movie(ConstantsMovie.AVATAR, Genre.ACTION.name(), Year.of(2009), directors.get(0),
				ConstantsDescription.AVATAR, starsTemp));

		directors.get(0).setMoviesDirected(movies.get(2));

		addMovies(new Movie(ConstantsMovie.AVATAR_THE_WAY_OF_WATER, Genre.ACTION.name(), Year.of(2022),
				directors.get(0), ConstantsDescription.AVATAR_THE_WAY_OF_WATER, starsTemp));

		directors.get(0).setMoviesDirected(movies.get(3));

		// -------------Quentin Tarantino Movies-------------------------------------
		starsTemp = new ArrayList<>();
		starsTemp.add(stars.get(9));
		starsTemp.add(stars.get(10));
		starsTemp.add(stars.get(11));

		addMovies(new Movie(ConstantsMovie.RESERVOIR_DOGS, Genre.CRIME.name(), Year.of(1992), directors.get(1),
				ConstantsDescription.RESERVOIR_DOGS, starsTemp));

		directors.get(1).setMoviesDirected(movies.get(4));

		starsTemp = new ArrayList<>();
		starsTemp.add(stars.get(12));
		starsTemp.add(stars.get(13));

		addMovies(new Movie(ConstantsMovie.KILL_BILL, Genre.THRILLER.name(), Year.of(2003), directors.get(1),
				ConstantsDescription.KILL_BILL, starsTemp));

		directors.get(1).setMoviesDirected(movies.get(5));

		starsTemp = new ArrayList<>();
		starsTemp.add(stars.get(14));
		starsTemp.add(stars.get(3));

		addMovies(new Movie(ConstantsMovie.ONCE_UPON_A_TIME_IN_HOLLYWOOD, Genre.COMEDY.name(), Year.of(2019),
				directors.get(1), ConstantsDescription.ONCE_UPON_A_TIME_IN_HOLLYWOOD, starsTemp));

		directors.get(1).setMoviesDirected(movies.get(6));

		// ------------Wolfgang Petersen Movies--------------------------------------
		starsTemp = new ArrayList<>();
		starsTemp.add(stars.get(14));
		starsTemp.add(stars.get(15));
		starsTemp.add(stars.get(16));

		addMovies(new Movie(ConstantsMovie.TROY, Genre.DRAMA.name(), Year.of(2004), directors.get(2),
				ConstantsDescription.TROY, starsTemp));

		directors.get(2).setMoviesDirected(movies.get(7));

	}

	private static void addMovies(Movie movie) {
		if (!movies.contains(movie)) {
			movies.add(movie);
		}
	}

	private static void addDirectors(Director director) {

		if (!directors.contains(director)) {
			directors.add(director);
		}
	}

	private static void addStars(Star star) {

		if (!stars.contains(star)) {
			stars.add(star);
		}
	}
}
