package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.*;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
    }

    public void addItem(Media item) {
        if (item == null) {
            System.out.println("Add to store fail");
            return;
        }
        if (itemsInStore.contains(item)) {
            System.out.println("Item is already in store!!!");
            return;
        }
        itemsInStore.add(item);
        System.out.println("New Item added to store");
    }

    public void addItem(Media... medias) {
        for (Media media : medias) {
            if (itemsInStore.contains(media)) {
                System.out.println("Item is already in store!!!");
                continue;
            }
            itemsInStore.add(media);
            System.out.println("New Item added to store");
        }
    }

    public void removeItem(Media item) {
        if (!itemsInStore.contains(item)) {
            System.out.println("This Item is not in store!!!");
            return;
        }
        itemsInStore.remove(item);
        System.out.println("Item removed from store");
    }

    public void printStore() {
        System.out.println("\n******************* STORE *******************\n");
        System.out.println("Store Items: ");
        for (Media item : itemsInStore) {
            System.out.println(item.toString());
        }
        System.out.println("                   ~ END ~");
    }

    public Media searchByTitle(String title) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).getTitle().equals(title)) {
                System.out.println(itemsInStore.get(i).toString());
                return itemsInStore.get(i);
            }
        }
        System.out.println("No match found!");
        return null;
    }
}
