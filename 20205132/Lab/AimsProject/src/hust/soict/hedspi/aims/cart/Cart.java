package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.*;

public class Cart {

    private List<Media> itemsOrdered = new ArrayList<Media>();

    // CONSTRUCTORS

    public Cart() {
    }

    public void addItem(Media item) {
        if (item == null) {
            System.out.println("Add to cart fail");
            return;
        }
        itemsOrdered.add(item);
        System.out.println("Items added to cart!!!");
    }

    public void addItem(Media... items) {
        for (Media item : items) {
            itemsOrdered.add(item);
            System.out.println("New Item added to store");
            System.out.println("Number of items in cart: " + itemsOrdered.size());
        }
    }

    public void removeItem(Media item) {
        itemsOrdered.remove(item);
        System.out.println("Item removed from cart!!!");
    }

    public float totalCost() {
        float total = 0;
        for (Media item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("\n******************* CART *******************\n");
        System.out.println("Ordered Items: ");
        for (Media item : itemsOrdered) {
            System.out.println(item.toString());
        }
        System.out.println("Total Cost: " + this.totalCost());
        System.out.println("--------------------------------");
    }

    public Media searchByTitle(String title) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                System.out.println(itemsOrdered.get(i).toString());
                return itemsOrdered.get(i);
            }
        }
        System.out.println("No match found!");
        return null;
    }

    public void filterById(int id) {
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println(item.toString());
            }
        }
    }

    public void filterByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                System.out.println(item.toString());
            }
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        printCart();
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        printCart();
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart is cleared");
    }

}
