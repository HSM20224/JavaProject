
public class Book {
	private String title;
	private String author;
	private String publisher;
	private String genre;
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Book(){}
	
	public Book(String title, String author, String genre, String publisher, int page){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.page = page;
	}

}


