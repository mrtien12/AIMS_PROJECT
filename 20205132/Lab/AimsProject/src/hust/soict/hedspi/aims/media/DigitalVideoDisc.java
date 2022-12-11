package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {

    private static int nbDVD = 0;

    // CONSTRUCTORS
    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(String title) {
        this.id = ++nbDVD;
        this.title = title;
    }

    public DigitalVideoDisc(String title, float cost) {
        this(title);
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, cost);
        this.category = category;
    }

    public DigitalVideoDisc(String title, String category, float cost, String director) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        this(title, category, cost, director);
        this.length = length;
    }


    // GETTERS
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    // METHODS
    public String toString() {
        return "DVD(" + this.id + "): " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + " - " + this.cost + "$";
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD Length: " + this.getLength());
    }
}
