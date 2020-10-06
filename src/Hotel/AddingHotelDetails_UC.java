package Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddingHotelDetails_UC {

	static ArrayList<HotelDetails> hotel = new ArrayList<HotelDetails>();

	private static void findCheapestHotel() throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter start date in format  'ddmmyyy'");
		String startDate = sc.nextLine();
		System.out.println("Enter end date in format  'ddmmyyy'");
		String endDate = sc.nextLine();
		Date startsFrom = null;
		Date endsOn = null;
		long noOfDays = 0;

		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		try {
			startsFrom = dateFormat.parse(startDate);
			endsOn = dateFormat.parse(endDate);

			noOfDays = (endsOn.getTime() - startsFrom.getTime()) / (1000 * 60 * 60 * 24);

			System.out.println(" No of days   : " + noOfDays);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		int weekDays = getWeekDaysBetweenTwoDates(startsFrom, endsOn);
		int weekEndDays = (int) noOfDays - weekDays;

		System.out.println("Week days : " + weekDays);

		System.out.println("weekend days :" + weekEndDays);

		List<Integer> price = hotel.stream().map(h -> {
			return h.getRateWeekDayRegular() * weekDays + h.getRateWeekEndRegular() * weekEndDays;
		}).collect(Collectors.toList());

		cheapHotelResult(weekDays, weekEndDays);

	}

	private static void cheapHotelResult(int weekDays, int weekEndDays) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 :you are regular customer" + "/n 2: you are a reward customer ");
		int choice = scan.nextInt();
         HashMap<String,Integer> hotelNBill = new HashMap<>(); 
         
		switch (choice) {
		case 1:
			
			List<Integer> priceRegular = hotel.stream().map(h -> {
				return h.getRateWeekDayRegular() * weekDays + h.getRateWeekEndRegular() * weekEndDays;
			}).collect(Collectors.toList());
			 int min = priceRegular.get(0);
			 String cheapestHotel = null;
			
			 for(int i=0;i<priceRegular.size();i++)
			{
				 
				hotelNBill.put(hotel.get(i).getHotelName(), priceRegular.get(i));
				if(priceRegular.get(i) <= min)
				{
					min=priceRegular.get(i);
				cheapestHotel = hotel.get(i).getHotelName();
				}
				
				
			}
			 
						 System.out.println("Hotel cheapest in given time range is  : " + cheapestHotel +" and price is : "+min);
			
			
		break;
		
		
		case 2:
			List<Integer> priceReward = hotel.stream().map(h -> {
				return h.getRateWeekDayReward() * weekDays + h.getRateWeekEndReward() * weekEndDays;
				}).collect(Collectors.toList());
			
			int min1 = priceReward.get(0);
			 String cheapestHotel1 = null;
			
			 for(int i=0;i<priceReward.size();i++)
			{
				 
				hotelNBill.put(hotel.get(i).getHotelName(), priceReward.get(i));
				if(priceReward.get(i) <= min1)
				{
					min=priceReward.get(i);
				cheapestHotel = hotel.get(i).getHotelName();
				}
				
				
			}
			 
						 System.out.println("Hotel cheapest in given time range is  : " + cheapestHotel1 +" and price is : "+min1);
			

			break;
		default:
			System.out.println("Invalid input");

		}
	}

	public static int getWeekDaysBetweenTwoDates(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int weekDays = 0;

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++weekDays;

			}

		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return weekDays;
	}

	public static void main(String args[]) throws ParseException {
		HotelDetails hotel1 = new HotelDetails("Lakewood", 110, 80, 3, 90, 80);
		HotelDetails hotel2 = new HotelDetails("Bridgeood", 160, 110, 4, 60, 50);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 220, 100, 5, 150, 40);

		hotel.add(hotel1);
		hotel.add(hotel2);
		hotel.add(hotel3);

		findCheapestHotel();
	}

}
