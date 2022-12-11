package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private static int nbBook = 0;

	// CONSTRUCTORS
	public Book() {
		super();
	}

	public Book(String title) {
		super(title);
		this.id = ++nbBook;
	}

	public Book(String title, float cost) {
		this(title);
		this.cost = cost;
	}

	public Book(String title, String category, float cost) {
		this(title, cost);
		this.category = category;
	}

	// METHODS
	public void addAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			System.out.println("This author existed");
			return;
		}
		this.authors.add(authorName);
	}

	public void addAuthor(String... authorNames) {
		for (String authorName : authorNames) {
			if (this.authors.contains(authorName)) {
				System.out.println("Those authors existed");
				return;
			}
			this.authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		if (!this.authors.contains(authorName)) {
			System.out.println("This author is not in the list");
			return;
		}
		this.authors.remove(authorName);
	}

	public String getAuthor() {
		String result = "";
		for (String author : authors) {
			result += author + ", ";
		}
		return result;
	}

	public String toString() {
		return "Book(" + this.id + "): " + this.title + " - " + this.getAuthor() + " - " + this.category + " - "
				+ this.cost + "$";
	}

}
