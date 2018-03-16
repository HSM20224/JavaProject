
public class ImdbTest {
	public static void main(String[] args) { 
		Imdb Movie;
		Movie = new Imdb();
		
		Movie.year = 2017;
		Movie.title = "Josie";
		Movie.writer = "Anthony Ragnone II ";
		Movie.time = "1h 40min";
		Movie.stars = "Sophie Turner, Dylan McDermott, Daeg Faerch";
		Movie.releaseDate = "16 March 2018 (USA)";
		Movie.rating = (float)6.6;
		Movie.genre = "Drama, Thriller";
		Movie.director = "Eric England";
		
		Movie.print();
	}
}
