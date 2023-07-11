package com.fileio.filteration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MallsDemo {
	public static void main(String[] args) {
		// Load all malls from Largest-Malls.csv
		List<Mall> malls = FileManager.loadMalls();

		// Sort malls by country names (ascending) and city names (ascending)
		sort(malls, "country", "asc");
		sort(malls, "city", "asc");
		FileManager.saveMalls(malls, "sorted_by_country_city.csv");

		// Sort malls by the descending order of the number of shops
		sort(malls, "shops", "desc");
		FileManager.saveMalls(malls, "sorted_by_shops_desc.csv");

		// Filter malls by country (China)
		List<Mall> filteredMalls = filterByCountry(malls, "China");
		FileManager.saveMalls(filteredMalls, "filtered_by_country_China.csv");

		// Filter malls by GLA in square feet range [4,000,000;6,000,000]
		filteredMalls = filterByAreaSqFt(malls, 4000000, 6000000);
		FileManager.saveMalls(filteredMalls, "filtered_by_area_sqft_4M_6M.csv");
	}

	// Method to sort malls based on the given field and order
	public static void sort(List<Mall> malls, String fieldName, String order) {
		switch (fieldName) {
		case "country":
			if (order.equals("asc")) {
				Collections.sort(malls, (mall1, mall2) -> mall1.getCountry().compareTo(mall2.getCountry()));
			} else if (order.equals("desc")) {
				Collections.sort(malls, (mall1, mall2) -> mall2.getCountry().compareTo(mall1.getCountry()));
			}
			break;
		case "city":
			if (order.equals("asc")) {
				Collections.sort(malls, (mall1, mall2) -> mall1.getCity().compareTo(mall2.getCity()));
			} else if (order.equals("desc")) {
				Collections.sort(malls, (mall1, mall2) -> mall2.getCity().compareTo(mall1.getCity()));
			}
			break;
		case "shops":
			if (order.equals("asc")) {
				Collections.sort(malls, (mall1, mall2) -> mall1.getShops().compareTo(mall2.getShops()));
			} else if (order.equals("desc")) {
				Collections.sort(malls, (mall1, mall2) -> mall2.getShops().compareTo(mall1.getShops()));
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid field name: " + fieldName);
		}
	}

	// Method to filter malls by country name
	public static List<Mall> filterByCountry(List<Mall> malls, String countryName) {
		List<Mall> filteredMalls = new ArrayList<>();
		for (Mall mall : malls) {
			if (mall.getCountry().equals(countryName)) {
				filteredMalls.add(mall);
			}
		}
		return filteredMalls;
	}

	// Method to filter malls by GLA in square feet range
	public static List<Mall> filterByAreaSqFt(List<Mall> malls, Integer lower, Integer upper) {
		List<Mall> filteredMalls = new ArrayList<>();
		for (Mall mall : malls) {
			Integer glaSqFt = mall.getGlaSqFt();
			if (glaSqFt >= lower && glaSqFt <= upper) {
				filteredMalls.add(mall);
			}
		}
		return filteredMalls;
	}
}
