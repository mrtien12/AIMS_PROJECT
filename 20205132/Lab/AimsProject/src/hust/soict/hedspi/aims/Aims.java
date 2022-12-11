package hust.soict.hedspi.aims;

import java.util.Collections;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    static Store store = new Store();
    static Cart cart = new Cart();
    static Object currentMedia = new Object();
    static boolean isPlayable = false;

    public static void main(String args[]) {
    	CompactDisc cd  = new CompactDisc("To pimp a butterfly ","Rap",19.99f,"KL","kendrick lamar");
		DigitalVideoDisc dvd = new DigitalVideoDisc("John wick 4", "Action", 25.46f,"Chad stahelski",36);
		Track track1 = new Track("Demons",28);
		Track track2 = new Track("Angels",44);
        cd.addTrack(track1, track2);
        Book book1 = new Book("A song of ice and fire","Novel",42.34f);
		Book book2 = new Book("To kill a mockingbird","Novel",3.26f);
		book1.addAuthor("JRR Martin");
		book2.addAuthor("Harper lee","hello");

        store.addItem(cd, dvd, book1, book2);

        showMenu();
    }

    // Methods
    public static void showMenu() {
        for (; ; ) {
            System.out.println("\nAIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Your choice: ");
            int choice = keyboard.nextInt();
            if (choice == 1) {
                store.printStore();
                storeMenu();
            } else if (choice == 2) {
                storeUpdate();
            } else if (choice == 3) {
                cart.printCart();
                cartMenu();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice please choose again.");
            }
        }
        System.out.println("Thank you for using our service!");
    }

    public static void storeUpdate() {
        for (; ; ) {
            store.printStore();
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media");
            System.out.println("2. Remove media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Your choice: ");
            int choice = keyboard.nextInt();
            if (choice == 1) {
                int x;
                for (; ; ) {
                    System.out.println("Type of media to add");
                    System.out.println("--------------------------------");
                    System.out.println("1. Book");
                    System.out.println("2. DVD");
                    System.out.println("3. CD");
                    System.out.println("0. Back");
                    keyboard = new Scanner(System.in);
                    System.out.print("Your choice: ");
                    x = keyboard.nextInt();
                    if (x == 0) {
                        break;
                    }
                    if (x > 3 || x < 0) {
                        System.out.println("Invalid type of media.\n");
                        continue;
                    }
                    break;
                }
                if (x == 0) {
                    break;
                }

                keyboard = new Scanner(System.in);
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();
                keyboard = new Scanner(System.in);
                System.out.print("Enter cost: ");
                float cost = keyboard.nextFloat();
                keyboard = new Scanner(System.in);
                System.out.print("Enter category: ");
                String category = keyboard.nextLine();

                if (x == 1) {
                    Book book = new Book(title, category, cost);
                    System.out.println("Input '*' when add all authors.");
                    for (; ; ) {
                        keyboard = new Scanner(System.in);
                        System.out.print("Enter author: ");
                        String author = keyboard.nextLine();
                        if (author.equals("*")) {
                            break;
                        }
                        book.addAuthor(author);
                    }
                    store.addItem(book);
                }
                if (x == 2) {
                    keyboard = new Scanner(System.in);
                    System.out.print("Enter director: ");
                    String director = keyboard.nextLine();
                    keyboard = new Scanner(System.in);
                    System.out.print("Enter length: ");
                    int length = keyboard.nextInt();
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, director, length);
                    store.addItem(dvd);
                }
                if (x == 3) {
                    keyboard = new Scanner(System.in);
                    System.out.print("Enter director: ");
                    String director = keyboard.nextLine();
                    keyboard = new Scanner(System.in);
                    System.out.print("Enter artist: ");
                    String artist = keyboard.nextLine();
                    CompactDisc cd = new CompactDisc(title, category, cost, artist, director);
                    System.out.println("Input '*' when add all tracks.");
                    for (; ; ) {
                        keyboard = new Scanner(System.in);
                        System.out.print("Enter track's title: ");
                        String trackTitle = keyboard.nextLine();
                        if (trackTitle.equals("*")) {
                            break;
                        }
                        keyboard = new Scanner(System.in);
                        System.out.print("Enter track's length: ");
                        int trackLength = keyboard.nextInt();

                        Track track = new Track(trackTitle, trackLength);
                        cd.addTrack(track);
                    }
                    store.addItem(cd);
                }

            } else if (choice == 2) {
                keyboard = new Scanner(System.in);
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();
                store.removeItem(store.searchByTitle(title));
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice please choose again.");
            }
        }
    }


    public static void storeMenu() {
        for (; ; ) {
            isPlayable = false;
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Your choice: ");
            int choice = keyboard.nextInt();
            if (choice == 1) {
                keyboard = new Scanner(System.in);
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();
                Media checkMedia = store.searchByTitle(title);
                if (checkMedia == null) {
                    continue;
                }
                if (checkMedia instanceof Disc) {
                    isPlayable = true;
                }
                currentMedia = checkMedia;
                mediaDetailsMenu();
            } else if (choice == 2) {
                keyboard = new Scanner(System.in);
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();
                Media checkMedia = store.searchByTitle(title);
                if (checkMedia == null) {
                    continue;
                }
                cart.addItem(checkMedia);
            } else if (choice == 3) {
                keyboard = new Scanner(System.in);
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();
                Media checkMedia = store.searchByTitle(title);
                if (checkMedia == null) {
                    continue;
                }
                if (checkMedia instanceof Disc) {
                    Disc tmp = (Disc) checkMedia;
                    tmp.play();
                    continue;
                }
                System.out.println("This media type is not playable.");
            } else if (choice == 4) {
                cart.printCart();
                cartMenu();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice please choose again.");
            }
        }
    }

    public static void mediaDetailsMenu() {
        for (; ; ) {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Your choice: ");
            int choice = keyboard.nextInt();
            if (choice == 1) {
                cart.addItem((Media) currentMedia);
                break;
            } else if (choice == 2) {
                if (isPlayable) {
                    Disc tmp = (Disc) currentMedia;
                    tmp.play();
                    continue;
                }
                System.out.println("This media type is not playable.");
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice please choose again.");
            }
        }
    }

    public static void cartMenu() {
        for (; ; ) {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Your choice: ");
            int choice = keyboard.nextInt();
            if (choice == 1) {
                int x;
                for (; ; ) {
                    System.out.println("\nOptions: ");
                    System.out.println("--------------------------------");
                    System.out.println("1. Filter by id");
                    System.out.println("2. Filter by title");
                    System.out.println("0. Back");
                    System.out.println("--------------------------------");
                    System.out.println("Please choose a number: 0-1-2");
                    keyboard = new Scanner(System.in);
                    System.out.print("Your choice: ");
                    x = keyboard.nextInt();
                    if (x == 1) {
                        keyboard = new Scanner(System.in);
                        System.out.print("Enter id: ");
                        int id = keyboard.nextInt();
                        cart.filterById(id);
                        break;
                    } else if (x == 2) {
                        keyboard = new Scanner(System.in);
                        System.out.print("Enter title: ");
                        String title = keyboard.nextLine();
                        cart.filterByTitle(title);
                        break;
                    } else if (x == 0) {
                        break;
                    } else {
                        System.out.println("Invalid choice please choose again.");
                    }
                }

            } else if (choice == 2) {
                int x;
                for (; ; ) {
                    System.out.println("\nOptions: ");
                    System.out.println("--------------------------------");
                    System.out.println("1. Sort by title");
                    System.out.println("2. Sort by cost");
                    System.out.println("0. Back");
                    System.out.println("--------------------------------");
                    System.out.println("Please choose a number: 0-1-2");
                    keyboard = new Scanner(System.in);
                    System.out.print("Your choice: ");
                    x = keyboard.nextInt();
                    if (x == 1) {
                        cart.sortByTitle();
                        break;
                    } else if (x == 2) {
                        cart.sortByCost();
                        break;
                    } else if (x == 0) {
                        break;
                    } else {
                        System.out.println("Invalid choice please choose again.");
                    }
                }
            } else if (choice == 3) {
                keyboard = new Scanner(System.in);
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();
                cart.removeItem(cart.searchByTitle(title));
            } else if (choice == 4) {
                keyboard = new Scanner(System.in);
                System.out.print("Enter title: ");
                String title = keyboard.nextLine();
                Media checkMedia = cart.searchByTitle(title);
                if (checkMedia instanceof Disc) {
                    Disc tmp = (Disc) checkMedia;
                    tmp.play();
                    continue;
                }
                System.out.println("This type of media is not playable.");
            } else if (choice == 5) {
                System.out.println("An Order is created");
                cart.clearCart();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice please choose again.");
            }
        }


    }

}
