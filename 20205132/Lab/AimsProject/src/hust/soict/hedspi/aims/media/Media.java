package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    // CONSTRUCTORS
    public Media() {
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, float cost) {
        this(title);
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this(title, cost);
        this.category = category;
    }


    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    // METHODS
    @Override
    public boolean equals(Object o) {
        Media media = (Media) o;
        return this.title.equals(media.title);
    }

    public String toString() {
        return "Media: " + this.title + " - " + this.category + " - " + this.cost + "$";
    }

}
