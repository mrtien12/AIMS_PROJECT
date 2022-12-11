package hust.soict.hedspi.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	// CONSTRUCTORS
	public Track() {
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	// GETTERS
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	// METHODS
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object o) {
		Track track = (Track) o;
		return this.title.equals(track.title) && this.length == track.length;
	}

}
