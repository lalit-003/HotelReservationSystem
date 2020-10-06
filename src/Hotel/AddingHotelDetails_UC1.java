package Hotel;

import java.util.ArrayList;

public class AddingHotelDetails_UC1 {

	public static void main(String args[]) {

		ArrayList<HotelDetails> hotel = new ArrayList<HotelDetails>();

		HotelDetails hotel1 = new HotelDetails("Lakewood", 110, 80, 3, 90, 80);
		HotelDetails hotel2 = new HotelDetails("Bridgeood", 160, 110, 4, 60, 50);
		HotelDetails hotel3 = new HotelDetails("Lakewood", 220, 100, 5, 150, 40);

		hotel.add(hotel1);
		hotel.add(hotel2);
		hotel.add(hotel3);
	}
}
