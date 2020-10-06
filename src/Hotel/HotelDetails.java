package Hotel;

public class HotelDetails {

	private String hotelName;
	private int rateWeekDayRegular;
	private int rateWeekEndRegular;
	private int rating;
	private int rateWeekDayReward;
	private int rateWeekEndReward;

	public HotelDetails(String hotelName , int rateWeekDayRegular,int rateWeekEndRegular, int rating,int rateWeekDayReward,int rateWeekEndReward) {
	
		this.hotelName = hotelName;
		this.rateWeekDayRegular = rateWeekDayRegular;
		this.rateWeekEndRegular = rateWeekEndRegular;
		this.rating =rating;
		this.rateWeekDayReward=rateWeekDayReward;
		this.rateWeekEndReward=rateWeekEndReward;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRateWeekDayRegular() {
		return rateWeekDayRegular;
	}

	public void setRateWeekDayRegular(int rateWeekDayRegular) {
		this.rateWeekDayRegular = rateWeekDayRegular;
	}

	public int getRateWeekEndRegular() {
		return rateWeekEndRegular;
	}

	public void setRateWeekEndRegular(int rateWeekEndRegular) {
		this.rateWeekEndRegular = rateWeekEndRegular;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRateWeekDayReward() {
		return rateWeekDayReward;
	}

	public void setRateWeekDayReward(int rateWeekDayReward) {
		this.rateWeekDayReward = rateWeekDayReward;
	}

	public int getRateWeekEndReward() {
		return rateWeekEndReward;
	}

	public void setRateWeekEndReward(int rateWeekEndReward) {
		this.rateWeekEndReward = rateWeekEndReward;
	}

}
