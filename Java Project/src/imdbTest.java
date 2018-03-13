
public class imdbTest {
	public static void main(String[] args) { 
		imdb Movie;
		Movie = new imdb();
		
		Movie.Year = 2017;
		Movie.Title = "Josie";
		Movie.Writer = "Anthony Ragnone II ";
		Movie.Time = "1h 40min";
		Movie.Stars = "Sophie Turner, Dylan McDermott, Daeg Faerch";
		Movie.ReleaseDate = "16 March 2018 (USA)";
		Movie.Rating = (float)6.6;
		Movie.Genre = "Drama, Thriller";
		Movie.Director = "Eric England";
		
		Movie.print();
	}
}
