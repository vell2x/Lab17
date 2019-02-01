package lab17country;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		String selection;
		boolean flag = true;
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		
		do {
			printMenu();
			System.out.print("What would you like to do?: ");
			selection = scnr.nextLine();
			
			switch (selection) {
			case "1":  printList();
				break;
			case "2": addToFile(scnr);
				break;
			case "3": flag = false;
				break;
			default: System.out.println("Invalid selection! Please try again.");
				break;
			}
		} while(flag);
		System.out.println("Goodbye!");
	}
	
	public static void printMenu() {
		System.out.println("1 - See list of countries");
		System.out.println("2 - Add a country");
		System.out.println("3 - Exit");
	}
	
	public static void printList() {
		List<Country> list = CountriesTextFile.readFile();
		
		for(Country c : list) {
			System.out.print(c);
		}
	}
	
	public static void addToFile(Scanner scnr) {
		String name;
		int pop;
		String clear;
		
		System.out.print("Please enter name of country: "); 

		name = scnr.nextLine();

		do {
			try {
				System.out.print("Please enter population : ");
				pop = scnr.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter digits!");
				clear = scnr.nextLine();
				continue;
			}
			break;
		} while(true);
		Country con = new Country(name, pop);

		CountriesTextFile.addCountry(con);
	}
}
