package com.fileio.filteration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	public static final String MALLS_FILE = "data/Largest-Malls.csv";

	// Method to load malls from the original data source
	public static List<Mall> loadMalls() {
		List<Mall> malls = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(MALLS_FILE))) {
			String line;
			// Skip header line
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				Mall mall = Mall.parseFrom(line);
				malls.add(mall);
			}
		} catch (IOException e) {
			// Handle file not found exception
			e.printStackTrace();
		}
		return malls;
	}

	// Method to save malls to a file
	public static void saveMalls(List<Mall> malls, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/" + fileName))) {
			// Write header
			writer.write("id,mallName,country,city,yearOpened,gla,shops\n");
			for (Mall mall : malls) {
				writer.write(mall.parseTo() + "\n");
			}
		} catch (IOException e) {
			// Handle file overwrite exception
			e.printStackTrace();
		}
	}
}
