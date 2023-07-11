package com.fileio.filteration;

public class Mall {
	private String id;
	private String mallName;
	private String country;
	private String city;
	private Integer yearOpened;
	private Integer gla_sqft;
	private Integer gla_sqmt;
	private Integer shops;

	// Constructor
	public Mall(String id, String mallName, String country, String city, Integer yearOpened, Integer gla_sqft,
			Integer gla_sqmt, Integer shops) {
		this.id = id;
		this.mallName = mallName;
		this.country = country;
		this.city = city;
		this.yearOpened = yearOpened;
		this.gla_sqft = gla_sqft;
		this.gla_sqmt = gla_sqmt;
		this.shops = shops;
	}

	// Getters
	public String getId() {
		return id;
	}

	public String getMallName() {
		return mallName;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public Integer getYearOpened() {
		return yearOpened;
	}

	public Integer getGlaSqFt() {
		return gla_sqft;
	}

	public Integer getGlaSqMt() {
		return gla_sqmt;
	}

	public Integer getShops() {
		return shops;
	}

	// Static method to parse string to Mall instance
	public static Mall parseFrom(String mallRecord) {
		String[] fields = mallRecord.split(",");
		String id = fields[0];
		String mallName = fields[1];
		String country = fields[2];
		String city = fields[3];
		Integer yearOpened = Integer.parseInt(fields[4]);
		Integer glaSqFt = Integer.parseInt(fields[5].split("/")[0]);
		Integer glaSqMt = Integer.parseInt(fields[5].split("/")[1]);
		Integer shops = Integer.parseInt(fields[6]);
		return new Mall(id, mallName, country, city, yearOpened, glaSqFt, glaSqMt, shops);
	}

	// Instance method to parse Mall instance to string
	public String parseTo() {
		String gla = gla_sqft + "/" + gla_sqmt;
		return id + "," + mallName + "," + country + "," + city + "," + yearOpened + "," + gla + "," + shops;
	}

	// Static method to parse Mall instance to string
	public static String parseTo(Mall mallInstance) {
		return mallInstance.parseTo();
	}
}
