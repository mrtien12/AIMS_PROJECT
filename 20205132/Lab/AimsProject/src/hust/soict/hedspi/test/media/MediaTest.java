package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.*;

public class MediaTest {
	
	public static void main(String[] args) {
		
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd  = new CompactDisc("To pimp a butterfly ","Rap",19.99f,"KL","kendrick lamar");
		DigitalVideoDisc dvd = new DigitalVideoDisc("John wick 4", "Action", 25.46f,"Chad stahelski",36);
		Track track1 = new Track("Demons",28);
		Track track2 = new Track("Angels",44);
		cd.addTrack(track1,track2);
		Book book1 = new Book("A song of ice and fire","Novel",42.34f);
		Book book2 = new Book("To kill a mockingbird","Novel",3.26f);
		book1.addAuthor("JRR Martin");
		book2.addAuthor("Harper lee","hello");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book1);
		mediae.add(book2);
		Collections.sort(mediae,Media.COMPARE_BY_TITLE_COST);
		for(Media m: mediae) {
			System.out.println(m.toString());
		}
	}
}
