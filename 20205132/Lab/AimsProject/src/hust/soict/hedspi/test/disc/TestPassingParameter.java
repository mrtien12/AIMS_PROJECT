package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		Wrapper wo1 = new Wrapper(jungleDVD);
		Wrapper wo2 = new Wrapper(cinderellaDVD);
		
		swap(wo1,wo2);
		System.out.println("jungle dvd title: " + wo1.a.getTitle());
		System.out.println("cinderella dvd title: " + wo2.a.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Wrapper o1, Wrapper o2) {
		DigitalVideoDisc tmp = o1.a;
		o1.a = o2.a;
		o2.a = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}

class Wrapper {
	   DigitalVideoDisc a;
	   public Wrapper(DigitalVideoDisc a){ this.a = a;}
}
