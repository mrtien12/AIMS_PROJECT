package hust.soict.hedspi.aims.media;

public class Disc extends Media implements Playable {

    protected int length;
    protected String director;

    // CONSTRUCTORS
    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, float cost) {
        super(title, cost);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, float cost, String director, int length) {
        this(title, category, cost, director);
        this.length = length;
    }

    // GETTERS
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void play() {
    }
}
