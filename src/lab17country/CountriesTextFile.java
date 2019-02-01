package lab17country;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountriesTextFile {
	private static Path path = Paths.get("countries.txt");
	
	public CountriesTextFile() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Country> readFile() {
		List<String> lines = null;
		
		try {
			if (Files.notExists(path)) {
				Files.createFile(path);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error! File Not Found!");
		}
		
		try {
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error during reading!");	
		}

		List<Country> country = new ArrayList<>();

		for (String line: lines) {

			String[] s = line.split(" population: ");
			
			Country con = new Country(s[0], Integer.parseInt(s[1]));

			country.add(con);
		}
		return country;
	}
	
	public static void addCountry(Country country) {
			try {
				if (Files.notExists(path)) {
					Files.createFile(path);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error! File Not Found!");
			}

		List<String> countryList = Arrays.asList(country.toString());
		

		try {
			Files.write(path, countryList, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error! Could not add to file!");
		}
	}
}
