package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// Create a new cart
		Store store = new Store();

		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87);
		store.addItem(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, "George Lucas", 87);
		store.addItem(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addItem(dvd3);

		store.addItem(dvd1, dvd2, dvd3);
		
		store.removeItem(dvd3);
		store.printStore();
	}

}
